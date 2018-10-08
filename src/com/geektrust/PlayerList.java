package com.geektrust;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayerList {

	private static Map<String, ArrayList<Player>> listOfPlayers = new HashMap<String, ArrayList<Player>>();

	static {
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("Kirat Boli"));
		players.add(new Player("N.S  Nodhi"));
		players.add(new Player("R Rumarah"));
		players.add(new Player("Shashi Henra"));
		listOfPlayers.put("Lengaburu", players);
	}

	public static Map<String, ArrayList<Player>> getListOfPlayers() {
		return listOfPlayers;
	}
}
