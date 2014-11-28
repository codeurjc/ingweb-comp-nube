package es.sidelab.ejemplorest1client1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientTeam {

	public static void main(String[] args) throws JsonParseException,
			JsonMappingException, IOException {

		// Http request
		URL url = new URL("http://localhost:8080/team/Marx%20Brothers");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.connect();

		// Configure Jackson parser
		ObjectMapper mapper = new ObjectMapper();
		
		// Parse response
		Team team = mapper.readValue(conn.getInputStream(), Team.class);

		// Use response
		System.out.println(team);

	}
}
