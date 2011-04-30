package org.richfaces.book.examples;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.richfaces.book.examples.model.RichFacesTreeNode;
import org.richfaces.component.UITree;
import org.richfaces.event.TreeToggleEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

@ManagedBean
@ViewScoped
public class LazyTreeBean {
	
	private TreeNode rootNode = null;

	public void initNodes() {
		rootNode = new TreeNodeImpl();
		RichFacesTreeNode node = new RichFacesTreeNode("Node 1");
		rootNode.addChild("1", node);
		node = new RichFacesTreeNode("Node 2");
		rootNode.addChild("2", node);
		node = new RichFacesTreeNode("Node 3");
		rootNode.addChild("3", node);
		node = new RichFacesTreeNode("Node 4");
		rootNode.addChild("4", node);
	}

	public void toggleListener(TreeToggleEvent event) {
		UITree tree = (UITree) event.getComponent();
		RichFacesTreeNode modelNode = (RichFacesTreeNode)tree.getRowData();
		for (int i = 0; i < 5; i++) {
			RichFacesTreeNode node = new RichFacesTreeNode(modelNode.getData() + "." + i);
			modelNode.addChild(i, node);
		}
	}

	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}

	public TreeNode getRootNode() {
		if (rootNode == null) {
			initNodes();
		}
		return rootNode;
	}

}
