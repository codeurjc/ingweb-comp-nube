package es.sidelab.ejemplorest1client1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientTeams {

	public static void main(String[] args) throws JsonParseException,
			JsonMappingException, IOException {

		// Http request
		URL url = new URL("http://localhost:8080/teams");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.connect();

		// Configure Jackson parser
		ObjectMapper mapper = new ObjectMapper();
		JavaType type = mapper.getTypeFactory().constructCollectionType(
				List.class, Team.class);

		// Parse response
		List<Team> teams = mapper.readValue(conn.getInputStream(), type);

		// Use response
		for (Team team : teams) {
			System.out.println(team);
		}

	}
}
