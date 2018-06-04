package com.pwr.patrykzdral.nashorn_tic_tac_toe.model;

public enum BoardEntity {

    EMPTY(" "), O("O"), X("X");

    private final String representation;

    BoardEntity(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return representation;
    }
}
