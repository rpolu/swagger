package com.bol.kalaha.assignment.api.rule;

import com.bol.kalaha.assignment.api.model.Game;
import com.bol.kalaha.assignment.api.model.Pit;

public abstract class KalahRule {

    protected KalahRule next;
    public abstract void apply(Game game, Pit currentPit);

    public KalahRule setNext(KalahRule next) {
        this.next = next;
        return next;
    }

}
