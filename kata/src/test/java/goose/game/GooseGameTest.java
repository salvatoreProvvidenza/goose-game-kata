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

    @Test
    public void movePlayerFromStartTest()
    {
        GooseGame game = new GooseGame();

        String response = game.runCommand("add player Pippo");
        response = game.runCommand("add player Pluto");
        response = game.runCommand("move Pippo 4, 2");

        Assert.assertEquals("Pippo rolls 4, 2. Pippo moves from Start to 6", response);
    }

    @Test
    public void movePlayerMultipleTest()
    {
        GooseGame game = new GooseGame();

        String response = game.runCommand("add player Pippo");
        response = game.runCommand("add player Pluto");
        response = game.runCommand("move Pippo 4, 2");
        response = game.runCommand("move Pippo 2, 3");

        Assert.assertEquals("Pippo rolls 2, 3. Pippo moves from 6 to 11", response);
    }

    @Test
    public void movePlayerToWinTest()
    {
        GooseGame game = new GooseGame();

        String response = game.runCommand("add player Pippo");
        response = game.runCommand("move Pippo 6, 6");
        response = game.runCommand("move Pippo 6, 6");
        response = game.runCommand("move Pippo 6, 6");
        response = game.runCommand("move Pippo 6, 6");
        response = game.runCommand("move Pippo 6, 6");
        response = game.runCommand("move Pippo 1, 2");


        Assert.assertEquals("Pippo rolls 1, 2. Pippo moves from 60 to 63. Pippo Wins!!", response);
    }

    @Test
    public void movePlayerToBounceTest()
    {
        GooseGame game = new GooseGame();

        String response = game.runCommand("add player Pippo");
        response = game.runCommand("move Pippo 6, 6");
        response = game.runCommand("move Pippo 6, 6");
        response = game.runCommand("move Pippo 6, 6");
        response = game.runCommand("move Pippo 6, 6");
        response = game.runCommand("move Pippo 6, 6");
        response = game.runCommand("move Pippo 3, 2");


        Assert.assertEquals("Pippo rolls 3, 2. Pippo moves from 60 to 63. Pippo bounces! Pippo returns to 61", response);
    }

}
