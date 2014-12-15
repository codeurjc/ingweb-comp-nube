package es.sidelab.sample.blog.model;

public class BlogResult {
	
	private String port;
	private BlogEntry payload;
	
	public BlogResult() {
	}

	public BlogResult(BlogEntry entry, String serverPort) {
		this.port = serverPort;
		this.payload = entry;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public BlogEntry getPayload() {
		return payload;
	}

	public void setPayload(BlogEntry payload) {
		this.payload = payload;
	}
	
	
}
