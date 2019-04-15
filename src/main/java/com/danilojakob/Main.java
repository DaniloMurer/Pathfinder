package com.danilojakob;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    private static Logik logik = new Logik();
    private static Scanner scanner = new Scanner(System.in);
    public void start(Stage stage) {
        GridPane root = new GridPane();
        stage.setTitle("Pfadfinder");
        Scene scene = new Scene(root, 500, 400);
        //String css = this.getClass().getResource("application.css").toExternalForm();
        //root.getStylesheets().add(css);
        root.setVgap(10);
        root.setHgap(10);

        System.out.println("Höhe des Grids angeben: ");
        int height = Integer.parseInt(scanner.nextLine());
        System.out.println("Länge des Grids angeben: ");
        int length = Integer.parseInt(scanner.nextLine());

        Rectangle[][] rectangles = new Rectangle[length][height];
        Label[][] labels = new Label[length][height];

        Object[] arrays = createField(height, length, root);
        rectangles = (Rectangle[][]) arrays[0];
        labels = (Label[][]) arrays[1];

        Logik.selectPath(labels, rectangles, height, length);
        //Label label = new Label("Die Summe lautet: " + sum);
        //root.add(label, 0, height + 1, 2, 1);
        stage.setScene(scene);
        stage.show();
    }

    public static Object[] createField(int height, int length, GridPane root) {

        Rectangle[][] rectangles = new Rectangle[length][height];
        Label[][] labels = new Label[length][height];
        Object[] arrays = new Object[2];

        for (int i = 0; i < length; i++) {

            for (int j = 0; j < height; j++) {
                Rectangle r = new Rectangle();
                Label label = new Label((Integer.toString(logik.randomNumber())));
                root.setAlignment(Pos.CENTER);
                root.setHalignment(label, HPos.CENTER);
                r.setFill(Color.WHITE);
                r.setWidth(70);
                r.setHeight(70);
                root.add(r, i, j);
                root.add(label, i, j);
                rectangles[i][j] = r;
                labels[i][j] = label;
            }
        }
        arrays[0] = rectangles;
        arrays[1] = labels;

        return arrays;
    }

    public static Object[] testCreateField(int height, int length) {

        //Rectangle[][] rectangles = new Rectangle[length][height];
        int[][] numbers = new int[length][height];
        Object[] arrays = new Object[2];

        for (int i = 0; i < length; i++) {

            for (int j = 0; j < height; j++) {
                //Rectangle r = new Rectangle();
                int number = logik.randomNumber();
                //r.setFill(Color.WHITE);
               // r.setWidth(70);
                //r.setHeight(70);
                //rectangles[i][j] = r;
                numbers[i][j] = number;
            }
        }
        arrays[1] = numbers;

        return arrays;
    }

    public static void main(String[] args) {
	// write your code here
        launch(args);

    }
}
