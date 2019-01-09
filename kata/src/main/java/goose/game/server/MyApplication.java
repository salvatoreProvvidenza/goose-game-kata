package goose.game.server;

import goose.game.Game;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyApplication extends HttpServlet {

    private Game game;

    public MyApplication(Game game) {
        this.game = game;
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dice1 = req.getParameter("dice1");
        String dice2 = req.getParameter("dice2");

        String playerName =req.getRequestURI().split("/")[2];

        String response = game.runCommand(new GooseGameCommandBuilder().convert(playerName, dice1, dice2));

        write(resp, response);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String response = game.runCommand(String.format("add player %s",req.getParameter("name")));

        write(resp, response);
    }

    private void write(HttpServletResponse resp, String message) throws IOException {
        resp.getWriter().write(message);
    }
}