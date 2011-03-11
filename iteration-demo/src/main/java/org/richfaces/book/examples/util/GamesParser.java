package org.richfaces.book.examples.util;

import java.net.URL;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.richfaces.book.examples.model.GameDescriptor;

@ManagedBean
@ApplicationScoped
public class GamesParser {

	private List<GameDescriptor> gamesList;

	@XmlRootElement(name = "games")
	private static final class GameDescriptorsHolder {

		private List<GameDescriptor> games;

		@XmlElement(name = "game")
		public List<GameDescriptor> getGameDescriptors() {
			return games;
		}

		@SuppressWarnings("unused")
		public void setGameDescriptors(List<GameDescriptor> games) {
			this.games = games;
		}
	}

	public static void main(String[] args) {
		GamesParser gamesParser = new GamesParser();
		gamesParser.getGameDescriptorsList();
	}

	public synchronized List<GameDescriptor> getGameDescriptorsList() {
		if (gamesList == null) {
			ClassLoader ccl = Thread.currentThread().getContextClassLoader();
			URL resource = ccl.getResource("games.xml");
			JAXBContext context;
			try {
				context = JAXBContext.newInstance(GameDescriptorsHolder.class);
				GameDescriptorsHolder gamesHolder = (GameDescriptorsHolder) context
						.createUnmarshaller().unmarshal(resource);
				gamesList = gamesHolder.getGameDescriptors();
			} catch (JAXBException e) {
				throw new FacesException(e.getMessage(), e);
			}
		}

		return gamesList;
	}

	public List<GameDescriptor> getGamesList() {
		if (gamesList == null){
			gamesList = getGameDescriptorsList();
		}
		return gamesList;
	}

	public void setGamesList(List<GameDescriptor> gamesList) {
		this.gamesList = gamesList;
	}
}
