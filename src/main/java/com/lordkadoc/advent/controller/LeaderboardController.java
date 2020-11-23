package com.lordkadoc.advent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lordkadoc.advent.service.LeaderboardService;

@RestController
@RequestMapping("leaderboard")
public class LeaderboardController {
	
	@Autowired
	private LeaderboardService leaderboardService;
	
	@GetMapping
	public ResponseEntity<String> getLeaderboard() {
		String leaderboard = leaderboardService.getLeaderboard();
		return ResponseEntity.ok(leaderboard);
	}

}
