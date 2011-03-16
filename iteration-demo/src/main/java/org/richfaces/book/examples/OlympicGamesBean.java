package org.richfaces.book.examples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;
import javax.faces.event.AjaxBehaviorEvent;

import org.richfaces.book.examples.model.GameDescriptor;
import org.richfaces.component.UIExtendedDataTable;

@ManagedBean
@ViewScoped
public class OlympicGamesBean implements Serializable{
	@ManagedProperty(value="#{gamesParser.gamesList}")
	private List<GameDescriptor> games = new ArrayList<GameDescriptor>();
	private Map<String, List<GameDescriptor>> gamesMap;
	private Collection<Object> selection = null;
	private List<GameDescriptor> selectedGames = null;
	public Map<String, List<GameDescriptor>> getGamesMap(){
		if (gamesMap==null){
			gamesMap = new HashMap<String, List<GameDescriptor>>();
			for (GameDescriptor game : games) {
				List<GameDescriptor> gamesFromMap = gamesMap.get(game.getContinent());
				if (gamesFromMap == null){
					gamesFromMap = new ArrayList<GameDescriptor>();
				}
				gamesFromMap.add(game);
				gamesMap.put(game.getContinent(), gamesFromMap);
			}
		}
		return gamesMap;
	}
	
	public List<String> getGamesMapKeys(){
		Map<String, List<GameDescriptor>> map = getGamesMap();
		List<String> continents = new ArrayList<String>();
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()){
			continents.add(it.next());
		}
		Collections.sort(continents);
		return continents;
	}
	
	public void showSelectionDetails(AjaxBehaviorEvent event){
		UIExtendedDataTable table = (UIExtendedDataTable)event.getComponent();
		selectedGames = new ArrayList<GameDescriptor>();
		Object storedRowKey = table.getRowKey();
		for (Object rowKey : selection) {
			table.setRowKey(rowKey);
			selectedGames.add((GameDescriptor)table.getRowData());
		}
		table.setRowKey(storedRowKey);
	}
	
	public void setSelectedGames(List<GameDescriptor> selectedGames) {
		this.selectedGames = selectedGames;
	}
	
	public List<GameDescriptor> getSelectedGames() {
		return selectedGames;
	}
	
	public Collection<Object> getSelection() {
		return selection;
	}
	
	public void setSelection(Collection<Object> selection) {
		this.selection = selection;
	}
	
	public void setGames(List<GameDescriptor> games) {
		this.games = games;
	}

	public List<GameDescriptor> getGames() {
		return games;
	}

}
