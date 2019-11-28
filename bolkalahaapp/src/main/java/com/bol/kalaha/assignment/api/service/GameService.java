package com.bol.kalaha.assignment.api.service;


import com.bol.kalaha.assignment.api.model.Game;

public interface GameService {

    Game initGame(Integer pitNumber);

    Game play(String gameId, Integer pitId);
}
