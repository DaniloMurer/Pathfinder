package com.danilojakob;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Logik {

    public int randomNumber() {
        int number = 0;

        number = (int) (Math.random() * 10);

        return number;
    }

    public static int testSelectPath(int[][] numbers, int h, int v) {
        int sum = 0;
        int tempJ = 0;
        int j = 0;
        outerloop:
        for (int i = 0; i < v; i++) {
            for (j = tempJ; j < h; j++) {

                if (i == 0 && j == 0) {
                    System.out.println(numbers[0][0]);
                    sum++;
                    tempJ = 0;
                }
                if (i == v - 1 && j == h - 1) {
                    sum++;
                    break outerloop;
                }

                if (i == v - 1) {
                    sum++;
                    tempJ = 0;
                    continue;
                }

                else if (j == h - 1) {
                    tempJ = j;
                    sum++;
                    break;
                }

                if (numbers[i + 1][j] < numbers[i][j + 1]) {
                    sum++;
                    tempJ = j;
                }
                else if (numbers[i + 1][j] == numbers[i][j + 1]) {
                    sum++;
                    tempJ = j;
                }
                else {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static int selectPath(Label[][] labels, Rectangle[][] rectangles, int h, int v) {

        int sum = 0;
        int tempJ = 0;
        int j = 0;
        outerloop:
        for (int i = 0; i < v; i++) {
            for (j = tempJ; j < h; j++) {

                if (i == 0 && j == 0) {
                    System.out.println(Integer.parseInt(labels[0][0].getText()));
                    rectangles[0][0].setFill(Color.GREEN);
                    sum++;
                    tempJ = 0;
                }
                if (i == v - 1 && j == h - 1) {
                    System.out.println("Am Ende angekommen");
                    sum++;
                    rectangles[v - 1][h - 1].setFill(Color.GREEN);
                    break outerloop;
                }

                if (i == v - 1) {
                    System.out.println(labels[i][j + 1].getText());
                    rectangles[i][j + 1].setFill(Color.GREEN);
                    sum++;
                    tempJ = 0;
                    continue;
                }

                else if (j == h - 1) {
                    System.out.println(labels[i + 1][j].getText());
                    rectangles[i + 1][j].setFill(Color.GREEN);
                    tempJ = j;
                    sum++;
                    break;
                }

                if (Integer.parseInt(labels[i + 1][j].getText()) < Integer.parseInt(labels[i][j + 1].getText())) {
                    System.out.println(labels[i + 1][j].getText());
                    rectangles[i + 1][j].setFill(Color.GREEN);
                    sum++;
                    tempJ = j;
                }
                else if (Integer.parseInt(labels[i + 1][j].getText()) == Integer.parseInt(labels[i][j + 1].getText())) {
                    System.out.println(labels[i + 1][j].getText());
                    sum++;
                    rectangles[i + 1][j].setFill(Color.GREEN);
                    tempJ = j;
                }
                else {
                    System.out.println(labels[i][j + 1].getText());
                    sum++;
                    rectangles[i][j + 1].setFill(Color.GREEN);
                }
            }
        }
        return sum;
    }

    public int maxPathLength(int i, int j) {
        int length = (i + j) - 1;

        return length;
    }
}
