package org.richfaces.book.examples;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.richfaces.book.examples.model.SimpleTreeNodeTypes;
import org.richfaces.book.examples.model.TypifiedRichFacesTreeNode;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

@ManagedBean
@ViewScoped
public class TypifiedRichFacesTreeNodeBean {

	private TreeNode rootNode = null;

	public void initNodes() {
		//fake node. all the direct children nodes will be root nodes.
		rootNode = new TreeNodeImpl();

		TypifiedRichFacesTreeNode node = new TypifiedRichFacesTreeNode("Desktop Type", SimpleTreeNodeTypes.NODE);
		node.addChild("1_1",new TypifiedRichFacesTreeNode("Compact", SimpleTreeNodeTypes.LEAF));
		node.addChild("1_2",new TypifiedRichFacesTreeNode("Everyday", SimpleTreeNodeTypes.LEAF));
		node.addChild("1_3",new TypifiedRichFacesTreeNode("Gaming", SimpleTreeNodeTypes.LEAF));
		node.addChild("1_4",new TypifiedRichFacesTreeNode("Premium", SimpleTreeNodeTypes.LEAF));
		rootNode.addChild("1",node);

		node = new TypifiedRichFacesTreeNode("Customer Reviews", SimpleTreeNodeTypes.NODE);
		node.addChild("2_1",new TypifiedRichFacesTreeNode("Top Rated", SimpleTreeNodeTypes.LEAF));
		rootNode.addChild("2",node);

		node = new TypifiedRichFacesTreeNode("Current Offers", SimpleTreeNodeTypes.NODE);
		node.addChild("3_1",new TypifiedRichFacesTreeNode("On Sale", SimpleTreeNodeTypes.LEAF));
		node.addChild("3_2",new TypifiedRichFacesTreeNode("Special Offers", SimpleTreeNodeTypes.LEAF));
		node.addChild("3_3",new TypifiedRichFacesTreeNode("Package Deals", SimpleTreeNodeTypes.LEAF));
		node.addChild("3_4",new TypifiedRichFacesTreeNode("Financing offers", SimpleTreeNodeTypes.LEAF));
		node.addChild("3_5",new TypifiedRichFacesTreeNode("Outlet Center", SimpleTreeNodeTypes.LEAF));
		rootNode.addChild("3",node);

		node = new TypifiedRichFacesTreeNode("Availability", SimpleTreeNodeTypes.NODE);
		node.addChild("4_1",new TypifiedRichFacesTreeNode("In store & Online", SimpleTreeNodeTypes.LEAF));
		node.addChild("4_2",new TypifiedRichFacesTreeNode("Online only", SimpleTreeNodeTypes.LEAF));
		rootNode.addChild("4",node);

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
