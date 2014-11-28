package es.sidelab.ejemplorest2;

import java.util.List;

public class Team {

	private List<Player> players;
	private String name;

	public Team(String name, List<Player> players) {
		this.name = name;
		this.players = players;
	}

	public List<Player> getPlayers() {
		return players;
	}
	
	public String getName() {
		return name;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	

	public void setName(String name) {
		this.name = name;
	}
}
