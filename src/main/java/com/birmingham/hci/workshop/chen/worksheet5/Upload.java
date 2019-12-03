package com.birmingham.hci.workshop.chen.worksheet5;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * User: Chen Liu
 * Date: 2019/11/30
 * Time: 10:41 pm
 */
public class Upload extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * width and length of left and right Polygon
     */
    private final static double SIDE_WIDTH = 30;
    private final static double SIDE_LENGTH = 130;

    @Override
    public void start(Stage stage) throws Exception {
        /**
         * coordinates of rectangles
         */
        double leftX = 150.0;
        double leftY = 80.0;
        double rightX = 350.0;
        double rightY = leftY;
        double bottomX = leftX + SIDE_WIDTH;
        double bottomY = leftY + SIDE_LENGTH - SIDE_WIDTH;
        // Creating left Polygon
        Polygon left = new Polygon(
                leftX, leftY,
                leftX + SIDE_WIDTH, leftY,
                leftX + SIDE_WIDTH, leftY + SIDE_LENGTH,
                leftX, leftY + SIDE_LENGTH
        );
        // Creating right Polygon
        Polygon right = new Polygon(
                rightX, rightY,
                rightX + SIDE_WIDTH, rightY,
                rightX + SIDE_WIDTH, rightY + SIDE_LENGTH,
                rightX, rightY + SIDE_LENGTH
        );
        // Creating bottom Polygon
        Polygon bottom = new Polygon(
                bottomX, bottomY,
                rightX, bottomY,
                rightX, bottomY + SIDE_WIDTH,
                bottomX, bottomY + SIDE_WIDTH
        );

        /**
         * Coordinates of the arrow's triangle
         */
        double tTopX = (leftX + rightX + SIDE_WIDTH) / 2;
        double tTopY = leftY - 70;
        double tLeftX = tTopX - 3.0/2 * SIDE_WIDTH;
        double tLeftY = tTopY + 30;
        double tRightX = tTopX + 3.0/2 * SIDE_WIDTH;
        double tRightY = tLeftY;
        Polygon triangle = new Polygon(
                tTopX, tTopY,
                tLeftX, tLeftY,
                tRightX, tRightY
        );

        /**
         * Coordinates of the arrow's bottom
         */
        double aBottomX = tTopX - 0.5 * SIDE_WIDTH;
        double aBottomY = tLeftY;
        double lengthRatio = 0.75;
        Polygon aBottom = new Polygon(
                aBottomX, aBottomY,
                aBottomX + SIDE_WIDTH, aBottomY,
                aBottomX + SIDE_WIDTH, aBottomY + SIDE_LENGTH * lengthRatio,
                aBottomX, aBottomY + SIDE_LENGTH * lengthRatio
        );

        //Creating a Group object
        Group root = new Group(left, right, bottom, triangle, aBottom);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 300);

        //Setting title to the Stage
        stage.setTitle("Drawing a Upload");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }
}
