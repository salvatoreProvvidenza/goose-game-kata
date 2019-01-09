package goose.game.acceptance.test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InMemoryRequestRepository implements RequestRepository {

	private String savedPlayer;
	private String savedPath;

	public void callSaveWith(String player, String path) {
		assertThat(savedPlayer, is(player));
		assertThat(savedPath, is(path));
	}

	@Override
	public void save(String player, String path) {
		savedPlayer = player;
		savedPath = path;
	}
}
