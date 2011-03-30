package org.richfaces.book.examples;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.richfaces.book.examples.model.SalesItem;

@ManagedBean
@ViewScoped
public class SalesReport {
	List<SalesItem> items = null;
	private List<Integer> updatedItems = new ArrayList<Integer>();

	public List<SalesItem> getItems() {
		if (items == null)
			initData();
		return items;
	}

	public void setItems(List<SalesItem> items) {
		this.items = items;
	}

	private void initData() {
		items = new ArrayList<SalesItem>();
		items.add(new SalesItem(1, 20.00));
		items.add(new SalesItem(2, 10.00));
		items.add(new SalesItem(3, 20.00));
		items.add(new SalesItem(4, 20.00));
	}

	public void addDiscounts() {
		for (SalesItem item : items) {
			if (item.getProposedGrossMargin() < 0) {
				item.setDiscount(0.2);
				updatedItems.add(items.indexOf(item));
			}
		}
	}


	public void setUpdatedItems(List<Integer> updatedItems) {
		this.updatedItems = updatedItems;
	}

	public List<Integer> getUpdatedItems() {
		return updatedItems;
	}
}
