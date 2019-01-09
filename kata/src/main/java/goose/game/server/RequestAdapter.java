package goose.game.server;

import javax.servlet.http.HttpServletRequest;

public class RequestAdapter implements ChiliRequest {
	private HttpServletRequest request;

	public RequestAdapter(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public String getParam(String key) {
		return request.getParameter(key);
	}

	@Override
	public String getPath() {
		return request.getPathInfo();
	}
}
