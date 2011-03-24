package org.richfaces.book.examples;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class StatesSuggestionBean {

	private List<State> statesList;

	private String state; // getter and setter

	@PostConstruct
	public void init() {
		statesList = new ArrayList<State>();
		statesList.add(new State("Alabama", "Montgomery"));
		statesList.add(new State("Alaska", "Juneau"));
		statesList.add(new State("Arizona", "Phoenix"));
		statesList.add(new State("Arkansas", "Little Rock"));
		statesList.add(new State("California", "Sacramento"));
		statesList.add(new State("Colorado", "Denver"));
		statesList.add(new State("Connecticut", "Hartford"));
		statesList.add(new State("Delaware", "Dover"));
		statesList.add(new State("Florida", "Tallahassee"));
		statesList.add(new State("Georgia", "Atlanta"));
		statesList.add(new State("Hawaii", "Honolulu"));
		statesList.add(new State("Idaho", "Boise"));
		statesList.add(new State("Illinois", "Springfield"));
		statesList.add(new State("Indiana", "Indianapolis"));
		statesList.add(new State("Iowa", "Des Moines"));
		statesList.add(new State("Kansas", "Topeka"));
		statesList.add(new State("Kentucky", "Frankfort"));
		statesList.add(new State("Louisiana", "Baton Rouge"));
		statesList.add(new State("Maine", "Augusta"));
		statesList.add(new State("Maryland", "Annapolis"));
		statesList.add(new State("Massachusetts", "Boston"));
		statesList.add(new State("Michigan", "Lansing"));
		statesList.add(new State("Minnesota", "St. Paul"));
		statesList.add(new State("Mississippi", "Jackson"));
		statesList.add(new State("Missouri", "Jefferson City"));
		statesList.add(new State("Montana", "Helena"));
		statesList.add(new State("Nebraska", "Lincoln"));
		statesList.add(new State("Nevada", "Carson City"));
		statesList.add(new State("New Hampshire", "Concord"));
		statesList.add(new State("New Jersey", "Trenton"));
		statesList.add(new State("New Mexico", "Santa Fe"));
		statesList.add(new State("New York", "Albany"));
		statesList.add(new State("North Carolina", "Raleigh"));
		statesList.add(new State("North Dakota", "Bismarck"));
		statesList.add(new State("Ohio", "Columbus"));
		statesList.add(new State("Oklahoma", "Oklahoma City"));
		statesList.add(new State("Oregon", "Salem"));
		statesList.add(new State("Pennsylvania", "Harrisburg"));
		statesList.add(new State("Rhode Island", "Providence"));
		statesList.add(new State("South Carolina", "Columbia"));
		statesList.add(new State("South Dakota", "Pierre"));
		statesList.add(new State("Tennessee", "Nashville"));
		statesList.add(new State("Texas", "Austin"));
		statesList.add(new State("Utah", "Salt Lake City"));
		statesList.add(new State("Vermont", "Montpelier"));
		statesList.add(new State("Virginia", "Richmond"));
		statesList.add(new State("Washington", "Olympia"));
		statesList.add(new State("West Virginia", "Charleston"));
		statesList.add(new State("Wisconsin", "Madison"));
		statesList.add(new State("Wyoming", "Cheyenne"));
	}

	public ArrayList<State> suggest(String input) {
		ArrayList<State> result = new ArrayList<State>();
		for (State state : statesList) {
			if ((state.getName().toLowerCase()).startsWith(input.toLowerCase()))
				result.add(state);
		}
		return result;
	}

	public List<State> getStatesList() {
		return statesList;
	}
}
