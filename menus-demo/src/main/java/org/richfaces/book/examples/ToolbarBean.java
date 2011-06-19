package org.richfaces.book.examples;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@ViewScoped
public class ToolbarBean implements Serializable{
	private boolean nyc = true;
	private boolean sf = false;
	private boolean la = false;

	public void cityListener(ActionEvent event){
		if (event.getComponent().getId().equals("nyc")) nyc = true; else nyc = false; 
		if (event.getComponent().getId().equals("sf")) sf = true; else sf = false; 
		if (event.getComponent().getId().equals("la")) la = true; else la = false; 
	}

	public boolean isNyc() {
		return nyc;
	}

	public void setNyc(boolean nyc) {
		this.nyc = nyc;
	}

	public boolean isSf() {
		return sf;
	}

	public void setSf(boolean sf) {
		this.sf = sf;
	}

	public boolean isLa() {
		return la;
	}

	public void setLa(boolean la) {
		this.la = la;
	}


}
