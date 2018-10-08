package com.geektrust;

public class Ball {
	private int runsScored;
	private boolean isWicket;

	private String playedby;

	public Ball(String playedBy) {
		runsScored = 0;
		isWicket = false;
		playedby = playedBy;
	}

	public void updateScore(int runs, boolean isWicket) {
		if (isWicket == false)
			runsScored = runs;
		else {
			runsScored = runs;
			isWicket = true;
		}
	}

	public void updateScore(int runs) {
		runsScored = runs;
	}

	public int getRunsScored() {
		return runsScored;
	}

	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}

	public String getPlayedby() {
		return playedby;
	}

	public void setPlayedby(String playedby) {
		this.playedby = playedby;
	}

	public boolean isWicket() {
		return isWicket;
	}

	public void setWicket(boolean isWicket) {
		this.isWicket = isWicket;
	}
}
