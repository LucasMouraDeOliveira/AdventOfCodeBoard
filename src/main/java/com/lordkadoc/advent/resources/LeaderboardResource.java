package com.lordkadoc.advent.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lordkadoc.advent.entities.json.Leaderboard;
import com.lordkadoc.advent.service.LeaderboardService;

@RestController
@RequestMapping("leaderboard")
public class LeaderboardResource {
	
	@Autowired
	private LeaderboardService leaderboardService;
	
	@GetMapping
	public ResponseEntity<Leaderboard> getLeaderboard() {
		Leaderboard leaderboard = leaderboardService.getLeaderboard();
		return ResponseEntity.ok(leaderboard);
	}
	
	@GetMapping("test")
	public String getJSON() {
		return "{\"owner_id\":\"11101\",\"members\":{"
				+ "\"11101\":{\"id\":\"11101\",\"last_star_ts\":0,\"stars\":0,\"local_score\":0,\"name\":\"Nicolas Seys\",\"global_score\":100,\"completion_day_level\":{}},"
				+ "\"695239\":{\"global_score\":0,\"completion_day_level\":{},\"name\":\"MatthieuBlm\",\"local_score\":0,\"last_star_ts\":0,\"stars\":0,\"id\":\"695239\"},"
				+ "\"695995\":{\"local_score\":0,\"name\":\"LucasMouraDeOliveira\",\"global_score\":0,\"completion_day_level\":{},\"id\":\"695995\",\"last_star_ts\":0,\"stars\":0},"
				+ "\"752942\":{\"last_star_ts\":0,\"stars\":0,\"id\":\"752942\",\"global_score\":0,\"completion_day_level\":{},\"local_score\":0,\"name\":\"Carlos Miranda\"}},\"event\":\"2020\"}";
	}

}
