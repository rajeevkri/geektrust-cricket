package com.geektrust;

public class Bowler {
	private String name;
    private Ball ball;
    
    public Bowler() {
		super();
	}

	public Bowler(String Name)
    {
        this.name = Name;
    }

    public void Bowl(Player playedby,Ball ball)
    { 
        playedby.PlayBall(ball);  
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}
    
}
