package com.birmingham.hci.workshop.chen.worksheet5;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Chen Liu
 * Date: 2019/12/3
 * Time: 12:53 am
 */
public class Pie extends Application {
    /**
     * Arrays of expenditures
     */
    private Expenditure[] expenditures;

    /**
     * Sum of expenditures
     */
    private int sumExpenditures = 0;

    /**
     * The color index of blocks
     * The index is corresponding to POLYGON_COLOR_ARRAY
     */
    private Color[] blocksColor = new Color[100];

    /**
     * Maximum of expenditure shown in the chart.
     */
    private int maximum;

    /**
     * Some coordinate constants indicate the position
     * of the Waffle Chart
     */
    private final static int CIRCLE_X = 500;
    private final static int CIRCLE_Y = 400;
    private final static int TEXT_RATE = 7;

    /**
     * Some properties of circle
     */
    private final static int CIRCLE_R = 150;

    /**
     * Color array
     */
    private final static Color[] POLYGON_COLOR_ARRAY = new Color[]{
            Color.BLACK,
            Color.BLUE,
            Color.RED,
            Color.YELLOW,
            Color.GREEN,
            Color.BROWN,
            Color.DARKBLUE,
            Color.LIGHTBLUE
    };

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.expenditures =
                new Expenditure[]{
                        new Expenditure("Salaries", 11000),
                        new Expenditure("Paper", 2000),
                        new Expenditure("Rent", 5000),
                        new Expenditure("Most popular books on Java etc.", 10000),
                        new Expenditure("Heating", 3000),
                        new Expenditure("Coffee/Tea", 7000),
                        new Expenditure("Biscuits", 8000),
                        new Expenditure("Travel", 18000),
                        new Expenditure("Electricity", 1000),
                        new Expenditure("Pencils", 3000)
                };
        // Sort expenditures
        Arrays.sort(expenditures, (Expenditure exp1, Expenditure exp2) ->
                exp2.getValue() - exp1.getValue());
        this.maximum = 8;
        // Sum
        for (Expenditure expenditure : this.expenditures) {
            this.sumExpenditures += expenditure.getValue();
        }

        Circle circle = new Circle(CIRCLE_X, CIRCLE_Y, CIRCLE_R);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        // Generate Lines
        List<Node> lines = this.genLines();

        // Creating a Group object
        Group root = new Group(circle);
        root.getChildren().addAll(lines);

        // Creating a scene object
        Scene scene = new Scene(root, 1000, 800);

        // Setting title to the Stage
        stage.setTitle("Drawing a Polygon");

        // Adding scene to the stage
        stage.setScene(scene);

        // Displaying the contents of the stage
        stage.show();
    }

    /**
     * Generate Line according to the expenditures
     *
     * @return Shape list
     */
    private List<Node> genLines() {
        List<Node> lines = new ArrayList<>(this.maximum - 1);
        int i = 0;
        double sumOthers = 0;
        double radius = 0;
        for (Expenditure expenditure : this.expenditures) {
            if (i < this.maximum - 1) {
                // Show each expenditure
                int value = expenditure.getValue();
                double prop = Math.round(value * 100.0 / this.sumExpenditures);
                radius += 2 * Math.PI * prop / 100.0;
                double x = CIRCLE_X + CIRCLE_R * Math.cos(radius);
                double y = CIRCLE_Y + CIRCLE_R * Math.sin(radius);
                Line line = new Line(CIRCLE_X, CIRCLE_Y, x, y);
                lines.add(line);
                // Text
                String desc = expenditure.getDescription();
                double textX = CIRCLE_X + (CIRCLE_R + desc.length() * TEXT_RATE) * Math.cos(radius - Math.PI * prop / 100.0);
                double textY = CIRCLE_Y + (CIRCLE_R + desc.length() * TEXT_RATE) * Math.sin(radius - Math.PI * prop / 100.0);
                Text text = new Text(textX, textY, expenditure.getDescription());
                lines.add(text);
            } else {
                // Sum to others
                sumOthers += expenditure.getValue();
            }
            i++;
        }
        // others line
        radius += 2 * Math.PI * sumOthers / this.sumExpenditures;
        double othersX = CIRCLE_X + CIRCLE_R * Math.cos(radius);
        double othersY = CIRCLE_Y + CIRCLE_R * Math.sin(radius);
        Line line = new Line(CIRCLE_X, CIRCLE_Y, othersX, othersY);
        lines.add(line);
        // Text
        double textX = CIRCLE_X + (CIRCLE_R + "Other".length() * TEXT_RATE) * Math.cos(radius - Math.PI * sumOthers / this.sumExpenditures);
        double textY = CIRCLE_Y + (CIRCLE_R + "Other".length() * TEXT_RATE) * Math.sin(radius - Math.PI * sumOthers / this.sumExpenditures);
        Text text = new Text(textX, textY, "Other");
        lines.add(text);

        return lines;
    }
}
