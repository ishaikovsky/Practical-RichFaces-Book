package org.richfaces.book.examples.tooltip;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Tooltip {
	private int counter = 0;

	public Date getNow() {
		return new Date();
	}

	public int getCounter() {
		return ++counter;
	}
}
