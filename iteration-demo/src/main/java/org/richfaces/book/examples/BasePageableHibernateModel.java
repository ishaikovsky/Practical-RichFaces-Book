package org.richfaces.book.examples;

import java.util.List;

import javax.faces.context.FacesContext;

import org.ajax4jsf.model.DataVisitor;
import org.ajax4jsf.model.ExtendedDataModel;
import org.ajax4jsf.model.Range;
import org.ajax4jsf.model.SequenceRange;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.richfaces.book.examples.common.HibernateUtils;
import org.richfaces.book.examples.model.BaseDescriptor;

public abstract class BasePageableHibernateModel<T extends BaseDescriptor> extends ExtendedDataModel<T> {
    protected Class<T> entityClass;
    protected SequenceRange cachedRange = null;
    protected Integer cachedRowCount = null;

    protected List<T> cachedItems = null;
    protected Integer rowKey;

    public BasePageableHibernateModel(Class<T> entityClass) {
        super();
        this.entityClass = entityClass;
    }

    protected Criteria createCriteria(Session session) {
        return session.createCriteria(entityClass);
    }

    protected static boolean areEqualRanges(SequenceRange range1, SequenceRange range2) {
        if (range1 == null || range2 == null) {
            return range1 == null && range2 == null;
        } else {
            return range1.getFirstRow() == range2.getFirstRow() && range1.getRows() == range2.getRows();
        }
    }

    @Override
    public Object getRowKey() {
        return rowKey;
    }

    @Override
    public void setRowKey(Object key) {
        this.rowKey = (Integer) key;
    }

    @Override
    public void walk(FacesContext facesContext, DataVisitor visitor, Range range, Object argument) {

        SequenceRange sequenceRange = (SequenceRange) range;

        if (this.cachedItems == null || !areEqualRanges(this.cachedRange, sequenceRange)) {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Criteria criteria = createCriteria(session);
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
            session.close();
        }

        for (T item : this.cachedItems) {
            visitor.process(facesContext, item.getId(), argument);
        }
    }

    @Override
    public int getRowCount() {
        if (this.cachedRowCount == null) {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Criteria criteria = createCriteria(session);
            cachedRowCount = criteria.list().size();
            session.close();
        }
        return this.cachedRowCount;
    }

    @Override
    public T getRowData() {
        for (T t : cachedItems) {
            if (t.getId() == this.getRowKey()) {
                return t;
            }
        }
        ;
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
        return (getRowData() != null);
    }

    @Override
    public void setRowIndex(int rowIndex) {
    }

    @Override
    public void setWrappedData(Object data) {
    }

}
