package org.richfaces.book.examples;

import org.richfaces.model.SwingTreeNodeImpl;

public class FileSystemNode extends SwingTreeNodeImpl<Object> {
    private String label;

    public FileSystemNode(String label) {
        this.label = label;
    }

    public String getNodeType() {
        return isLeaf() ? "leaf" : "node";
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
