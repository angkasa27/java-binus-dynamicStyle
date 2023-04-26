import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class App extends Application {

  private static final int SCENE_WIDTH = 420;
  private static final int SCENE_HEIGHT = 150;
  private static final int TEXT_SIZE = 20;
  private static final int MAX_TEXT_SHIFT = 120;
  private static final Font TEXT_FONT = new Font("Arial", TEXT_SIZE);

  private Label textLabel;
  private int textShift = 0;

  @Override
  public void start(Stage primaryStage) {
    // Create the radio buttons for the text color
    ToggleGroup colorGroup = new ToggleGroup();
    RadioButton redButton = new RadioButton("Red");
    RadioButton yellowButton = new RadioButton("Yellow");
    RadioButton blackButton = new RadioButton("Black");
    RadioButton orangeButton = new RadioButton("Orange");
    RadioButton greenButton = new RadioButton("Green");
    redButton.setToggleGroup(colorGroup);
    yellowButton.setToggleGroup(colorGroup);
    blackButton.setToggleGroup(colorGroup);
    orangeButton.setToggleGroup(colorGroup);
    greenButton.setToggleGroup(colorGroup);
    redButton.setSelected(true); // set default color

    // Add event handlers for the radio buttons
    redButton.setOnAction(event -> textLabel.setTextFill(Color.RED));
    yellowButton.setOnAction(event -> textLabel.setTextFill(Color.YELLOW));
    blackButton.setOnAction(event -> textLabel.setTextFill(Color.BLACK));
    orangeButton.setOnAction(event -> textLabel.setTextFill(Color.ORANGE));
    greenButton.setOnAction(event -> textLabel.setTextFill(Color.GREEN));

    // Create the label for the text
    textLabel = new Label("Programming is fun");
    textLabel.setFont(TEXT_FONT);
    textLabel.setTextAlignment(TextAlignment.CENTER);
    textLabel.setTextFill(Color.RED);

    // Create the buttons for shifting the text left and right
    Button leftButton = new Button("<=");
    Button rightButton = new Button("=>");
    leftButton.setOnAction(event -> shiftText(-20));
    rightButton.setOnAction(event -> shiftText(20));

    // Create the layout for the colorButton
    HBox colorBox = new HBox(10, redButton, yellowButton, blackButton, orangeButton, greenButton);
    colorBox.setAlignment(Pos.CENTER);

    // Create the layout for the arrowButton
    HBox arrowBox = new HBox(10, leftButton,
        rightButton);
    arrowBox.setAlignment(Pos.CENTER);

    // Create the layout for the scene
    VBox root = new VBox(20, colorBox, textLabel, arrowBox);
    root.setPadding(new Insets(20));
    root.setAlignment(Pos.CENTER);

    // Set the scene
    Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

    // Set the stage
    primaryStage.setTitle("JavaFX Program");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  // Method to shift the text label by a given amount
  private void shiftText(int amount) {
    textShift += amount;
    if (textShift < -MAX_TEXT_SHIFT) {
      textShift = -MAX_TEXT_SHIFT;
    } else if (textShift > MAX_TEXT_SHIFT) {
      textShift = MAX_TEXT_SHIFT;
    }
    textLabel.setTranslateX(textShift);

  }

  public static void main(String[] args) {
    launch(args);
  }
}