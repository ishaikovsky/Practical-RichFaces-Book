package org.richfaces.book.examples.model;

import org.richfaces.model.TreeNodeImpl;

public class RichFacesTreeNode extends TreeNodeImpl {
	private String data;

	public RichFacesTreeNode(String data) {
		super();
		this.data = data;
	}
	 
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
