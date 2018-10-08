package com.geektrust;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Match {
	private final int ballsPerOver = 6;

	private final int overslimit = 4;
	public ScoreCard scoreCard;
	public List<Over> overs;
	public Commentary scoreDisplay;
	public Team team;

	public Match() {
		List<Team> teams = new ArrayList<Team>();
		team = new Team("Lengaburu");
		teams.add(team);
		scoreCard = new ScoreCard(team.getPlayers(), overslimit, 40, 3, 0);
		scoreCard = new ScoreCard(overslimit, 40, 3, 0, teams);
		overs = new ArrayList<Over>();
		scoreDisplay = new Commentary();
	}

	public boolean conductMatch() {
		Player firstPlayer = scoreCard.getTeams().get(0).getPlayers().get(0);
		Player secondPlayer = scoreCard.getTeams().get(0).getPlayers().get(1);
		firstPlayer.isBattingNow = true;
		firstPlayer.isplayingCurrently = true;
		secondPlayer.isplayingCurrently = true;
		Result result = Result.Continue;
		for (int i = 0; i < overslimit; i++) {
			result = conductOver(firstPlayer, secondPlayer);
			scoreCard.updateOver();
			scoreDisplay.commentarybyOver(scoreCard, overs);
			if (result == Result.Won || result == Result.Allout) {
				if (result == Result.Won) {
					scoreDisplay.commentaryBymatchifWon(scoreCard, overs);
				} else if (result == Result.Allout) {
					scoreDisplay.commentaryBymatchifLost(scoreCard, overs);
				} else if (result == Result.MatchTied) {

				}
				break;
			}

			changeStrikeAfterOver(firstPlayer, secondPlayer, overs.get(overs.size() - 1));
		}
		if (scoreCard.getOversLeft() == 0 && scoreCard.getRunsScored() < scoreCard.getTarget()
				&& result != Result.Allout) {
			scoreDisplay.commentaryBymatchifLost(scoreCard, overs);
		}
		return true;
	}

	private void changeStrikeAfterOver(Player firstPlayer, Player secondPlayer, Over over) {
		Ball lastBallofOver = over.getBalls().get(over.getBalls().size() - 1);
		swapPlayers(firstPlayer, secondPlayer);
	}

	private Result conductOver(Player striker, Player runner) {
		Over over = new Over();
		over.setOverNumber(overs.size());
		overs.add(over);
		for (int i = 0; i < ballsPerOver; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Ball newBall = new Ball(striker.getName());
			over.getBowler().Bowl(striker, newBall);
			striker.updateScore(newBall);
			over.updateScore(newBall);

			if (!newBall.isWicket()) {
				scoreCard.updateScore(newBall);
			} else {
				scoreCard.updateScore(newBall);

			}
			if (over.ControlPlayerBetweenWickets(newBall)) {
				swapPlayers(striker, runner);
			}
			scoreDisplay.commentarybyBall(newBall, over);
			if (striker.isOutorNot()) {
				scoreDisplay.commentaryAfterWicket(striker);
				striker = getTheNextPlayer();
				if (striker != null)
					striker.isplayingCurrently = true;
			}

			if (scoreCard.getRunsScored() > scoreCard.getTarget())
				return Result.Won;
			if (scoreCard.getRunsScored() == scoreCard.getTarget() && over.getOverNumber() == overslimit
					&& i == ballsPerOver)
				return Result.MatchTied;
			if (scoreCard.getWicketsLeft() == 0)
				return Result.Allout;
			

		}
		return Result.Continue;
	}

	private Player getTheNextPlayer() {
		return scoreCard.getTeams().get(0).getPlayers().stream().filter(x -> x.isplayingCurrently == false)
				.collect(Collectors.toList()).get(0);
	}

	private void swapPlayers(Player striker, Player runner) {
		Player temp = striker;
		striker = runner;
		runner = temp;
	}

	public static void main(String... args) {
		Match match = new Match();
		boolean result = match.conductMatch();
		System.out.println(result);
	}
}
