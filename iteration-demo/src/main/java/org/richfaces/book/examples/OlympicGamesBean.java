package org.richfaces.book.examples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.richfaces.book.examples.model.GameDescriptor;

@ManagedBean
@ViewScoped
public class OlympicGamesBean implements Serializable{
	@ManagedProperty(value="#{gamesParser.gamesList}")
	private List<GameDescriptor> games = new ArrayList<GameDescriptor>();

	public void setGames(List<GameDescriptor> games) {
		this.games = games;
	}

	public List<GameDescriptor> getGames() {
		return games;
	}

}
