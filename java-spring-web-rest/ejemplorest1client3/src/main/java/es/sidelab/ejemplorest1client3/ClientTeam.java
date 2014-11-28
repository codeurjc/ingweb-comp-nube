package es.sidelab.ejemplorest1client3;

import retrofit.RestAdapter;

public class ClientTeam {

	public static void main(String[] args) {

		RestAdapter adapter = new RestAdapter.Builder().setEndpoint(
				"http://localhost:8080").build();

		TeamsService service = adapter.create(TeamsService.class);

		Team team = service.getTeam("Marx Brothers");

		System.out.println(team);
	}
}
