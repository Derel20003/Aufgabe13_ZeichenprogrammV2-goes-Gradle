package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Build Scene

        // Root (GridPane, everything is contained in here)
        GridPane root = new GridPane();
        root.setPrefSize(900, 500);

        // HBox
        HBox hBox = new HBox();
        hBox.setPrefSize(root.getPrefWidth(), root.getPrefHeight());
        root.getChildren().add(hBox);

        // SplitPanes and Panes
        SplitPane firstSplit = new SplitPane();
        SplitPane secondSplit = new SplitPane();
        SplitPane thirdSplit = new SplitPane();

        Pane firstPane = new Pane();
        Pane secondPane = new Pane();

        firstSplit.setPrefSize(299, 400);
        firstSplit.setStyle("-fx-background-color: grey;");

        firstPane.setPrefSize(1, 400);
        firstPane.setStyle("-fx-background-color: black;");

        secondSplit.setPrefSize(299, 400);
        secondSplit.setStyle("-fx-background-color: grey;");

        secondPane.setPrefSize(1, 400);
        secondPane.setStyle("-fx-background-color: black;");

        thirdSplit.setPrefSize(300, 400);
        thirdSplit.setStyle("-fx-background-color: grey;");

        hBox.getChildren().addAll(firstSplit, firstPane, secondSplit, secondPane, thirdSplit);

        // AnchorPanes
        AnchorPane firstAnchor = new AnchorPane();
        AnchorPane secondAnchor = new AnchorPane();

        AnchorPane thirdAnchor = new AnchorPane();
        AnchorPane fourthAnchor = new AnchorPane();

        AnchorPane fifthAnchor = new AnchorPane();
        AnchorPane sixthAnchor = new AnchorPane();

        firstAnchor.setPrefSize(297, 295);
        secondAnchor.setPrefSize(297, 195);
        firstSplit.setOrientation(Orientation.VERTICAL);
        firstSplit.getItems().addAll(firstAnchor, secondAnchor);
        firstSplit.setDividerPositions(0.6);

        thirdAnchor.setPrefSize(297, 295);
        fourthAnchor.setPrefSize(297, 195);
        secondSplit.setOrientation(Orientation.VERTICAL);
        secondSplit.getItems().addAll(thirdAnchor, fourthAnchor);
        secondSplit.setDividerPositions(0.6);

        fifthAnchor.setPrefSize(297, 295);
        sixthAnchor.setPrefSize(297, 195);
        thirdSplit.setOrientation(Orientation.VERTICAL);
        thirdSplit.getItems().addAll(fifthAnchor, sixthAnchor);
        thirdSplit.setDividerPositions(0.6);

        // Final Text and Panes

        // First AnchorPane
        Text firstAnchorTitleText = new Text("Rechteck");
        firstAnchorTitleText.setFont(new Font("Arial", 25));
        firstAnchorTitleText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(firstAnchorTitleText, 96.0);
        AnchorPane.setTopAnchor(firstAnchorTitleText, 37.0);

        Text firstAnchorColorText = new Text("Farbe:");
        firstAnchorColorText.setFont(new Font("Arial", 17));
        firstAnchorColorText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(firstAnchorColorText, 14.0);
        AnchorPane.setTopAnchor(firstAnchorColorText, 80.0);

        Text firstAnchorWidthText = new Text("Width:");
        firstAnchorWidthText.setFont(new Font("Arial", 17));
        firstAnchorWidthText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(firstAnchorWidthText, 14.0);
        AnchorPane.setTopAnchor(firstAnchorWidthText, 116.0);

        Text firstAnchorHeightText = new Text("Height:");
        firstAnchorHeightText.setFont(new Font("Arial", 17));
        firstAnchorHeightText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(firstAnchorHeightText, 14.0);
        AnchorPane.setTopAnchor(firstAnchorHeightText, 149.0);

        firstAnchor.getChildren().addAll(
                firstAnchorTitleText,
                firstAnchorColorText,
                firstAnchorWidthText,
                firstAnchorHeightText
        );

        // Third AnchorPane
        Text thirdAnchorTitleText = new Text("Text");
        thirdAnchorTitleText.setFont(new Font("Arial", 25));
        thirdAnchorTitleText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(thirdAnchorTitleText, 124.0);
        AnchorPane.setTopAnchor(thirdAnchorTitleText, 37.0);

        Text thirdAnchorColorText = new Text("Farbe:");
        thirdAnchorColorText.setFont(new Font("Arial", 17));
        thirdAnchorColorText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(thirdAnchorColorText, 14.0);
        AnchorPane.setTopAnchor(thirdAnchorColorText, 80.0);

        Text thirdAnchorFontText = new Text("Font:");
        thirdAnchorFontText.setFont(new Font("Arial", 17));
        thirdAnchorFontText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(thirdAnchorFontText, 14.0);
        AnchorPane.setTopAnchor(thirdAnchorFontText, 116.0);

        Text thirdAnchorStyleText = new Text("Style:");
        thirdAnchorStyleText.setFont(new Font("Arial", 17));
        thirdAnchorStyleText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(thirdAnchorStyleText, 14.0);
        AnchorPane.setTopAnchor(thirdAnchorStyleText, 149.0);

        thirdAnchor.getChildren().addAll(
                thirdAnchorTitleText,
                thirdAnchorColorText,
                thirdAnchorFontText,
                thirdAnchorStyleText
        );

        // Fifth AnchorPane

        Text fifthAnchorTitleText = new Text("Kreis");
        fifthAnchorTitleText.setFont(new Font("Arial", 25));
        fifthAnchorTitleText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(fifthAnchorTitleText, 120.0);
        AnchorPane.setTopAnchor(fifthAnchorTitleText, 37.0);

        Text fifthAnchorColorText = new Text("Farbe:");
        fifthAnchorColorText.setFont(new Font("Arial", 17));
        fifthAnchorColorText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(fifthAnchorColorText, 14.0);
        AnchorPane.setTopAnchor(fifthAnchorColorText, 80.0);

        Text fifthAnchorRadiusText = new Text("Radius:");
        fifthAnchorRadiusText.setFont(new Font("Arial", 17));
        fifthAnchorRadiusText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(fifthAnchorRadiusText, 14.0);
        AnchorPane.setTopAnchor(fifthAnchorRadiusText, 116.0);

        fifthAnchor.getChildren().addAll(
                fifthAnchorTitleText,
                fifthAnchorColorText,
                fifthAnchorRadiusText
        );

        // Main-Objects

        // Rectangle
        Pane rectBox;
        AnchorPane rectMain;

        // Rectangle, Controls and Effect
        Rectangle rectangle = new Rectangle();
        Spinner<Integer> rectWidthSpinner = new Spinner<>(10, 200, 10, 5);
        Spinner<Integer> rectHeightSpinner = new Spinner<>(10, 100, 10, 5);
        ColorPicker rectColor = new ColorPicker(Color.RED);
        Text rectEffText = new Text("Effekt");
        Button rectEffButton = new Button("Rotate");
        RotateTransition rectEff = new RotateTransition(Duration.seconds(4), rectangle);

        // Text
        Pane textBox;
        AnchorPane textMain;

        // Text, Controls and Effect
        Text text = new Text();
        ColorPicker textColor = new ColorPicker(Color.GREEN);
        ChoiceBox<String> fontBox = new ChoiceBox<>();
        ChoiceBox<String> styleBox = new ChoiceBox<>();
        Text textEffText = new Text("Effekt");
        Reflection textEff = new Reflection();
        Button textEffButton = new Button("Reflect");

        // Circle
        Pane circBox;
        AnchorPane circMain;

        // Circle, Controls and Effect
        Circle circle = new Circle();
        Spinner<Integer> circRadiusSpinner = new Spinner<>(10, 90, 10, 5);
        ColorPicker circColor = new ColorPicker(Color.BLUE);
        Text circEffText = new Text("Effekt");
        Button circEffButton = new Button("Move");
        Timeline circEff = new Timeline(
                new KeyFrame(Duration.seconds(1), new KeyValue(circle.centerXProperty(), 300)),
                new KeyFrame(Duration.seconds(3), new KeyValue(circle.centerXProperty(), 0)),
                new KeyFrame(Duration.seconds(4), new KeyValue(circle.centerXProperty(), 150))
        );

        Scene scene = new Scene(root, root.getPrefWidth(), root.getPrefHeight());
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Zeichenprogramm");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
