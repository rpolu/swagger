package com.bol.kalaha.assignment.api.model;

import org.junit.Assert;
import org.junit.Test;

import com.bol.kalaha.assignment.api.model.Board;
import com.bol.kalaha.assignment.api.model.Game;
import com.bol.kalaha.assignment.api.model.GameStatus;
import com.bol.kalaha.assignment.api.model.Player;

public class GameTest {

    @Test
    public void shouldCreateGame(){

        //give
        Game game = new Game(Board.INITIAL_STONE_ON_PIT);

        //then
        Assert.assertEquals(Player.PLAYER1_INDEX, game.getPlayer1().getPlayerIndex());
        Assert.assertEquals(Player.PLAYER2_INDEX, game.getPlayer2().getPlayerIndex());
        Assert.assertNotNull(game.getBoard());
        Assert.assertEquals(14, game.getBoard().getPits().size());
        Assert.assertEquals(GameStatus.INIT, game.getGameStatus());
    }


}
