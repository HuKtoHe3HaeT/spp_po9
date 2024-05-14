package com.example.sppa;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

class LineSegment {
    private Point point1;
    private Point point2;

    public LineSegment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public boolean isPointOnSameSide(Point point) {
        double dx1 = point2.getX() - point1.getX();
        double dy1 = point2.getY() - point1.getY();
        double dx2 = point.getX() - point1.getX();
        double dy2 = point.getY() - point1.getY();
        return (dx1 * dy2 - dy1 * dx2) >= 0;
    }
}

public class Task_01 extends Application {

    @Override
    public void start(Stage primaryStage) {
        int n = 10; // Количество точек

        List<Point> points = generateRandomPoints(n);
        LineSegment lineSegment = generateRandomLineSegment();

        Group root = new Group();
        Scene scene = new Scene(root, 600, 400, Color.WHITE);

        drawLineSegment(root, lineSegment);
        drawPoints(root, points);

        primaryStage.setTitle("Points on Line Segment");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Определение, на какой стороне от линии находятся точки
        for (Point point : points) {
            boolean onSameSide = lineSegment.isPointOnSameSide(point);
            System.out.println("Point (" + point.getX() + ", " + point.getY() + ") is on the same side as line segment: " + onSameSide);
        }
    }

    private List<Point> generateRandomPoints(int n) {
        Random random = new Random();
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double x = random.nextDouble() * 600; // случайная координата x в пределах окна
            double y = random.nextDouble() * 400; // случайная координата y в пределах окна
            points.add(new Point(x, y));
        }
        return points;
    }

    private LineSegment generateRandomLineSegment() {
        Random random = new Random();
        Point point1 = new Point(random.nextDouble() * 600, random.nextDouble() * 400);
        Point point2 = new Point(random.nextDouble() * 600, random.nextDouble() * 400);
        return new LineSegment(point1, point2);
    }

    private void drawLineSegment(Group root, LineSegment lineSegment) {
        Point point1 = lineSegment.getPoint1();
        Point point2 = lineSegment.getPoint2();
        Line lineUI = new Line(point1.getX(), point1.getY(), point2.getX(), point2.getY());
        lineUI.setStroke(Color.RED);
        root.getChildren().add(lineUI);
    }

    private void drawPoints(Group root, List<Point> points) {
        for (Point point : points) {
            Circle circle = new Circle(point.getX(), point.getY(), 3, Color.BLUE);
            root.getChildren().add(circle);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
