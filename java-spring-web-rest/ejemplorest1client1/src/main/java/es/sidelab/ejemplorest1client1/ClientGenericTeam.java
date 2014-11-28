package es.sidelab.ejemplorest1client1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientGenericTeam {

	public static void main(String[] args) throws JsonParseException,
			JsonMappingException, IOException {

		// Http request
		URL url = new URL("http://localhost:8080/team/Marx%20Brothers");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.connect();

		// Configure Jackson parser
		ObjectMapper mapper = new ObjectMapper();
		
		// Parse response
		JsonNode team = mapper.readTree(conn.getInputStream());
		System.out.println(team);
		
		Iterator<JsonNode> ite = team.elements();		 
		while (ite.hasNext()) {
			JsonNode property = ite.next();
			System.out.println(property.textValue());	
		}
	}
}
