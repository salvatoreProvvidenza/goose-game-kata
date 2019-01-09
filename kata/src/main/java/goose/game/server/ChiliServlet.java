package goose.game.server;

public interface ChiliServlet {
	void get(ChiliRequest request, ChiliResponse response);
	void post(ChiliRequest request, ChiliResponse response);
}
