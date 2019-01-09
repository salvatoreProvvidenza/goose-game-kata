package goose.game;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GooseGameTest
{

    @Test
    public void addPlayerPippoTest()
    {
        GooseGame game = new GooseGame();

        String response = game.runCommand("add player Pippo");

        Assert.assertEquals("players: Pippo", response);
    }

    @Test
    public void addPlayerPlutoTest()
    {
        GooseGame game = new GooseGame();

        String response = game.runCommand("add player Pluto");

        Assert.assertEquals("players: Pluto", response);
    }

    @Test
    public void addPlayersTest()
    {
        GooseGame game = new GooseGame();

        String response = game.runCommand("add player Pluto");
        response = game.runCommand("add player Pippo");

        Assert.assertEquals("players: Pluto, Pippo", response);
    }

    @Test
    public void addDuplicatedPlayerTest()
    {
        GooseGame game = new GooseGame();

        String response = game.runCommand("add player Pluto");
        response = game.runCommand("add player Pippo");
        response = game.runCommand("add player Pippo");

        Assert.assertEquals("Pippo: already existing player", response);
    }

}
