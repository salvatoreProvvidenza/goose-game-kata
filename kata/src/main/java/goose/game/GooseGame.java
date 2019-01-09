package goose.game;

import java.util.ArrayList;
import java.util.List;

public class GooseGame implements Game {


	public final static String PLAYER_ALREADY_EXISTS = "%s: already existing player";

	private List<User> players;
	private CommandStrategy commandStrategy;

	public GooseGame() {
		this.players = new ArrayList<>();
		this.commandStrategy = new CommandStrategy();
	}

	@Override
	public String runCommand(String command) {

		Command run = commandStrategy.run(command);
		String responseString = run.response(players);

		return responseString;
	}
}
