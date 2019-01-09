package goose.game.acceptance.test;

public interface Gioco {
	void delete(String playername);
	void add(String playername);
	void move(String playername, int amount);
}
