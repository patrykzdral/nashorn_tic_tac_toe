package com.pwr.patrykzdral.nashorn_tic_tac_toe.move;


import com.pwr.patrykzdral.nashorn_tic_tac_toe.model.Board;
import com.pwr.patrykzdral.nashorn_tic_tac_toe.model.BoardEntity;
import com.pwr.patrykzdral.nashorn_tic_tac_toe.model.BoardPosition;
import com.pwr.patrykzdral.nashorn_tic_tac_toe.ui_model.Tile;

public interface MoveStrategy {
    BoardPosition nextMove(BoardEntity boardEntity, Board boardSituation);
}


