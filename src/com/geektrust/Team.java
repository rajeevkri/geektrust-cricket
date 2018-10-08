package com.geektrust;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private String teamName;

	private List<Player> players;
    
    public List<Player> getPlayers() {
		return players;
	}

	public Team(String Name)
    {
        players = new ArrayList<Player>();
        players.addAll(PlayerList.getListOfPlayers().get("Lengaburu"));
        teamName = Name;
    }

}
