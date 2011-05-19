package org.richfaces.book.examples;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.richfaces.event.DropEvent;
import org.richfaces.model.SwingTreeNodeImpl;

@ManagedBean
@SessionScoped
public class TreeDnDBean {
    private List<SwingTreeNodeImpl<Object>> nodes;
    
    public TreeDnDBean() {
        nodes = new ArrayList<SwingTreeNodeImpl<Object>>();
        for (Integer i = 1; i < 5; i++) {
            FileSystemNode rootNode = new FileSystemNode("folder " + i);
            for (Integer j = 1; j <= 5; j++) {
                FileSystemNode leafNode = new FileSystemNode("pic" + i + "." + j + ".jpg");
                rootNode.addChild(leafNode);
            }
            nodes.add(rootNode);
        }
    }

    public void moveFile(DropEvent event) {
        FileSystemNode draggedNode = (FileSystemNode) event.getDragValue();
        FileSystemNode droppedNode = (FileSystemNode) event.getDropValue();
        ((FileSystemNode) draggedNode.getParent()).removeChild(draggedNode);
        droppedNode.addChild(draggedNode);
    }

    public List<SwingTreeNodeImpl<Object>> getNodes() {
        return nodes;
    }
}
