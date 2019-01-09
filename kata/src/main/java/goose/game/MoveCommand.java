package goose.game;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class MoveCommand implements  Command{

	private String command;

	public MoveCommand(String command) {
		this.command = command;
	}

	private String movePlayer(List<User> players) {
		String user = command.split(" ")[1];
		int firstValue = Integer.parseInt(command.split(" ")[2].replaceAll(",", ""));
		int secondValue = Integer.parseInt(command.split(" ")[3]);
		return responsePlayers(players, user, firstValue, secondValue);
	}

	@Override
	public String response(List<User> players) {
		return movePlayer(players);
	}

	public String responsePlayers(List<User> players, String userName, int firstValue, int secondValue){

		int sum = firstValue + secondValue;

		User user = players.stream().filter(player -> StringUtils.equals(player.getName(), userName)).findFirst().get();


		String startFrom = user.getPosition() == 0 ? "Start" : ""+user.getPosition();
		user.setPosition(user.getPosition() + sum);

		//Pippo rolls 4, 2. Pippo moves from Start to 6
		return String.format("%s rolls %d, %d. %s moves from %s to %d", userName, firstValue, secondValue, userName, startFrom, user.getPosition());


		/*
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("players: ");
		for (String player : players) {
			stringBuilder.append(player+", ");
		}
		stringBuilder.setLength(stringBuilder.length()-2);
		return stringBuilder.toString();
		*/
	}

}
