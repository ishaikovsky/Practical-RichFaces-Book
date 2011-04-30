package org.richfaces.book.examples.model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.TreeNode;

import com.google.common.collect.Iterators;

public class SwingTreeNodeImpl implements TreeNode {
	private List<SwingTreeNodeImpl> childNodes;
	private String data;

	public SwingTreeNodeImpl(String data) {
		super();
		this.data = data;
	}

	public void addChild(SwingTreeNodeImpl child) {
		if (child != null) {
			if (childNodes == null) {
				childNodes = new ArrayList<SwingTreeNodeImpl>();
			}
			childNodes.add(child);
		}
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return (childNodes == null) ? null : childNodes.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return (childNodes == null) ? null : childNodes.size();
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public int getIndex(TreeNode node) {
		return (childNodes == null) ? null : childNodes.indexOf(node);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return (childNodes == null);
	}

	@Override
	public Enumeration children() {
		return Iterators.asEnumeration(childNodes.iterator());
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data;
	}

}
