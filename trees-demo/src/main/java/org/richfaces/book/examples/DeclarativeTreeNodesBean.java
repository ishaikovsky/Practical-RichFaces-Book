package org.richfaces.book.examples;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.richfaces.book.examples.model.Entry;

@ManagedBean
@SessionScoped
public class DeclarativeTreeNodesBean {
	
	private List<Entry> entries = null;
	
	public void initEntries(){
		entries = new ArrayList<Entry>();
		
		Entry entry = new Entry("Desktop Type");
		List<String> childEntries = new ArrayList<String>();
		childEntries.add("Compact");
		childEntries.add("Everyday");
		childEntries.add("Gaming");
		childEntries.add("Premium");
		entry.setProperties(childEntries);
		entries.add(entry);
		
		entry = new Entry("Customer Reviews");
		childEntries = new ArrayList<String>();
		childEntries.add("Top Rated");
		entry.setProperties(childEntries);		
		entries.add(entry);

		entry = new Entry("Current Offers");
		childEntries = new ArrayList<String>();
		childEntries.add("On Sale");
		childEntries.add("Special Offers");
		childEntries.add("Package Deals");
		childEntries.add("Financing offers");
		childEntries.add("Outlet Center");
		entry.setProperties(childEntries);		
		entries.add(entry);
		
		entry = new Entry("Availability");
		childEntries = new ArrayList<String>();
		childEntries.add("In store & Online");
		childEntries.add("Online only");
		entry.setProperties(childEntries);		
		entries.add(entry);
		
	}
	public List<Entry> getEntries() {
		if (entries == null) {
			initEntries();
		}
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

}
