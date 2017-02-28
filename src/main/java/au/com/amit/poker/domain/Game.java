package au.com.amit.poker.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amit Solankurkar on 26/2/17.
 */
public class Game {

	private List<Player> players = new ArrayList<>();
	
	public void addPlayer(Player player) {
		players.add(player);
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
