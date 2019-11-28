package com.bol.kalaha.assignment.api.service;

import org.springframework.stereotype.Service;

import com.bol.kalaha.assignment.api.model.Game;
import com.bol.kalaha.assignment.api.model.Pit;
import com.bol.kalaha.assignment.api.repository.GameMemoryRepository;

@Service
public class GameServiceImpl implements GameService {

	private final GameMemoryRepository gameMemoryRepository;
	private final GameEngine gameEngine;

	public GameServiceImpl(GameMemoryRepository gameMemoryRepository, GameEngine gameEngine) {
		this.gameMemoryRepository = gameMemoryRepository;
		this.gameEngine = gameEngine;
	}

	/**
	 * This method is responsible to initialize new game
	 *
	 * @param initialPitStoneCount is the initial number of stone.
	 * @return Game
	 */
	@Override
	public Game initGame(Integer initialPitStoneCount) {
		return gameMemoryRepository.create(initialPitStoneCount);
	}

	/**
	 * This method is responsible for every new move of the stones from a pit.
	 *
	 * @param gameId   game id
	 * @param pitIndex index of the pit
	 * @return Game
	 */
	@Override
	public Game play(String gameId, Integer pitIndex) {

		Game game = gameMemoryRepository.findById(gameId);
		Pit pit = game.getBoard().getPitByPitIndex(pitIndex);

		gameEngine.play(game, pit);
		return game;
	}

}
