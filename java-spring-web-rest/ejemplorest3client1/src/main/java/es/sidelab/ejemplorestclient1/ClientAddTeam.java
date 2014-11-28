package es.sidelab.ejemplorestclient1;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;

public class ClientAddTeam {

	public static void main(String[] args) {

		RestAdapter adapter = new RestAdapter.Builder().setEndpoint(
				"http://localhost:8080").build();

		TeamsService service = adapter.create(TeamsService.class);

		List<Player> players = new ArrayList<Player>();
		players.add(new Player("M.A.","Barracus"));
		players.add(new Player("Murdock","Crazy"));
		Team team = new Team("Equipo A", players);

		boolean created = service.addTeam(team);

		System.out.println("Created: "+created);

		Team newTeam = service.getTeam("Equipo A");

		System.out.println(newTeam);
	}
}
