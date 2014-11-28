package es.sidelab.ejemplorest1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamsRestController {

	@Autowired
	private TeamsService teamsService;

	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public List<Team> getTeams() {
		return teamsService.getTeams();
	}
	
	@RequestMapping(value = "/team/{teamName}", method = RequestMethod.GET)
	public Team getTeam(@PathVariable("teamName") String teamName) {		
		return teamsService.getTeam(teamName);
	}	
}