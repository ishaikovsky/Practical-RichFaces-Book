package org.richfaces.book.examples.popuppanel;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AirlinesBean {
	private Airline selected;
	private List<Airline> airlines;

	public AirlinesBean() {
		airlines = new ArrayList<Airline>();
		airlines.add(new Airline("American Airlines", "AA"));
		airlines.add(new Airline("United Airlines", "UA"));
		airlines.add(new Airline("Delta", "DD"));
		airlines.add(new Airline("Northwest Airlines", "NW"));
		airlines.add(new Airline("US Airways", "US"));
	}

	public Airline getSelected() {
		return selected;
	}

	public void setSelected(Airline selected) {
		this.selected = selected;
	}

	public List<Airline> getAirlines() {
		return airlines;
	}

	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}
}
