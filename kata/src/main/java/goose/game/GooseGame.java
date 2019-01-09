package goose.game;

import java.util.ArrayList;
import java.util.List;

public class GooseGame {


	private final String PLAYER_ALREADY_EXISTS = "%s: already existing player";

	private List<String> players;

	public GooseGame() {
		this.players = new ArrayList<>();
	}

	public String runCommand(String command) {
		return addPlayer(command);
	}

	private String addPlayer(String command) {
		String user = command.split(" ")[2];
		if(players.contains(user)){
			return String.format(PLAYER_ALREADY_EXISTS, user);
		}
		players.add(user);
		return responsePlayers();
	}

	public String responsePlayers(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("players: ");
		for (String player : players) {
			stringBuilder.append(player+", ");
		}
		stringBuilder.setLength(stringBuilder.length()-2);
		return stringBuilder.toString();
	}

}
