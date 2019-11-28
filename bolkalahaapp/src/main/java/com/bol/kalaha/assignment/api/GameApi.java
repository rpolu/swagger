package com.bol.kalaha.assignment.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bol.kalaha.assignment.api.exception.KalahException;
import com.bol.kalaha.assignment.api.exception.KalahIllegalMoveException;
import com.bol.kalaha.assignment.api.model.Board;
import com.bol.kalaha.assignment.api.service.GameService;

@RestController
@RequestMapping("/api/kalah")
public class GameApi {

	private final GameService gameService;

	public GameApi(GameService gameService) {
		this.gameService = gameService;
	}

	@PostMapping(value = "/games")
	public ResponseEntity initBoard(
			@RequestParam(name = "stone", defaultValue = "6", required = false) Integer numberOfStone) {
		return ResponseEntity.status(HttpStatus.CREATED).body(gameService.initGame(numberOfStone));
	}

	@PutMapping("/games/{gameId}/pits/{pitIndex}")
	public ResponseEntity play(@PathVariable String gameId, @PathVariable Integer pitIndex) {

		if (pitIndex > Board.PIT_END_INDEX || pitIndex < Board.PIT_START_INDEX) {
			throw new KalahException("Incorrect pit index");
		}

		if (pitIndex.equals(Board.PLAYER1_HOUSE) || pitIndex.equals(Board.PLAYER2_HOUSE)) {
			throw new KalahIllegalMoveException("House stone is not allow to distribute");
		}

		return ResponseEntity.ok().body(gameService.play(gameId, pitIndex));
	}

}
