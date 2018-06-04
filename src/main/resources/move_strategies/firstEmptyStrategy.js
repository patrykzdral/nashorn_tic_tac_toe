var MoveStrategy = Java.type("com.pwr.patrykzdral.nashorn_tic_tac_toe.move.MoveStrategy");

var BoardPosition = Java.type("com.pwr.patrykzdral.nashorn_tic_tac_toe.model.BoardPosition");
var BoardEntity = Java.type("com.pwr.patrykzdral.nashorn_tic_tac_toe.model.BoardEntity");
var Board = Java.type("com.pwr.patrykzdral.nashorn_tic_tac_toe.model.Board");

var FirstAvailableStrategy = Java.extend(MoveStrategy, {
    nextMove: function(boardEntity, boardSituation) {

        for(var x = 0 ; x < boardSituation.getSize() ; x++) {
            for(var y = 0 ; y < boardSituation.getSize() ; y++) {
                if(boardSituation.getEntityAt(new BoardPosition(x, y)) === BoardEntity.EMPTY) {
                    return new BoardPosition(x, y);
                }
            }
        }

        return null;
    },

    getIdentifier: function() {
        return "pierwsze wolne miejsce";
    }
});

var strategy = new FirstAvailableStrategy();
