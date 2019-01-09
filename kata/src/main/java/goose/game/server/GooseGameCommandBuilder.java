package goose.game.server;

public class GooseGameCommandBuilder {
	public String convert(String playerName, String dice1, String dice2) {
		return String.format("move %s %s, %s",playerName, dice1, dice2);
	}
}
