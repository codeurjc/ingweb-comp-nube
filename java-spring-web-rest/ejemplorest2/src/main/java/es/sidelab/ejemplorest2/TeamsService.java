package es.sidelab.ejemplorest2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class TeamsService {

	private Map<String, Team> teamMap = new HashMap<String, Team>();

	public TeamsService() {
		createDummyTeams();
	}

	public Team getTeam(String name) {
		return teamMap.get(name);
	}

	public List<Team> getTeams() {
		return new ArrayList<Team>(teamMap.values());
	}

	public void createDummyTeams() {

		List<Team> teams = new ArrayList<Team>();

		Player burns = new Player("George Burns", "George");
		Player allen = new Player("Gracie Allen", "Gracie");

		List<Player> ba = new ArrayList<Player>();
		ba.add(burns);
		ba.add(allen);

		Team burnsAndAllen = new Team("Burns and Allen", ba);
		teams.add(burnsAndAllen);

		Player abbott = new Player("William Abbott", "Bud");
		Player costello = new Player("Louis Cristillo", "Lou");

		List<Player> ac = new ArrayList<Player>();
		ac.add(abbott);
		ac.add(costello);

		Team abbottAndCostello = new Team("Abbott and Costello", ac);
		teams.add(abbottAndCostello);

		Player chico = new Player("Leonard Marx", "Chico");
		Player groucho = new Player("Julius Marx", "Groucho");
		Player harpo = new Player("Adolph Marx", "Harpo");

		List<Player> mb = new ArrayList<Player>();
		mb.add(chico);
		mb.add(groucho);
		mb.add(harpo);

		Team marxBrothers = new Team("Marx Brothers", mb);
		teams.add(marxBrothers);

		for (Team team : teams) {
			teamMap.put(team.getName(), team);
		}
	}
}
