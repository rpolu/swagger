package com.bol.kalaha.assignment.api.repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bol.kalaha.assignment.api.exception.KalahException;
import com.bol.kalaha.assignment.api.model.Game;

@Component
public class GameMemoryRepository {

	private static final Map<String, Game> gameMap = new ConcurrentHashMap<>();

	/**
	 * This method create new Game and save the object in a Map.
	 *
	 * @param initialPitStoneCount is the number of the stone of a pit.
	 * @return Game object.
	 */
	public Game create(Integer initialPitStoneCount) {
		String id = UUID.randomUUID().toString();
		Game game = new Game(initialPitStoneCount);
		game.setId(id);
		gameMap.put(id, game);
		return gameMap.get(id);
	}

	/**
	 * This method will return the game object by id.
	 *
	 * @param id is the game id.
	 * @return Game
	 */
	public Game findById(String id) {
		Game game = gameMap.get(id);
		if (game == null) {
			throw new KalahException("Game is not found for the id: " + id);
		}
		return game;
	}

	/**
	 * After Every 5 minutes(300000 seconds) interval this method tries to find the
	 * 60 minutes old game and remove them from map. So, if there is no activity on
	 * a game last 60 minutes, It will destroy.
	 */
	@Scheduled(fixedRate = 300000)
	public void deleteOldGame() {
		for (Map.Entry<String, Game> entry : gameMap.entrySet()) {
			long diff = (System.currentTimeMillis() - entry.getValue().getUpdateAt());
			long diffMinutes = diff / (60 * 1000) % 60;
			if (diffMinutes > 60) {
				gameMap.remove(entry.getKey());
			}
		}
	}
}
