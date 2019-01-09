package goose.game.acceptance.test;

import goose.game.server.ChiliRequest;
import goose.game.server.ChiliResponse;
import goose.game.server.ChiliServlet;

public class GameController implements ChiliServlet {
	private Gioco game;
	private RequestRepository repository;

	public GameController(Gioco game, RequestRepository repository) {
		this.game = game;
		this.repository = repository;
	}

	@Override
	public void get(ChiliRequest request, ChiliResponse response) {
		String playername = playername(request);
		if(isAnAdd(request)) {
			game.add(playername);
		}
		else {
			game.delete(playername);
		}
		repository.save(playername, request.getPath());
	}

	private boolean isAnAdd(ChiliRequest request) {
		return request.getPath().contains("add");
	}

	private String playername(ChiliRequest request) {
		return request.getParam("name");
	}

	@Override
	public void post(ChiliRequest request, ChiliResponse response) {

	}
}
