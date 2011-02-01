package org.richfaces.book.examples.popuppanel;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class SimplePopupBean {
	public Date getNow(){
		return new Date();
	}
	
	public boolean isJustRegistered(){
		return true;
	}
	
}
