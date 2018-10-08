package com.geektrust;

import java.util.ArrayList;
import java.util.List;

public class Over {
	private final int oddNumberScored = 1;
	private Bowler bowler;
	private List<Ball> balls;
	private int runScored;
	private int overNumber;

	public Over() {
		this.bowler = new Bowler();
		balls = new ArrayList<Ball>();
		runScored = 0;
		overNumber = 0;
	}

	public boolean ControlPlayerBetweenWickets(Ball newball) {
		Ball latestBall = newball;
		if (latestBall.getRunsScored() % 2 == oddNumberScored) {
			return true;
		} else {
			return false;
		}

	}

	public void updateScore(Ball currentBall) {
		balls.add(currentBall);
		runScored = runScored + currentBall.getRunsScored();
	}

	public int getOverNumber() {
		return overNumber;
	}

	public void setOverNumber(int overNumber) {
		this.overNumber = overNumber;
	}

	public List<Ball> getBalls() {
		return balls;
	}

	public void setBalls(List<Ball> balls) {
		this.balls = balls;
	}

	public Bowler getBowler() {
		return bowler;
	}

	public void setBowler(Bowler bowler) {
		this.bowler = bowler;
	}

}
