package goose.game.acceptance.test;

import org.junit.Before;
import org.junit.Test;

public class GooseHttpTest {

	private FakeGame game;
	private InMemoryRequestRepository repository;
	private GameController gameController;

	@Before
	public void before() {
		game = new FakeGame();
		repository = new InMemoryRequestRepository();

		gameController = new GameController(game, repository);

	}

	@Test
	public void deletePlayer() {
		gameController.get(new FakeRequest()
				.withParams("name", "Gigi")
				.withPath("/players/delete"), null);

		game.callDeleteWith("Gigi");
	}

	@Test
	public void addPlayer() {
		gameController.get(new FakeRequest()
				.withParams("name", "Gigi")
				.withPath("/players/add"), null);

		game.callAddWith("Gigi");
	}

	@Test
	public void shouldTraceRequest() {
		gameController.get(new FakeRequest()
				.withParams("name", "Gigi")
				.withPath("/players/add"), null);

		repository.callSaveWith("Gigi", "/players/add");
	}
}
