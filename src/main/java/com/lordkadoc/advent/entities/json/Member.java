package com.lordkadoc.advent.entities.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Member {
	
	private String name;
	
	@JsonProperty(value = "global_score")
	private int globalScore;
	
	public Member() {}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getGlobalScore() {
		return globalScore;
	}
	
	public void setGlobalScore(int globalScore) {
		this.globalScore = globalScore;
	}

}
