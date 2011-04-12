package org.richfaces.book.examples;

import java.util.Iterator;

import javax.faces.convert.Converter;

import org.richfaces.book.examples.model.RichFacesTreeNode;
import org.richfaces.model.TreeDataModel;
import org.richfaces.model.TreeDataModelTuple;

public class RichFacesTreeModel implements TreeDataModel<RichFacesTreeNode>{

	@Override
	public Object getRowKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRowKey(Object rowKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDataAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RichFacesTreeNode getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<TreeDataModelTuple> children() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getParentRowKey(Object rowKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getWrappedData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setWrappedData(Object data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TreeDataModelTuple createSnapshot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void restoreFromSnapshot(TreeDataModelTuple tuple) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Converter getRowKeyConverter() {
		// TODO Auto-generated method stub
		return null;
	}

}
