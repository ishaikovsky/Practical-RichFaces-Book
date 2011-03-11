package org.richfaces.book.examples;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.richfaces.book.examples.model.Airline;

@ManagedBean
@RequestScoped
public class AirlinesBean {
	private List<Airline> airlines;

	@PostConstruct
	public void init() {
		airlines = new ArrayList<Airline>();
		airlines.add(new Airline("American Airlines", "AA"));
		airlines.add(new Airline("United Airlines", "UA"));
		airlines.add(new Airline("Delta", "DL"));
		airlines.add(new Airline("Northwest Airlines", "NW"));
		airlines.add(new Airline("US Airways", "US"));
		airlines.add(new Airline("Continental", "CO"));
	}

	public List<Airline> getAirlines() {
		return airlines;
	}

	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}

}
