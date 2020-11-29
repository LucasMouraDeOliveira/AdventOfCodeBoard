package com.lordkadoc.advent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("showLeaderboard")
public class LeaderboardController {
	
	@GetMapping
	public String loadView() {
		return "view/leaderboard";
	}
	
}
