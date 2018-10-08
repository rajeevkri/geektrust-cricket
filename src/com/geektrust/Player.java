package com.geektrust;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
	private String name;

	private int runScored;
	private boolean isOutorNot;

	private int ballsPlayed;

	public boolean isplayingCurrently;
	public boolean isBattingNow;

	public Player(String name) {
		this.name = name;
		this.runScored = 0;
		this.isOutorNot = false;
		this.ballsPlayed = 0;
	}

	public void updateScore(Ball currentBall) {
		this.runScored = runScored + currentBall.getRunsScored();
		this.isOutorNot = currentBall.isWicket();
		this.ballsPlayed++;
	}

	public void PlayBall(Ball ball) {
		Random rand = new Random();
		double score = rand.nextDouble();
		System.out.println("Player name is = " + this.name);
		double[] playerBattingProbality = ProbabilityTable.table.get(this.name);
		List<Double> cumulativeProbalityList = new ArrayList<Double>();
		for (int i = 0; i < playerBattingProbality.length; i++) {
			double Cumulative = 0;
			for (int j = 0; j <= i; j++) {
				Cumulative = Cumulative + playerBattingProbality[j];
			}
			cumulativeProbalityList.add(Cumulative);
		}
		if (score < cumulativeProbalityList.get(0)) {
			ball.updateScore(0);
		} else if (score >= cumulativeProbalityList.get(0) && score < cumulativeProbalityList.get(1)) {
			ball.updateScore(1);
		} else if (score >= cumulativeProbalityList.get(1) && score < cumulativeProbalityList.get(2)) {
			ball.updateScore(2);
		} else if (score >= cumulativeProbalityList.get(2) && score < cumulativeProbalityList.get(3)) {
			ball.updateScore(3);
		} else if (score >= cumulativeProbalityList.get(3) && score < cumulativeProbalityList.get(4)) {
			ball.updateScore(4);
		} else if (score >= cumulativeProbalityList.get(4) && score < cumulativeProbalityList.get(5)) {
			ball.updateScore(5);
		} else if (score >= cumulativeProbalityList.get(5) && score < cumulativeProbalityList.get(6)) {
			ball.updateScore(6);
		} else {
			ball.updateScore(0, true);
			return;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOutorNot() {
		return isOutorNot;
	}

	public void setOutorNot(boolean isOutorNot) {
		this.isOutorNot = isOutorNot;
	}

	public int getBallsPlayed() {
		return ballsPlayed;
	}

	public void setBallsPlayed(int ballsPlayed) {
		this.ballsPlayed = ballsPlayed;
	}

	public int getRunScored() {
		return runScored;
	}

	public void setRunScored(int runScored) {
		this.runScored = runScored;
	}

}
