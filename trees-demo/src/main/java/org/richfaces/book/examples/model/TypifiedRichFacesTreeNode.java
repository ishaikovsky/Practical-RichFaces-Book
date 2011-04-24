package org.richfaces.book.examples.model;

import org.richfaces.model.TreeNodeImpl;

public class TypifiedRichFacesTreeNode extends TreeNodeImpl {
   private String data;
   private SimpleTreeNodeTypes type;

   public TypifiedRichFacesTreeNode(String data, SimpleTreeNodeTypes type) {
      super(type.equals(SimpleTreeNodeTypes.LEAF));
      this.data = data;
      this.type = type;
   }

   public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }

   public SimpleTreeNodeTypes getType() {
      return type;
   }

   public void setType(SimpleTreeNodeTypes type) {
      this.type = type;
   }
}
