package calculator;

import calculator.calculations.Calculations;
import calculator.calculatorOptions.CalculatorOptions;
import calculator.calculatorOptions.DisplayMode;
import calculator.calculatorOptions.UnitsMode;
import calculator.parser.Parser;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.HashMap;
import java.util.Map;

    // a simple JavaFX calculator.
    public class CalcSkin extends Application {
        private String memory = "Memory Currently Empty";
        private String history = "";
        private String currentInput = "";
        private Parser calcParser = new Parser();

        public static void main(String[] args){
            launch(args);
        }
        private static final String[][] template = {
                { "1", "2", "3"},
                { "4", "5", "6"},
                { "7", "8", "9"},
                { "0", ")", "(" },
                { "+", "-", "/", "*", "^"},
                { "sqrt", "factorial", "log" },
                { "sin", "cosine", "tan"},
                { "inverseSin", "inverseCos"},
                { "inverseTan", "logarithm"},
                { "inverseLog", "naturalLog"},
                { "inverseNatural Log"},
                { "M+", "Mc", "Mrecall"},
                { "XOR", "clear", "="},
                { "SwitchDisplayMode", "Radians/Degrees"}

        };

        private final Map<String, Button> accelerators = new HashMap<>();

        private StringProperty currentValue = new SimpleStringProperty();

        public static void launchCalc(String... args) {
            launch(args);
        }

        @Override
        public void start(Stage stage) {
            final TextField screen  = createScreen();
            final TilePane buttons = createButtons();

            stage.setTitle("This Calculator is Going to Work");
            stage.initStyle(StageStyle.UTILITY);
            stage.setResizable(false);
            stage.setScene(new Scene(createLayout(screen, buttons)));
            stage.show();
        }

        private VBox createLayout(TextField screen, TilePane buttons) {
            final VBox layout = new VBox(20);
            layout.setAlignment(Pos.CENTER);
            layout.setStyle("-fx-background-color: silver; -fx-padding: 20; -fx-font-size: 20;");
            layout.getChildren().setAll(screen, buttons);
            handleAccelerators(layout);
            screen.prefWidthProperty().bind(buttons.widthProperty());
            screen.setStyle("-fx-display-caret: false;");
            return layout;
        }

        private void handleAccelerators(VBox layout) {
            layout.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    String currentPress = keyEvent.getText();
                    if (accelerators.containsKey(currentPress)) {
                        Button activated = accelerators.get(keyEvent.getText());
                        activated.fire();
                    } else if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                        history = currentInput;
                        accelerators.get("enter").fire();
                    } else if (keyEvent.getCode().equals(KeyCode.BACK_SPACE)) {
                        if (currentInput.length() > 0) {
                            currentInput = currentInput.substring(0, currentInput.length() - 1);
                            currentValue.set(currentInput);
                        }
                    } else if (keyEvent.getCode().equals(KeyCode.DOWN)) {
                        currentInput = history;
                        currentValue.set(currentInput);
                    } else {
                        currentInput += keyEvent.getText();
                        currentValue.set(currentInput);
                    }
                }
            });
        }

        private TextField createScreen() {
            final TextField screen = new TextField();
            screen.setStyle("-fx-background-color: aquamarine;");
            screen.setAlignment(Pos.CENTER_RIGHT);
            screen.setEditable(true);
            screen.textProperty().bind(Bindings.format("%s", currentValue));
            currentValue.setValue("0");
            return screen;
        }


        private TilePane createButtons() {
            TilePane buttons = new TilePane();
            buttons.setVgap(7);
            buttons.setHgap(7);
            buttons.setPrefColumns(template[0].length);
            for (String[] r: template) {
                for (String s: r) {
                    buttons.getChildren().add(createButton(s));
                }
            }
            return buttons;
        }

        private Button createButton(final String s) {
            Button button = makeStandardButton(s);

            if ("clear".equals(s)) {
                makeClearButton(button);
            } else if ("=".equals(s)) {
                makeEqualsButton(button);
            } else if ("M+".equals(s)) {
                makeMemoryAddButton(button);
            } else if ("Mc".equals(s)) {
                makeMemoryClearButton(button);
            } else if ("Mrecall".equals(s)) {
                makeMemoryRecallButton(button);
            } else if ("SwitchDisplayMode".equals(s)) {
                makeSwitchDisplayModeButton(button);
            } else if ("Radians/Degrees".equals(s)) {
                makeSwitchUnitsModeButton(button);
            } else {
                makeDefaultButton(button, s);
            }


            return button;
        }

        private void makeDefaultButton(Button button, final String label) {
            button.setStyle("-fx-base: lightblue;");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    currentInput += label;
                    currentValue.set(currentInput);
                }
            });
        }


        private Button makeStandardButton(String s) {
            Button button = new Button(s);
            button.setStyle("-fx-base: beige;");
            accelerators.put(s, button);
            button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            return button;
        }


        private void makeMemoryAddButton(Button button) {
            button.setStyle("-fx-base: lavender;");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    memory = currentInput;
                }
            });
        }

        private void makeMemoryClearButton(Button button) {
            button.setStyle("-fx-base: lavender;");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    memory = "";
                }
            });
        }

        private void makeMemoryRecallButton(Button button) {
            button.setStyle("-fx-base: lavender;");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    currentInput += memory;
                    currentValue.set(currentInput);
                }
            });
        }

        private void makeClearButton(Button button) {
            button.setStyle("-fx-base: mistyrose;");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    currentValue.set("0");
                    currentInput = "";
                }
            });
        }

        private void makeSwitchDisplayModeButton(Button button) {
            button.setStyle("-fx-base: GOLD;");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    CalculatorOptions mode = CalculatorOptions.getInstance();
                    mode.rotateMode();
                    currentInput = "";
                    currentValue.set("Display mode is now: " + mode.getDisplayMode());
                }
            });
        }

        private void makeSwitchUnitsModeButton(Button button) {
            button.setStyle("-fx-base: GOLD;");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    CalculatorOptions mode = CalculatorOptions.getInstance();
                    mode.rotateUnits();
                    currentInput = "";
                    currentValue.set("Units mode is now: " + mode.getUnitsMode());
                }
            });
        }

        private void makeEqualsButton(Button button) {
            button.setStyle("-fx-base: ghostwhite;");
            accelerators.put("enter", button);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    history = currentInput;
                    Calculations calculations = calcParser.parse(currentInput);
                    Float numAnswer = calculations.evaluate();
                    DisplayMode displayMode = CalculatorOptions.getInstance().getDisplayMode();
                    UnitsMode unitsMode = CalculatorOptions.getInstance().getUnitsMode();
                    String answer = displayMode.convertToMode(unitsMode.convertToMode(numAnswer));
                    currentInput = answer;
                    currentValue.set(answer);

                }
            });
        }


    }
