package com.birmingham.hci.workshop.chen.worksheet5;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Chen Liu
 * Date: 2019/12/1
 * Time: 7:09 pm
 */
public class Waffle extends Application {

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
    private final static int INIT_X = 50;
    private final static int INIT_Y = 50;
    private final static int BLOCK_WIDTH = 50;
    private final static int LABEL_MARGIN_LEFT = 100;
    private final static int LABEL_MARGIN_TOP = 50;

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

        // Generate Labels
        List<Node> labels = this.genLabelPolygons();

        // Generate blocks color
        this.generateBlocksColor();

        // Generate Waffle chart
        List<Node> blocks = this.genBlocks();

        // Creating a Group object
        Group root = new Group();
        // Add labels
        root.getChildren().addAll(labels);
        // Add blocks
        root.getChildren().addAll(blocks);

        // Creating a scene object
        Scene scene = new Scene(root, 1000, 600);

        // Setting title to the Stage
        stage.setTitle("Drawing a Polygon");

        // Adding scene to the stage
        stage.setScene(scene);

        // Displaying the contents of the stage
        stage.show();
    }

    /**
     * Generate Label polygons according to the expenditures
     *
     * @return Shape list
     */
    private List<Node> genLabelPolygons() {
        // One polygon with one text, so the length should double
        List<Node> labels = new ArrayList<>(16);
        int count = 0;
        // X axis value of labels
        int x = INIT_X + 10 * BLOCK_WIDTH + LABEL_MARGIN_LEFT;
        // Y axis value of labels
        int y = INIT_Y + LABEL_MARGIN_TOP;
        // Label's y delta
        int yDelta = 0;
        // Has generate other label
        boolean hasGenOther = false;
        for (Expenditure expenditure : this.expenditures) {
            // Calculate the yDelta of labels
            yDelta = count * BLOCK_WIDTH;
            String desc = expenditure.getDescription();
            int value = expenditure.getValue();
            if (count >= this.maximum - 1) {
                // equals to maximum - 1, sum to others
                if (!hasGenOther) {
                    Polygon label = new Polygon(
                            x, y + yDelta,
                            x + BLOCK_WIDTH, y + yDelta,
                            x + BLOCK_WIDTH, y + yDelta + BLOCK_WIDTH,
                            x, y + yDelta + BLOCK_WIDTH
                    );
                    // Set border
                    label.setStroke(Color.WHITE);
                    // Set color
                    label.setFill(POLYGON_COLOR_ARRAY[count % 8]);
                    labels.add(label);
                    // Generate the text
                    Text text = new Text(x + BLOCK_WIDTH + 10, y + yDelta + 25, "Other");
                    labels.add(text);
                    hasGenOther = true;
                }
            } else {
                // less than maximum
                Polygon label = new Polygon(
                        x, y + yDelta,
                        x + BLOCK_WIDTH, y + yDelta,
                        x + BLOCK_WIDTH, y + yDelta + BLOCK_WIDTH,
                        x, y + yDelta + BLOCK_WIDTH
                );
                // Set border
                label.setStroke(Color.WHITE);
                // Set color
                label.setFill(POLYGON_COLOR_ARRAY[count % 8]);
                labels.add(label);
                // Generate the text
                Text text = new Text(x + BLOCK_WIDTH + 10, y + yDelta + 25, desc);
                labels.add(text);
            }
            count++;
        }

        return labels;
    }

    /**
     * Generate blocks color by expenditures
     */
    private void generateBlocksColor() {
        // index of colorArray
        int index = 0;
        int i;
        for (i = 0; i < this.maximum - 1; i++) {
            int value = this.expenditures[i].getValue();
            double prop = Math.round(value * 100.0 / this.sumExpenditures);
            while (prop > 0) {
                this.blocksColor[index] = POLYGON_COLOR_ARRAY[i % 8];
                index++;
                prop--;
            }
        }
        // Rest blocks are others
        for (int j = index; j < 100; j++) {
            this.blocksColor[j] = POLYGON_COLOR_ARRAY[i % 8];
        }
    }

    /**
     * Generate the blocks of waffle chart
     *
     * @return List
     */
    private List<Node> genBlocks() {
        List<Node> blocks = new ArrayList<>(100);
        // x axis position of the first block
        int x = INIT_X;
        // y axis position of the first block
        int y = INIT_Y;
        for (int i = 0; i < 100; i++) {
            if (i > 1 && i % 10 == 0) {
                y += BLOCK_WIDTH;
                x = INIT_X;
            }
            x += BLOCK_WIDTH;
            Polygon block = new Polygon(
                    x, y,
                    x + BLOCK_WIDTH, y,
                    x + BLOCK_WIDTH, y + BLOCK_WIDTH,
                    x, y + BLOCK_WIDTH
            );
            // Set border
            block.setStroke(Color.WHITE);
            // Set color
            block.setFill(this.blocksColor[i]);
            blocks.add(block);
        }
        return blocks;
    }

    // Getters & Setters
    public Expenditure[] getExpenditures() {
        return expenditures;
    }

    public void setExpenditures(Expenditure[] expenditures) {
        this.expenditures = expenditures;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}
