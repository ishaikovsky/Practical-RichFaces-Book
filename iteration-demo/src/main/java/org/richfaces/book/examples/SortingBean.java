package org.richfaces.book.examples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.richfaces.book.examples.model.GameDescriptor;
import org.richfaces.component.SortOrder;

@ManagedBean
@ViewScoped
public class SortingBean implements Serializable{
	private Map<String, SortOrder> sortOrders = new HashMap<String, SortOrder>();
	private Map<String, SortOrder> sortOrdersMultiple = new HashMap<String, SortOrder>();
	private List<String> sortPriorities = new ArrayList<String>();
	private static final String SORT_PROPERTY = "sortProperty";

	public void resetSorting() {
		this.sortOrdersMultiple.clear();
		this.sortPriorities.clear();
	}

	private void modifySortProperty(Map<String, SortOrder> orders,
			String sortProperty, SortOrder currentOrder) {
		if ((currentOrder == null) || (currentOrder == SortOrder.ascending)) {
			orders.put(sortProperty, SortOrder.descending);
		} else {
			orders.put(sortProperty, SortOrder.ascending);
		}
	}

	private String getSortProperty() {
		String sortProperty = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get(
						SORT_PROPERTY);
		return sortProperty;
	}

	public Comparator<GameDescriptor> getYearComparator() {
		return new Comparator<GameDescriptor>() {
			@Override
			public int compare(GameDescriptor o1, GameDescriptor o2) {
				return o1.getFromDate().compareTo(o2.getFromDate());
			}

		};
	}

	public void sortMultiple() {
		String sortProperty = getSortProperty();
		SortOrder currentOrder = sortOrdersMultiple.get(sortProperty);
		modifySortProperty(sortOrdersMultiple, sortProperty, currentOrder);
		if (!sortPriorities.contains(sortProperty))
			sortPriorities.add(sortProperty);
	}

	public void sort() {
		String sortProperty = getSortProperty();
		SortOrder currentOrder = sortOrders.get(sortProperty);
		sortOrders.clear();
		modifySortProperty(sortOrders, sortProperty, currentOrder);
	}

	public Map<String, SortOrder> getSortOrders() {
		return sortOrders;
	}

	public void setSortOrders(Map<String, SortOrder> sortOrders) {
		this.sortOrders = sortOrders;
	}

	public void setSortOrdersMultiple(Map<String, SortOrder> sortOrdersMultiple) {
		this.sortOrdersMultiple = sortOrdersMultiple;
	}

	public Map<String, SortOrder> getSortOrdersMultiple() {
		return sortOrdersMultiple;
	}

	public List<String> getSortPriorities() {
		return sortPriorities;
	}

	public void setSortPriorities(List<String> priorities) {
		this.sortPriorities = priorities;
	}
}
