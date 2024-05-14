package com.example.sppa;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Task_02 extends Application {

    @Override
    public void start(Stage primaryStage) {
        int width = 600;
        int height = 600;
        int depth = 4; // Глубина рекурсии

        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Minkowski Island");

        drawMinkowskiIsland(root, width / 4, height / 4, width / 2, height / 2, depth);

        primaryStage.show();
    }

    private void drawMinkowskiIsland(Group group, double x, double y, double width, double height, int depth) {
        if (depth == 0) {
            Rectangle square = new Rectangle(x, y, width, height);
            square.setFill(Color.BLACK);
            group.getChildren().add(square);
        } else {
            double newWidth = width / 2;
            double newHeight = height / 2;

            // Отрисовка внешнего квадрата
            Rectangle outerSquare = new Rectangle(x, y, width, height);
            outerSquare.setFill(Color.WHITE);
            group.getChildren().add(outerSquare);

            // Вычисление координат внутренних квадратов
            double innerX = x + newWidth / 2;
            double innerY = y + newHeight / 2;

            // Рекурсивное построение внутренних квадратов
            drawMinkowskiIsland(group, innerX, innerY, newWidth, newHeight, depth - 1);
            drawMinkowskiIsland(group, x, y + newHeight, newWidth, newHeight, depth - 1);
            drawMinkowskiIsland(group, x + newWidth, y + newHeight, newWidth, newHeight, depth - 1);
            drawMinkowskiIsland(group, x + newWidth, y, newWidth, newHeight, depth - 1);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
