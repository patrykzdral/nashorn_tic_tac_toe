package com.pwr.patrykzdral.nashorn_tic_tac_toe.manager;



import com.pwr.patrykzdral.nashorn_tic_tac_toe.model.Board;
import com.pwr.patrykzdral.nashorn_tic_tac_toe.model.BoardEntity;
import com.pwr.patrykzdral.nashorn_tic_tac_toe.model.BoardPosition;
import com.pwr.patrykzdral.nashorn_tic_tac_toe.move.MoveStrategy;

import java.util.Optional;

import static com.pwr.patrykzdral.nashorn_tic_tac_toe.controller.MainController.board;


public class GameManager {

    private MoveStrategy enemyMoveStrategy;

    private Board gameBoard;

    private int boardSize = 5;

    private BoardEntity playerEntity = BoardEntity.O;

    private BoardEntity aiEntity = BoardEntity.X;


    public GameManager() {

    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public void startNewGame() {

//        if (boardSize < 5) {
//            throw new GameException("5x5 is minimal size of the board");
//        }

        this.gameBoard = new Board(boardSize);
    }

    public void executePlayerMove(BoardPosition boardPosition){

//        if(enemyMoveStrategy == null) {
//            throw new StrategyNotSetException();
//        }
//
//        if (gameBoard.getEntityAt(boardPosition) != BoardEntity.EMPTY) {
//            throw new FieldOccupiedException();
//        }

        gameBoard.setEntityAt(boardPosition, playerEntity);

    }

    public void executeAiMove() {

        BoardPosition boardPosition = enemyMoveStrategy.nextMove(aiEntity, gameBoard);

        gameBoard.setEntityAt(boardPosition, aiEntity);

        board[boardPosition.getX()][boardPosition.getY()].drawO();
    }



    public void setEnemyMoveStrategy(MoveStrategy enemyMoveStrategy) {
        this.enemyMoveStrategy = enemyMoveStrategy;
    }




}


