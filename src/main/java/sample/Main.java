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
    public void start(Stage primaryStage) {

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
        AnchorPane.setTopAnchor(firstAnchorTitleText, 17.0);

        Text firstAnchorColorText = new Text("Farbe:");
        firstAnchorColorText.setFont(new Font("Arial", 17));
        firstAnchorColorText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(firstAnchorColorText, 14.0);
        AnchorPane.setTopAnchor(firstAnchorColorText, 70.0);

        Text firstAnchorWidthText = new Text("Width:");
        firstAnchorWidthText.setFont(new Font("Arial", 17));
        firstAnchorWidthText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(firstAnchorWidthText, 14.0);
        AnchorPane.setTopAnchor(firstAnchorWidthText, 106.0);

        Text firstAnchorHeightText = new Text("Height:");
        firstAnchorHeightText.setFont(new Font("Arial", 17));
        firstAnchorHeightText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(firstAnchorHeightText, 14.0);
        AnchorPane.setTopAnchor(firstAnchorHeightText, 139.0);

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
        AnchorPane.setTopAnchor(thirdAnchorTitleText, 17.0);

        Text thirdAnchorColorText = new Text("Farbe:");
        thirdAnchorColorText.setFont(new Font("Arial", 17));
        thirdAnchorColorText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(thirdAnchorColorText, 14.0);
        AnchorPane.setTopAnchor(thirdAnchorColorText, 70.0);

        Text thirdAnchorFontText = new Text("Font:");
        thirdAnchorFontText.setFont(new Font("Arial", 17));
        thirdAnchorFontText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(thirdAnchorFontText, 14.0);
        AnchorPane.setTopAnchor(thirdAnchorFontText, 106.0);

        Text thirdAnchorStyleText = new Text("Style:");
        thirdAnchorStyleText.setFont(new Font("Arial", 17));
        thirdAnchorStyleText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(thirdAnchorStyleText, 14.0);
        AnchorPane.setTopAnchor(thirdAnchorStyleText, 139.0);

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
        AnchorPane.setTopAnchor(fifthAnchorTitleText, 17.0);

        Text fifthAnchorColorText = new Text("Farbe:");
        fifthAnchorColorText.setFont(new Font("Arial", 17));
        fifthAnchorColorText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(fifthAnchorColorText, 14.0);
        AnchorPane.setTopAnchor(fifthAnchorColorText, 70.0);

        Text fifthAnchorRadiusText = new Text("Radius:");
        fifthAnchorRadiusText.setFont(new Font("Arial", 17));
        fifthAnchorRadiusText.setFill(Color.WHITE);
        AnchorPane.setLeftAnchor(fifthAnchorRadiusText, 14.0);
        AnchorPane.setTopAnchor(fifthAnchorRadiusText, 106.0);

        fifthAnchor.getChildren().addAll(
                fifthAnchorTitleText,
                fifthAnchorColorText,
                fifthAnchorRadiusText
        );

        // Second AnchorPane
        Pane secondAnchorFirstPane = new Pane();
        secondAnchorFirstPane.setPrefSize(299, 200);
        secondAnchorFirstPane.setStyle("-fx-background-color: white;");
        secondAnchor.getChildren().add(secondAnchorFirstPane);

        // Fourth AnchorPane
        Pane fourthAnchorFirstPane = new Pane();
        fourthAnchorFirstPane.setPrefSize(299, 200);
        fourthAnchorFirstPane.setStyle("-fx-background-color: white;");
        fourthAnchor.getChildren().add(fourthAnchorFirstPane);

        // Sixth AnchorPane
        Pane sixthAnchorFirstPane = new Pane();
        sixthAnchorFirstPane.setPrefSize(299, 200);
        sixthAnchorFirstPane.setStyle("-fx-background-color: white;");
        sixthAnchor.getChildren().add(sixthAnchorFirstPane);

        // Main-Objects

        // Rectangle, Controls and Effect
        Rectangle rectangle = new Rectangle();
        Spinner<Integer> rectWidthSpinner = new Spinner<>(10, 200, 10, 5);
        Spinner<Integer> rectHeightSpinner = new Spinner<>(10, 100, 10, 5);
        ColorPicker rectColor = new ColorPicker(Color.RED);
        Text rectEffText = new Text("Effekt");
        Button rectEffButton = new Button("Rotate");
        RotateTransition rectEff = new RotateTransition(Duration.seconds(4), rectangle);

        // Text, Controls and Effect
        Text text = new Text();
        ColorPicker textColor = new ColorPicker(Color.GREEN);
        ChoiceBox<String> fontBox = new ChoiceBox<>();
        ChoiceBox<String> styleBox = new ChoiceBox<>();
        Text textEffText = new Text("Effekt");
        Reflection textEff = new Reflection();
        Button textEffButton = new Button("Reflect");

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

        // Rectangle
        // Sets sizes/position for controls and adds effect
        rectColor.setPrefSize(140, 27);
        rectColor.setLayoutX(141);
        rectColor.setLayoutY(61);

        rectWidthSpinner.setPrefSize(140, 27);
        rectWidthSpinner.setLayoutX(141);
        rectWidthSpinner.setLayoutY(97);

        rectHeightSpinner.setPrefSize(140, 27);
        rectHeightSpinner.setLayoutX(141);
        rectHeightSpinner.setLayoutY(133);

        rectEffText.setFont(new Font(23));
        rectEffText.setFill(Color.WHITE);
        rectEffText.setLayoutX(120);
        rectEffText.setLayoutY(210);

        rectEff.setFromAngle(0.0);
        rectEff.setToAngle(360.0);

        rectEffButton.setTextFill(Color.GRAY);
        rectEffButton.setLayoutX(120);
        rectEffButton.setLayoutY(230);
        rectEffButton.setOnMouseClicked(mouseEvent -> rectEff.play());

        // Adds Controls to right pane
        firstAnchor.getChildren().addAll(rectColor, rectWidthSpinner, rectHeightSpinner, rectEffText, rectEffButton);

        // Sets Rectangle position and binds values to controls
        rectangle.setLayoutX(50);
        rectangle.setLayoutY(50);
        rectangle.widthProperty().bind(rectWidthSpinner.valueProperty());
        rectangle.heightProperty().bind(rectHeightSpinner.valueProperty());
        rectangle.fillProperty().bind(rectColor.valueProperty());

        // Adds Rectangle to pane
        secondAnchorFirstPane.getChildren().add(rectangle);

        // Text
        // Sets sizes/position for controls and adds effect
        textColor.setPrefSize(140, 27);
        textColor.setLayoutX(141);
        textColor.setLayoutY(61);

        fontBox.setPrefSize(140, 27);
        fontBox.setLayoutX(141);
        fontBox.setLayoutY(97);
        // Adds items to ChoiceBox
        fontBox.getItems().addAll(Font.getFontNames());
        // Listens to changes in ChoiceBox and changes text font
        fontBox.valueProperty().addListener((observableValue, s, t1) -> text.setFont(new Font(fontBox.getValue(), 30)));

        styleBox.setPrefSize(140, 27);
        styleBox.setLayoutX(141);
        styleBox.setLayoutY(133);
        // Adds items to ChoiceBox
        styleBox.getItems().addAll("Italic", "Normal");
        // Listens to changes in ChoiceBox and changes text style
        styleBox.valueProperty().addListener((observableValue, s, t1) -> text.setStyle("-fx-font-style: " + styleBox.getValue()));

        textEffText.setFont(new Font(23));
        textEffText.setFill(Color.WHITE);
        textEffText.setLayoutX(120);
        textEffText.setLayoutY(210);

        textEffButton.setTextFill(Color.GRAY);
        textEffButton.setLayoutX(120);
        textEffButton.setLayoutY(230);
        textEffButton.setOnMouseClicked(mouseEvent -> {
            if (text.getEffect() == null) {
                text.setEffect(textEff);
                textEffButton.setText(" Stop ");
            } else {
                text.setEffect(null);
                textEffButton.setText("Reflect");
            }
        });

        // Adds Controls to right pane
        thirdAnchor.getChildren().addAll(fontBox, textColor, styleBox, textEffText, textEffButton);

        // Sets Text position, size and text and binds color-value to controls
        text.setFont(new Font(30));
        text.setText("Hello");
        text.setLayoutX(130);
        text.setLayoutY(100);
        text.fillProperty().bind(textColor.valueProperty());

        // Adds text to pane
        fourthAnchorFirstPane.getChildren().add(text);

        // Circle
        // Sets sizes/position for controls and adds effect
        circColor.setPrefSize(140, 27);
        circColor.setLayoutX(141);
        circColor.setLayoutY(61);

        circRadiusSpinner.setPrefSize(140, 27);
        circRadiusSpinner.setLayoutX(141);
        circRadiusSpinner.setLayoutY(97);

        circEffText.setFont(new Font(23));
        circEffText.setFill(Color.WHITE);
        circEffText.setLayoutX(120);
        circEffText.setLayoutY(175);

        circEffButton.setTextFill(Color.GRAY);
        circEffButton.setLayoutX(125);
        circEffButton.setLayoutY(195);
        circEffButton.setOnMouseClicked(mouseEvent -> circEff.play());

        // Adds Controls to right pane
        fifthAnchor.getChildren().addAll(circColor, circRadiusSpinner, circEffText, circEffButton);

        // Sets Circle position and binds values to controls
        circle.setCenterX(150);
        circle.setCenterY(100);
        circle.radiusProperty().bind(circRadiusSpinner.valueProperty());
        circle.fillProperty().bind(circColor.valueProperty());

        // Adds circle to pane
        sixthAnchorFirstPane.getChildren().add(circle);

        // Finish Scene
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
