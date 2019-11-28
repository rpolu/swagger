package com.bol.kalaha.assignment.api.model;

import javax.validation.constraints.NotNull;

public class Player {

	public static final Integer PLAYER1_INDEX = 1;
	public static final Integer PLAYER2_INDEX = 2;

	@NotNull
	private Integer playerIndex;

	@NotNull
	private String name;

	public Player(Integer player1Index, String name) {
		this.playerIndex = player1Index;
		this.name = name;
	}

	public Integer getPlayerIndex() {
		return playerIndex;
	}

	public void setPlayerIndex(Integer playerIndex) {
		this.playerIndex = playerIndex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Integer getPlayer1Index() {
		return PLAYER1_INDEX;
	}

	public static Integer getPlayer2Index() {
		return PLAYER2_INDEX;
	}

}
