package org.richfaces.book.examples;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.richfaces.book.examples.model.SwingTreeNodeImpl;

@ManagedBean
@ViewScoped
public class SwingTreeNodeBean {

	List<SwingTreeNodeImpl> rootNodes = null;

	public void initNodes() {
		rootNodes = new ArrayList<SwingTreeNodeImpl>();

		SwingTreeNodeImpl node = new SwingTreeNodeImpl("Desktop Type");
		node.addChild(new SwingTreeNodeImpl("Compact"));
		node.addChild(new SwingTreeNodeImpl("Everyday"));
		node.addChild(new SwingTreeNodeImpl("Gaming"));
		node.addChild(new SwingTreeNodeImpl("Premium"));
		rootNodes.add(node);

		node = new SwingTreeNodeImpl("Customer Reviews");
		node.addChild(new SwingTreeNodeImpl("Top Rated"));
		rootNodes.add(node);

		node = new SwingTreeNodeImpl("Current Offers");
		node.addChild(new SwingTreeNodeImpl("On Sale"));
		node.addChild(new SwingTreeNodeImpl("Special Offers"));
		node.addChild(new SwingTreeNodeImpl("Package Deals"));
		node.addChild(new SwingTreeNodeImpl("Financing offers"));
		node.addChild(new SwingTreeNodeImpl("Outlet Center"));
		rootNodes.add(node);

		node = new SwingTreeNodeImpl("Availability");
		node.addChild(new SwingTreeNodeImpl("In store & Online"));
		node.addChild(new SwingTreeNodeImpl("Online only"));
		rootNodes.add(node);

	}

	public void setRootNodes(List<SwingTreeNodeImpl> rootNodes) {
		this.rootNodes = rootNodes;
	}

	public List<SwingTreeNodeImpl> getRootNodes() {
		if (rootNodes == null){
			initNodes();
		}
		return rootNodes;
	}
}
