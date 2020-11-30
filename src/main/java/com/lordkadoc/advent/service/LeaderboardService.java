package com.lordkadoc.advent.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lordkadoc.advent.entities.json.Leaderboard;

@Service
public class LeaderboardService {
	
	@Value("${leaderboard.url}")
	private String leaderboardServerUrl;
	
	@Value("${leaderboard.session-cookie}")
	private String sessionCookie;
	
	private Leaderboard currentLeaderboard;
	
	public Leaderboard getLeaderboard() {
		return this.currentLeaderboard;
	}
	
	@Scheduled(fixedRate = 900_000)
	public void updateLeaderboard() throws IOException {
		
		try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
			
			HttpGet request = new HttpGet(leaderboardServerUrl);
			request.addHeader("cookie", "session="+sessionCookie);
			
			CloseableHttpResponse response = httpClient.execute(request);
			
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String result = EntityUtils.toString(entity);
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				this.currentLeaderboard = mapper.readValue(result, Leaderboard.class);
			}
			
		} catch(IOException e) {
			System.err.println(e);
		} 
		
	}

}
