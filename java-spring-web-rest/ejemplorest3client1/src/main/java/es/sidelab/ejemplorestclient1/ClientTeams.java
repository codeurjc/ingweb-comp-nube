package es.sidelab.ejemplorestclient1;

import java.util.List;

import retrofit.RestAdapter;

public class ClientTeams {

	public static void main(String[] args) {

		RestAdapter adapter = new RestAdapter.Builder().setEndpoint(
				"http://localhost:8080").build();

		TeamsService service = adapter.create(TeamsService.class);

		List<Team> teams = service.getTeams();

		for (Team team : teams) {
			System.out.println(team);
		}
	}
}
