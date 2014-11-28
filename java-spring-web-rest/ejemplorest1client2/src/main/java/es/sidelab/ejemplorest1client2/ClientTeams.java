package es.sidelab.ejemplorest1client2;

import org.springframework.web.client.RestTemplate;

public class ClientTeams {

	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();
		        
		String url = "http://localhost:8080/teams";
		
		Team[] teams = restTemplate.getForObject(url, Team[].class);
		
		for (Team team : teams) {
			System.out.println(team);
		}
	}
}
