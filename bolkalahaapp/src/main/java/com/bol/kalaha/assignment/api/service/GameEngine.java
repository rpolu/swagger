package com.bol.kalaha.assignment.api.service;

import org.springframework.stereotype.Component;

import com.bol.kalaha.assignment.api.model.Game;
import com.bol.kalaha.assignment.api.model.Pit;
import com.bol.kalaha.assignment.api.rule.DistributePitStoneRule;
import com.bol.kalaha.assignment.api.rule.EndPitRule;
import com.bol.kalaha.assignment.api.rule.GameOver;
import com.bol.kalaha.assignment.api.rule.KalahRule;
import com.bol.kalaha.assignment.api.rule.StartPitRule;

@Component
public class GameEngine {

	private final KalahRule chain;

	public GameEngine() {

		this.chain = new StartPitRule();
		chain.setNext(new DistributePitStoneRule()).setNext(new EndPitRule()).setNext(new GameOver());
	}

	public void play(Game game, Pit pit) {
		this.chain.apply(game, pit);
	}

}
