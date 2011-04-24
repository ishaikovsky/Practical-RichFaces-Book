package org.richfaces.book.examples;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.richfaces.book.examples.model.RichFacesTreeNode;
import org.richfaces.component.UITree;
import org.richfaces.event.TreeSelectionChangeEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

@ManagedBean
@ViewScoped
public class RichFacesTreeNodeBean {

	private TreeNode rootNode = null;
	private List<String> selection = new ArrayList<String>();
	public void selectionChanged(TreeSelectionChangeEvent event){
	    selection.clear();
 	    UITree tree = (UITree)event.getComponent();
        Object storedRowKey = tree.getRowKey();
	    for (Object rowKey : event.getNewSelection()) {
	        tree.setRowKey(rowKey);
	        selection.add(((RichFacesTreeNode)tree.getRowData()).getData());
        }
	    tree.setRowKey(storedRowKey);
	}
	
	public void initNodes() {
		//fake node. all the direct children nodes will be root nodes.
		rootNode = new TreeNodeImpl();

		RichFacesTreeNode node = new RichFacesTreeNode("Desktop Type");
		node.addChild("1_1",new RichFacesTreeNode("Compact"));
		node.addChild("1_2",new RichFacesTreeNode("Everyday"));
		node.addChild("1_3",new RichFacesTreeNode("Gaming"));
		node.addChild("1_4",new RichFacesTreeNode("Premium"));
		rootNode.addChild("1",node);

		node = new RichFacesTreeNode("Customer Reviews");
		node.addChild("2_1",new RichFacesTreeNode("Top Rated"));
		rootNode.addChild("2",node);

		node = new RichFacesTreeNode("Current Offers");
		node.addChild("3_1",new RichFacesTreeNode("On Sale"));
		node.addChild("3_2",new RichFacesTreeNode("Special Offers"));
		node.addChild("3_3",new RichFacesTreeNode("Package Deals"));
		node.addChild("3_4",new RichFacesTreeNode("Financing offers"));
		node.addChild("3_5",new RichFacesTreeNode("Outlet Center"));
		rootNode.addChild("3",node);

		node = new RichFacesTreeNode("Availability");
		node.addChild("4_1",new RichFacesTreeNode("In store & Online"));
		node.addChild("4_2",new RichFacesTreeNode("Online only"));
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

    public List<String> getSelection() {
        return selection;
    }

    public void setSelection(List<String> selection) {
        this.selection = selection;
    }
}
