package es.sidelab.ejemplorest1client2;

import org.springframework.web.client.RestTemplate;

public class ClientTeam {

	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();
		        
		String url = "http://localhost:8080/team/Marx Brothers";
		
		Team team = restTemplate.getForObject(url, Team.class);
		
		System.out.println(team);
	}
}
