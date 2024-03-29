//package com.pwr.patrykzdral.nashorn_tic_tac_toe;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.pwr.patrykzdral.nashorn_tic_tac_toe.manager.GameManager;
//import com.pwr.patrykzdral.nashorn_tic_tac_toe.model.Board;
//import com.pwr.patrykzdral.nashorn_tic_tac_toe.move.MoveStrategy;
//import com.pwr.patrykzdral.nashorn_tic_tac_toe.move.MoveStrategyFromJSFile;
//import com.pwr.patrykzdral.nashorn_tic_tac_toe.ui_model.Combo;
//import com.pwr.patrykzdral.nashorn_tic_tac_toe.ui_model.Tile;
//import javafx.animation.KeyFrame;
//import javafx.animation.KeyValue;
//import javafx.animation.Timeline;
//import javafx.application.Application;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.layout.Pane;
//import javafx.scene.shape.Line;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//import javax.script.ScriptException;
//
//public class TicTacToeApp extends Application {
//
//    private MoveStrategy enemyMoveStrategy = new MoveStrategyFromJSFile().load(new File("src/main/resources/move_strategies/randomStrategy.js"));
//    public static GameManager gameManager = new GameManager();
//
//
//    public static boolean playable = true;
//    public static boolean turnX = true;
//    public static Tile[][] board = new Tile[5][5];
//    private static List<Combo> combos = new ArrayList<>();
//
//    private static Pane root = new Pane();
//
//    public TicTacToeApp() throws FileNotFoundException, ScriptException {
//    }
//
//    private Parent createContent() {
//        root.setPrefSize(750, 750);
//
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                Tile tile = new Tile(i,j);
//                tile.setTranslateX(j * 150);
//                tile.setTranslateY(i * 150);
//
//                root.getChildren().add(tile);
//
//                board[j][i] = tile;
//            }
//        }
//
//        // horizontal
//        for (int y = 0; y < 5; y++) {
//            combos.add(new Combo(board[0][y], board[1][y], board[2][y],board[3][y],board[4][y]));
//        }
//
//        // vertical
//        for (int x = 0; x < 5; x++) {
//            combos.add(new Combo(board[x][0], board[x][1], board[x][2],board[x][3],board[x][4]));
//        }
//
//        // diagonals
//        combos.add(new Combo(board[0][0], board[1][1], board[2][2],board[3][3],board[4][4]));
//        combos.add(new Combo(board[4][0], board[3][1], board[2][2],board[1][3],board[0][4]));
//
//        return root;
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        primaryStage.setScene(new Scene(createContent()));
//        primaryStage.show();
//        gameManager.startNewGame();
//        gameManager.setEnemyMoveStrategy(enemyMoveStrategy);
//
//    }
//
//    public static void checkState() {
//        for (Combo combo : combos) {
//            if (combo.isComplete()) {
//                playable = false;
//                playWinAnimation(combo);
//                break;
//            }
//        }
//    }
//
//    public static void playWinAnimation(Combo combo) {
//        Line line = new Line();
//        line.setStartX(combo.tiles[0].getCenterX());
//        line.setStartY(combo.tiles[0].getCenterY());
//        line.setEndX(combo.tiles[0].getCenterX());
//        line.setEndY(combo.tiles[0].getCenterY());
//
//        root.getChildren().add(line);
//
//        Timeline timeline = new Timeline();
//        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
//                new KeyValue(line.endXProperty(), combo.tiles[4].getCenterX()),
//                new KeyValue(line.endYProperty(), combo.tiles[4].getCenterY())));
//        timeline.play();
//    }
//
//
//
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
