package com.bol.kalaha.assignment.api.rule;

import com.bol.kalaha.assignment.api.exception.KalahIllegalMoveException;
import com.bol.kalaha.assignment.api.model.Board;
import com.bol.kalaha.assignment.api.model.Game;
import com.bol.kalaha.assignment.api.model.GameStatus;
import com.bol.kalaha.assignment.api.model.Pit;
import com.bol.kalaha.assignment.api.model.Player;

public class StartPitRule extends KalahRule {

	@Override
	public void apply(Game game, Pit startPit) {
		checkPlayerTurnRule(game, startPit);
		checkEmptyStartRULE(startPit);
		this.next.apply(game, startPit);
	}

	private void checkPlayerTurnRule(Game game, Pit startPit) {

		if (game.getGameStatus().equals(GameStatus.INIT)) {
			GameStatus gameStatus = startPit.getPlayerIndex().equals(Player.PLAYER1_INDEX) ? GameStatus.PLAYER1_TURN
					: GameStatus.PLAYER2_TURN;
			game.setGameStatus(gameStatus);
		}

		if ((game.getGameStatus().equals(GameStatus.PLAYER1_TURN) && startPit.getPitIndex() >= Board.PLAYER1_HOUSE)
				|| (game.getGameStatus().equals(GameStatus.PLAYER2_TURN)
						&& startPit.getPitIndex() <= Board.PLAYER1_HOUSE)) {
			throw new KalahIllegalMoveException("Incorrect pit to play");
		}
	}

	private void checkEmptyStartRULE(Pit startPit) {

		if (startPit.getStoneCount() == 0) {
			throw new KalahIllegalMoveException("Can not start from empty pit");
		}
	}
}
