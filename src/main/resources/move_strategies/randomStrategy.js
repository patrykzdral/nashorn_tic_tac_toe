var MoveStrategy = Java.type("com.pwr.patrykzdral.nashorn_tic_tac_toe.move.MoveStrategy");

var BoardPosition = Java.type("com.pwr.patrykzdral.nashorn_tic_tac_toe.model.BoardPosition");
var BoardEntity = Java.type("com.pwr.patrykzdral.nashorn_tic_tac_toe.model.BoardEntity");
var Board = Java.type("com.pwr.patrykzdral.nashorn_tic_tac_toe.model.Board");

var RandomStrategy = Java.extend(MoveStrategy, {
    nextMove: function(boardEntity, boardSituation) {

        var randomX, randomY;

        do {
            randomX = Math.floor(Math.random() * boardSituation.getSize());
            randomY = Math.floor(Math.random() * boardSituation.getSize());
        } while(boardSituation.getEntityAt(new BoardPosition(randomX, randomY)) !== BoardEntity.EMPTY);

        return new BoardPosition(randomX, randomY);
    },
    getIdentifier: function() {
        return "losowa miejsce";
    }
});

var strategy = new RandomStrategy();

