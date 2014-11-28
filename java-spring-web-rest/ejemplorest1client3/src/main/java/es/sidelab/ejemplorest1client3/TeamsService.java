package es.sidelab.ejemplorest1client3;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;

public interface TeamsService {

	@GET("/teams")
	List<Team> getTeams();

	@GET("/team/{name}")
	Team getTeam(@Path("name") String name);
}