package goose.game.acceptance.test;

import goose.game.Game;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FakeGame implements Gioco {
	private String deletedPlayer;
	private String addedPlayer;

	public void callDeleteWith(String value) {
		assertThat(deletedPlayer, is(value));
	}

	public void callAddWith(String value) {
		assertThat(addedPlayer, is(value));
	}

	@Override
	public void delete(String playername) {
		deletedPlayer = playername;
	}

	@Override
	public void add(String playername) {
		addedPlayer = playername;
	}

	@Override
	public void move(String playername, int amount) {

	}
}