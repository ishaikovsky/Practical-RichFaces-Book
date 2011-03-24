package org.richfaces.book.examples;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AutocompleteBean {
	private List<String> suggestions = null;

	public AutocompleteBean() {
		suggestions = new ArrayList<String>();
		suggestions.add("Banana");
		suggestions.add("Cranberry");
		suggestions.add("Blueberry");
		suggestions.add("Orange");
		suggestions.add("Apple");
		suggestions.add("Strawberry");
	}

	public List<String> autocomplete(String prefix) {
		List<String> result = new ArrayList<String>();
		for (String suggestion : suggestions) {
			if (suggestion.startsWith(prefix)) {
				result.add(suggestion);
			}
		}
		return result;
	}

	public List<String> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<String> suggestions) {
		this.suggestions = suggestions;
	}
}
