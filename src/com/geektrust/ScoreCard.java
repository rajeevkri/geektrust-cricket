package com.geektrust;

import java.util.List;

public class ScoreCard {
	private int myVar;

	private int myProperty;

	private int oversLeft;
	private int target;
	private int wicketsLeft;
	private int runsScored;
	private List<Player> players;
	private int requiredRuns;
	private List<Team> Teams;

	public ScoreCard(List<Player> players, int oversLeft, int target, int wicketsleft, int runsScored) {
		this.oversLeft = oversLeft;
		this.target = target;
		wicketsLeft = wicketsleft;
		this.runsScored = runsScored;
		this.players = players;
		requiredRuns = this.target - this.runsScored;
	}

	public ScoreCard(int oversLeft, int target, int wicketsleft, int runsScored, List<Team> teams) {
		this.oversLeft = oversLeft;
		this.target = target;
		wicketsLeft = wicketsleft;
		this.runsScored = runsScored;
		Teams = teams;
		requiredRuns = this.target - this.runsScored;
	}

	public void updateScore(Ball currentBall) {
		runsScored = runsScored + currentBall.getRunsScored();
		requiredRuns = requiredRuns - currentBall.getRunsScored();
		if (requiredRuns < 0) {
			requiredRuns = 0;
		}
		if (currentBall.isWicket()) {
			wicketsLeft = wicketsLeft - 1;
		}
	}

	public void updateOver() {
		oversLeft = oversLeft - 1;
	}

	public List<Team> getTeams() {
		return Teams;
	}

	public void setTeams(List<Team> teams) {
		this.Teams = teams;
	}

	public int getWicketsLeft() {
		return wicketsLeft;
	}

	public void setWicketsLeft(int wicketsLeft) {
		this.wicketsLeft = wicketsLeft;
	}

	public int getRunsScored() {
		return runsScored;
	}

	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public int getRequiredRuns() {
		return requiredRuns;
	}

	public void setRequiredRuns(int requiredRuns) {
		this.requiredRuns = requiredRuns;
	}

	public int getMyVar() {
		return myVar;
	}

	public void setMyVar(int myVar) {
		this.myVar = myVar;
	}

	public int getMyProperty() {
		return myProperty;
	}

	public void setMyProperty(int myProperty) {
		this.myProperty = myProperty;
	}

	public int getOversLeft() {
		return oversLeft;
	}

	public void setOversLeft(int oversLeft) {
		this.oversLeft = oversLeft;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
