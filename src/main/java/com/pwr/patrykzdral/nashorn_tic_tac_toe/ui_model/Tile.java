package com.pwr.patrykzdral.nashorn_tic_tac_toe.ui_model;

import com.pwr.patrykzdral.nashorn_tic_tac_toe.model.BoardPosition;
import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static com.pwr.patrykzdral.nashorn_tic_tac_toe.controller.MainController.*;


public class Tile extends StackPane {
    private int x;
    private int y;
    private Text text = new Text();

    public Tile(int x, int y) {
        this.x = x;
        this.y= y;
        Rectangle border = new Rectangle(150, 150);
        border.setFill(null);
        border.setStroke(Color.BLACK);

        text.setFont(Font.font(72));

        setAlignment(Pos.CENTER);
        getChildren().addAll(border, text);

        setOnMouseClicked(event -> {
            if (!playable)
                return;

            if (event.getButton() == MouseButton.PRIMARY) {
                if (!turnX)
                    return;

                drawX();
                gameManager.executePlayerMove(new BoardPosition(this.x,this.y));
                checkState();
                if (playable){
                    gameManager.executeAiMove();
                    checkState();
                }

            }

        });
    }

    public double getCenterX() {
        return getTranslateX() + 75;
    }

    public double getCenterY() {
        return getTranslateY() + 75;
    }

    public String getValue() {
        return text.getText();
    }

    private void drawX() {
        text.setText("X");
    }

    public void drawO() {
        text.setText("O");
    }
}
