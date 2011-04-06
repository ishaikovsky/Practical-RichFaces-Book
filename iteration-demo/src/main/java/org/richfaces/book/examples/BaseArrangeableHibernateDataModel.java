package org.richfaces.book.examples;

import java.util.List;

import javax.el.ELException;
import javax.el.Expression;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;

import org.ajax4jsf.model.DataVisitor;
import org.ajax4jsf.model.ExtendedDataModel;
import org.ajax4jsf.model.Range;
import org.ajax4jsf.model.SequenceRange;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.richfaces.book.examples.model.BaseDescriptor;
import org.richfaces.component.SortOrder;
import org.richfaces.model.Arrangeable;
import org.richfaces.model.ArrangeableState;
import org.richfaces.model.FilterField;
import org.richfaces.model.SortField;

public abstract class BaseArrangeableHibernateDataModel<T extends BaseDescriptor> extends
		ExtendedDataModel<T> implements Arrangeable {

	private Class<T> entityClass;

	public BaseArrangeableHibernateDataModel(Class<T> entityClass) {
		super();
		this.entityClass = entityClass;
	}

	private Integer rowKey;

	private SequenceRange cachedRange;

	private List<T> cachedItems;

	private List<FilterField> filterFields;

	private List<SortField> sortFields;

	private static boolean areEqualRanges(SequenceRange range1,
			SequenceRange range2) {
		if (range1 == null || range2 == null) {
			return range1 == null && range2 == null;
		} else {
			return range1.getFirstRow() == range2.getFirstRow()
					&& range1.getRows() == range2.getRows();
		}
	}

	private Criteria createCriteria() {
		return getSession().createCriteria(entityClass);
	}

	private void appendFilters(FacesContext context, Criteria criteria) {
		if (filterFields != null) {
			for (FilterField filterField : filterFields) {
				String propertyName = getPropertyName(context,
						filterField.getFilterExpression());
				String filterValue = filterField.getFilterValue().toString();
				if (filterValue != null && filterValue.length() != 0) {
					criteria.add(Restrictions.like(propertyName, filterValue,
							MatchMode.ANYWHERE).ignoreCase());
				}
			}
		}
	}

	private void appendSorts(FacesContext context, Criteria criteria) {
		if (sortFields != null) {
			for (SortField sortField : sortFields) {
				SortOrder ordering = sortField.getSortOrder();
				if (SortOrder.ascending.equals(ordering)
						|| SortOrder.descending.equals(ordering)) {
					String propertyName = getPropertyName(context,
							sortField.getSortBy());
					Order order = SortOrder.ascending.equals(ordering) ? Order
							.asc(propertyName) : Order.desc(propertyName);
					criteria.addOrder(order.ignoreCase());
				}
			}
		}
	}

	private String getPropertyName(FacesContext facesContext,
			Expression expression) {
		try {
			return (String) ((ValueExpression) expression)
					.getValue(facesContext.getELContext());
		} catch (ELException e) {
			throw new FacesException(e.getMessage(), e);
		}
	}

	@Override
	public Object getRowKey() {
		return rowKey;
	}

	@Override
	public void setRowKey(Object key) {
		this.rowKey = (Integer)key;
	}

	@Override
	public void walk(FacesContext facesContext, DataVisitor visitor,
			Range range, Object argument) {

		SequenceRange sequenceRange = (SequenceRange) range;

		if (this.cachedItems == null
				|| !areEqualRanges(this.cachedRange, sequenceRange)) {
			Criteria criteria = createCriteria();
			appendFilters(facesContext, criteria);
			appendSorts(facesContext, criteria);

			if (sequenceRange != null) {
				int first = sequenceRange.getFirstRow();
				int rows = sequenceRange.getRows();

				criteria.setFirstResult(first);
				if (rows > 0) {
					criteria.setMaxResults(rows);
				}
			}

			this.cachedRange = sequenceRange;
			this.cachedItems = criteria.list();
		}

		for (T item : this.cachedItems) {
			visitor.process(facesContext, item.getId(), argument);
		}
	}

	@Override
	public int getRowCount() {
		Criteria criteria = createCriteria();
		appendFilters(FacesContext.getCurrentInstance(), criteria);
		return (Integer) criteria.list().size();
	}

	@Override
	public T getRowData() {
		for (T t : cachedItems) {
			if (t.getId()==this.getRowKey()){
				return t;
			}
		};
		return null;
	}

	@Override
	public int getRowIndex() {
		return -1;
	}

	@Override
	public Object getWrappedData() {
		return null;
	}

	@Override
	public boolean isRowAvailable() {
		return (getRowData()!=null);
	}

	@Override
	public void setRowIndex(int rowIndex) {
	}

	@Override
	public void setWrappedData(Object data) {
	}

	public void arrange(FacesContext facesContext, ArrangeableState state) {
		if (state != null) {
			this.filterFields = state.getFilterFields();
			this.sortFields = state.getSortFields();
			this.cachedItems = null;
			this.cachedRange = null;
		}
	}

	protected abstract Session getSession();
}
