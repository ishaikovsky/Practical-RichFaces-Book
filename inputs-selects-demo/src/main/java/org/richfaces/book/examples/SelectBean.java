package org.richfaces.book.examples;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
public class SelectBean {
	private static final String[] FRUITS = { "Banana", "Cranberry",
			"Blueberry", "Orange" };
	private static final String[] VEGETABLES = { "Potatoes", "Broccoli",
			"Garlic", "Carrot" };
	private String currentItem = null;
	private String value = null;
	private String currentType = null;
	private List<SelectItem> firstList = new ArrayList<SelectItem>();
	private List<SelectItem> secondList = new ArrayList<SelectItem>();

	public SelectBean() {
		SelectItem item = new SelectItem("fruits", "Fruits");
		firstList.add(item);
		item = new SelectItem("vegetables", "Vegetables");
		firstList.add(item);
		for (int i = 0; i < FRUITS.length; i++) {
			item = new SelectItem(FRUITS[i]);
		}
	}

	public void valueChanged(ValueChangeEvent event) {
		secondList.clear();
		if (null != event.getNewValue()) {
			String[] currentItems;
			if (((String) event.getNewValue()).equals("fruits")) {
				currentItems = FRUITS;
			} else {
				currentItems = VEGETABLES;
			}
			for (int i = 0; i < currentItems.length; i++) {
				SelectItem item = new SelectItem(currentItems[i]);
				secondList.add(item);
			}
		}
	}

	// Getters and setters
	public String getCurrentItem() {
		return currentItem;
	}

	public void setCurrentItem(String currentItem) {
		this.currentItem = currentItem;
	}

	public String getCurrentType() {
		return currentType;
	}

	public void setCurrentType(String currentType) {
		this.currentType = currentType;
	}

	public List<SelectItem> getFirstList() {
		return firstList;
	}

	public List<SelectItem> getSecondList() {
		return secondList;
	}
	public String getValue() {
		return value;
	}
}
