package com.bol.kalaha.assignment.api.rule;

import com.bol.kalaha.assignment.api.model.Game;
import com.bol.kalaha.assignment.api.model.Pit;

public class DistributePitStoneRule extends KalahRule {

	@Override
	public void apply(Game game, Pit currentPit) {

		Integer stoneToDistribute = currentPit.getStoneCount();
		currentPit.setStoneCount(0);

		for (int i = 0; i < stoneToDistribute; i++) {
			currentPit = game.getBoard().getNextPit(currentPit);
			if (currentPit.isDistributable(game.getGameStatus())) {
				currentPit.setStoneCount(currentPit.getStoneCount() + 1);
			} else {
				i--;
			}
		}

		this.next.apply(game, currentPit);
	}

}
