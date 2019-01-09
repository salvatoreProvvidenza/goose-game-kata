package goose.game.acceptance.test;

import goose.game.server.ChiliRequest;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class FakeRequest implements ChiliRequest {
	private Map<String,String> parameters =new HashMap<>();
	private String path;

	public FakeRequest withParams(String key, String value) {
		parameters.put(key, value);
		return this;
	}

	@Override
	public String getParam(String key) {
		return parameters.get(key);
	}

	@Override
	public String getPath() {
		return path;
	}

	public FakeRequest withPath(String path) {
		this.path = path;
		return this;
	}
}
