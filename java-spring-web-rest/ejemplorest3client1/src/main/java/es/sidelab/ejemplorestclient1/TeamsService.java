package es.sidelab.ejemplorestclient1;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface TeamsService {

	@GET("/teams")
	List<Team> getTeams();
	
	@GET("/team/{name}")
	Team getTeam(@Path("name") String name);
	
	@POST("/teams")
	boolean addTeam(@Body Team team);
}