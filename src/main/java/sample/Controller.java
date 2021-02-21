package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Spinner;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {

    // FXML-Object
    @FXML
    public Stage stage;

    // Rectangle
    @FXML
    public Pane rectBox;
    @FXML
    public AnchorPane rectMain;

    // Rectangle, Controls and Effect
    public Rectangle rectangle = new Rectangle();
    public Spinner<Integer> rectWidthSpinner = new Spinner<>(10, 200, 10, 5);
    public Spinner<Integer> rectHeightSpinner = new Spinner<>(10, 100, 10, 5);
    public ColorPicker rectColor = new ColorPicker(Color.RED);
    public Text rectEffText = new Text("Effekt");
    public Button rectEffButton = new Button("Rotate");
    public RotateTransition rectEff = new RotateTransition(Duration.seconds(4), rectangle);

    // Text
    @FXML
    public Pane textBox;
    @FXML
    public AnchorPane textMain;

    // Text, Controls and Effect
    public Text text = new Text();
    public ColorPicker textColor = new ColorPicker(Color.GREEN);
    public ChoiceBox<String> fontBox = new ChoiceBox<>();
    public ChoiceBox<String> styleBox = new ChoiceBox<>();
    public Text textEffText = new Text("Effekt");
    public Reflection textEff = new Reflection();
    public Button textEffButton = new Button("Reflect");

    // Circle
    @FXML
    public Pane circBox;
    @FXML
    public AnchorPane circMain;

    // Circle, Controls and Effect
    public Circle circle = new Circle();
    public Spinner<Integer> circRadiusSpinner = new Spinner<>(10, 90, 10, 5);
    public ColorPicker circColor = new ColorPicker(Color.BLUE);
    public Text circEffText = new Text("Effekt");
    public Button circEffButton = new Button("Move");
    public Timeline circEff = new Timeline(
            new KeyFrame(Duration.seconds(1), new KeyValue(circle.centerXProperty(), 300)),
            new KeyFrame(Duration.seconds(3), new KeyValue(circle.centerXProperty(), 0)),
            new KeyFrame(Duration.seconds(4), new KeyValue(circle.centerXProperty(), 150))
    );

    // Initialize, adds Controls to panels and sets values
    public void initialize(){
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
        rectMain.getChildren().addAll(rectColor, rectWidthSpinner, rectHeightSpinner, rectEffText, rectEffButton);

        // Sets Rectangle position and binds values to controls
        rectangle.setLayoutX(50);
        rectangle.setLayoutY(50);
        rectangle.widthProperty().bind(rectWidthSpinner.valueProperty());
        rectangle.heightProperty().bind(rectHeightSpinner.valueProperty());
        rectangle.fillProperty().bind(rectColor.valueProperty());

        // Adds Rectangle to pane
        rectBox.getChildren().add(rectangle);

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
            if(text.getEffect() == null){
                text.setEffect(textEff);
                textEffButton.setText(" Stop ");
            }else{
                text.setEffect(null);
                textEffButton.setText("Reflect");
            }
        });

        // Adds Controls to right pane
        textMain.getChildren().addAll(fontBox, textColor, styleBox, textEffText, textEffButton);

        // Sets Text position, size and text and binds color-value to controls
        text.setFont(new Font(30));
        text.setText("Hello");
        text.setLayoutX(130);
        text.setLayoutY(100);
        text.fillProperty().bind(textColor.valueProperty());

        // Adds text to pane
        textBox.getChildren().add(text);

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
        circMain.getChildren().addAll(circColor, circRadiusSpinner, circEffText, circEffButton);

        // Sets Circle position and binds values to controls
        circle.setCenterX(150);
        circle.setCenterY(100);
        circle.radiusProperty().bind(circRadiusSpinner.valueProperty());
        circle.fillProperty().bind(circColor.valueProperty());

        // Adds circle to pane
        circBox.getChildren().add(circle);
    }

    // Sets stage with passed scene ("needed" so that scene and stage can be set multiple times)
    public void setStage(Stage stage, Scene scene){
        this.stage = stage;
        this.stage.setScene(scene);
    }
}