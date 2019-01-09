package goose.game.server;

import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletAdapter extends HttpServlet {
	private ChiliServlet servlet;

	public ServletAdapter(ChiliServlet servlet) {
		this.servlet = servlet;
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		servlet.get(new RequestAdapter(req), new ResponseAdapter(resp));
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
