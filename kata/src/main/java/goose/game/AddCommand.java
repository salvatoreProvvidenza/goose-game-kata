package goose.game;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class AddCommand implements Command{

	private String command;

	public AddCommand(String command) {
		this.command = command;
	}

	private String addPlayer(List<User> players) {
		final String userName = this.command.split(" ")[2];

		boolean alreadyExists = players.stream().anyMatch(player -> StringUtils.equals(player.getName(), userName));
		if(alreadyExists){
			return String.format(GooseGame.PLAYER_ALREADY_EXISTS, userName);
		}
		User user = new User();
		user.setName(userName);
		user.setPosition(0);

		players.add(user);
		return responsePlayers(players);
	}

	@Override
	public String response(List<User> players) {
		return addPlayer(players);
	}

	public String responsePlayers(List<User> players){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("players: ");
		for (User player : players) {
			stringBuilder.append(player.getName()+", ");
		}
		stringBuilder.setLength(stringBuilder.length()-2);
		return stringBuilder.toString();
	}
}
