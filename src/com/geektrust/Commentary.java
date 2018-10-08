package com.geektrust;

import java.util.List;

public class Commentary {
	private final int allOvers = 4;
	private String printMessage;

	public void commentarybyBall(Ball ball, Over over) {
		int overNumber = over.getOverNumber();
		int ballNumber = over.getBalls().size();
		String player = ball.getPlayedby();
		int runScored = ball.getRunsScored();
		String runsScoredPlural = (runScored == 1 || runScored == 0) ? String.valueOf(runScored) + " run"
				: String.valueOf(runScored) + " runs";
		if (ball.isWicket()) {
			printMessage = String.format("{0}.{1} Its a Wicket !!! {2} got out ", overNumber, ballNumber, player);
			System.out.println();
			System.out.println(printMessage);
		} else {
			printMessage = String.format("{0}.{1} {2} scores {3}", overNumber, ballNumber, player, runsScoredPlural);
			System.out.println(printMessage);
		}

	}

	public void commentaryBymatchifWon(ScoreCard score, List<Over> overs) {
		int remainingBalls = (allOvers * 6) - getNumberofBallsRemaining(overs);
		printMessage = String.format("Lengaburu won by {0} and {1} remaining",
				takecareofPlurals(score.getWicketsLeft(), "wickets"), takecareofPlurals(remainingBalls, "balls"));
		System.out.println(printMessage);
		if (score.getTeams() != null)
			displayPlayerScores(score.getTeams().get(0).getPlayers());
	}

	private int getNumberofBallsRemaining(List<Over> overs)
    {
        int count = overs.stream().mapToInt(x -> x.getBalls().size()).sum();
        return count;
    }

	private void displayPlayerScores(List<Player> players) {
		for (Player player : players) {
			String Name = player.getName();
			int runsScored = player.getRunScored();
			int ballsplayed = player.getBallsPlayed();
			System.out.println(Name + " - {1}({2})" + runsScored + (takecareofPlurals(ballsplayed, "balls")));
		}
	}

	private String takecareofPlurals(int number, String byWhat) {
		if (byWhat == "run") {
			return number == 1 || number == 0 ? String.valueOf(number) + " run" : String.valueOf(number) + " runs";
		} else if (byWhat == "wickets") {
			return number == 1 || number == 0 ? String.valueOf(number) + " wicket"
					: String.valueOf(number) + " wickets";
		} else {
			return number == 1 || number == 0 ? String.valueOf(number) + " ball" : String.valueOf(number) + " balls";
		}

	}

	public void commentaryBymatchifLost(ScoreCard score, List<Over> overs) {
		printMessage = String.format("Lengburu lost by {0}", takecareofPlurals(score.getRequiredRuns() - 1, "run"));
		System.out.println(printMessage);
		if (score.getTeams() != null) {
			displayPlayerScores(score.getTeams().get(0).getPlayers());
		}

	}

	public void commentaryBymatchIfTied(ScoreCard score, List<Over> overs) {
		printMessage = String.format("Match is Tied.Score is {0}", takecareofPlurals(score.getRunsScored(), "run"));
		System.out.println(printMessage);
		if (score.getTeams() != null) {
			displayPlayerScores(score.getTeams().get(0).getPlayers());
		}
	}

	public void commentaryAfterWicket(Player player) {
		String Name = player.getName();
		int runsScored = player.getRunScored();
		int ballsPlayed = player.getBallsPlayed();
		printMessage = String.format("{0} {1}({2})", Name, runsScored, ballsPlayed);
		System.out.println(printMessage);
	}

	public void commentarybyOver(ScoreCard scoreCard, List<Over> over) {
		String printMessage = String.format("After completion of over {0}. The score is {1}", over.size(),
				scoreCard.getRunsScored());
		System.out.println(printMessage);
		printMessage = String.format("Tagert {0}, Runs Required {1}, Remaining balls {2}", scoreCard.getTarget(),
				scoreCard.getRequiredRuns(), (allOvers * 6) - getNumberofBallsRemaining(over));
		System.out.println(printMessage);
		System.out.println("------------------------------------");
	}
}
