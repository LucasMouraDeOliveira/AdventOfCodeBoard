package com.lordkadoc.advent.entities.json;

import java.util.Map;

public class Leaderboard {
	
	private int year;
	
	private Map<Integer, Member> members;
	
	public Leaderboard() {}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public Map<Integer, Member> getMembers() {
		return members;
	}
	
	public void setMembers(Map<Integer, Member> members) {
		this.members = members;
	}
	
}
