package goose.game;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class MoveCommand implements  Command{

	public static final int WIN_VALUE = 63;
	public static final String BOUNCE = "%s rolls %d, %d. %s moves from %s to %d. %s bounces! %s returns to %d";
	public static final String WINS = "%s rolls %d, %d. %s moves from %s to %d. %s Wins!!";
	public static final String MOVE = "%s rolls %d, %d. %s moves from %s to %d";
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

		if(hasPlayerWin(user)){
			return String.format(WINS, userName, firstValue, secondValue, userName, startFrom, user.getPosition(),userName);

		}

		if(hasPlayerBounce(user)){
			int bounce = user.getPosition() - WIN_VALUE;
			int newPosition = WIN_VALUE - bounce;
			return String.format(BOUNCE, userName,
					firstValue, secondValue, userName, startFrom, WIN_VALUE,userName,userName,newPosition);

		}

		return String.format(MOVE, userName, firstValue, secondValue, userName, startFrom, user.getPosition());

	}

	private boolean hasPlayerBounce(User user) {
		return user.getPosition() > WIN_VALUE;
	}

	private boolean hasPlayerWin(User user) {
		return user.getPosition() == WIN_VALUE;
	}

}
