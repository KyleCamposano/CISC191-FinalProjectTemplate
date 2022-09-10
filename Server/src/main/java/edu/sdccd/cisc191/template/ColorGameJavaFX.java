package edu.sdccd.cisc191.template;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.util.Random;

public class ColorGameJavaFX extends Application {

    Stage windowFirst;
    Scene scene2, scene3;
    Button button1, button2, button3, button4;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //First window
        windowFirst = primaryStage;
        windowFirst.setTitle("Welcome to the game");


        //Buttons
        button1 = new Button("Press [ENTER] to begin");
        button1.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                button1.fire();
                windowFirst.setScene(scene2);
            }
        });
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();


        //First scene
        StackPane layout1 = new StackPane();
            Text text1 = new Text("Thank you checking out this mini-game. \n" +
                    "I hope you enjoy as much as I did making it!\n\n" +
                    "Good luck and have fun!");
        text1.setTextAlignment(TextAlignment.CENTER);
        button1.setAlignment(Pos.BOTTOM_LEFT);
        VBox hb1 = new VBox();
        Label label1 = new Label("");
        hb1.getChildren().addAll(button1);
        hb1.setAlignment(Pos.BOTTOM_CENTER);
        hb1.setSpacing(10);
        layout1.getChildren().addAll(hb1, text1);
        Scene scene1 = new Scene(layout1, 480, 150);


        //Guess text field
        Label label3 = new Label("");
        label3.setAlignment(Pos.BOTTOM_RIGHT);
        Label label2 = new Label("Guess:");
        TextField textField = new TextField();
        textField.setAlignment(Pos.BOTTOM_LEFT);
        HBox hb2 = new HBox();
        hb2.getChildren().addAll(label2, textField, label3);
        hb2.setAlignment(Pos.BOTTOM_LEFT);
        hb2.setSpacing(10);
        Text text2 = new Text();


        //Last Guess text fields.
        Label label4 = new Label("What's my first half?");
        Label label5 = new Label("What's my second?");
        Label label6 = new Label();
        TextField textField2 = new TextField();
        textField2.setAlignment(Pos.BOTTOM_LEFT);
        TextField textField3 = new TextField();
        textField3.setAlignment(Pos.BOTTOM_LEFT);
        VBox vb3 = new VBox();
        vb3.getChildren().addAll(label4, textField2, label5, textField3, label6);
        vb3.setAlignment(Pos.BOTTOM_LEFT);
        StackPane layout3 = new StackPane();
        layout3.getChildren().add(vb3);
        scene3 = new Scene(layout3, 250, 300);


        //Second scene
        StackPane layout2 = new StackPane();
        text2.setText("I’m a color in the sky\n" +
                "I'm part of a curve mentioned in the first book of the Bible but I’m not a snake\n" +
                "I sit next to many other colors\n" +
                "We are all mentioned in a Wizard Of Oz song but I’m not a Yellow Brick Road\n" +
                "I can be found near a leprechaun but I’m not a pot of gold\n\n" +
                "What color am I?\n\n");
        text2.setTextAlignment(TextAlignment.JUSTIFY);
        layout2.getChildren().addAll(hb2, text2);
        scene2 = new Scene(layout2, 450, 200);


        //Color game, first part of series.
        String[] colors = {"Red", "Orange", "Yellow", "Green", "Indigo", "Blue", "Violet"};
        Random random = new Random();
        int randomColorIndex = random.nextInt(colors.length);
        String correctColor = colors[randomColorIndex].toLowerCase();


        //Digits game, second part of series.
        int[][] numbers = new int[2][2];
        random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = random.nextInt(9);
            }
        }


        //sets each possible answer into variable for reference.
        int firstAnswer = numbers[0][0];
        int secondAnswer = numbers[0][1];
        int thirdAnswer = numbers[1][0];
        int fourthAnswer = numbers[1][1];
        String firstActualAnswer = String.valueOf(firstAnswer);
        String secondActualAnswer = String.valueOf(secondAnswer);
        String thirdActualAnswer = String.valueOf(thirdAnswer);
        String fourthActualAnswer = String.valueOf(fourthAnswer);


        //textField to compare value of user input to the randomColor.
        textField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                String userGuess = textField.getText().toLowerCase();
                if (!(userGuess.equals(correctColor))) {
                    label3.setText("Sorry, wrong color!");

                    /*
                        Correct answer prompts to the new scene with the new prompt
                        of the second game. The user inputs for the following series
                        are compared to the array of color and 2-dimensional array
                        of numbers above. Upon completion of the color game, the user
                        can choose to terminate the program. Upon completion of both
                        games, the program automatically terminates.
                     */

                } else {
                    label3.setText("Your guess is correct! \nPress [ENTER] to exit this game.");
                    textField.setOnKeyPressed(event2 -> {
                        if (event2.getCode().equals(KeyCode.ENTER)) windowFirst.setScene(scene1);
                        text1.setText("Would you like to play another game?");
                        button1.setText("Yes");
                        button1.setAlignment(Pos.BOTTOM_CENTER);
                        hb1.getChildren().add(button2);
                        button2.setText("No");
                        button2.setAlignment(Pos.BOTTOM_CENTER);

                        //No option then terminate program.
                        button2.setOnAction(event3 -> {
                            hb1.getChildren().remove(button2);
                            text1.setText("You selected " + button2.getText().toLowerCase() +
                                    ".\n Thank you for playing,"
                                    + " and I hope you enjoyed it!");
                            button1.setText("Press [ENTER] to terminate.");
                            button1.setOnKeyPressed(event4 -> {
                                if (event4.getCode().equals(KeyCode.ENTER)) windowFirst.close();
                            });
                        });

                        //Yes option.
                        button1.setOnAction(event5 -> {
                            hb1.getChildren().remove(button2);
                            text1.setText("Welcome to the Combination-of-Two-Single-Digits Game!\n" +
                                    "This is the second game of the series.\n\nEnjoy!");
                            button1.setText("Press [ENTER] to begin.");
                            button1.setOnKeyPressed(event6 -> {
                                if (event6.getCode().equals(KeyCode.ENTER)) windowFirst.setScene(scene3);
                                text1.setText("I'm a combination of two single digits.\n" +
                                        "I may only be between none to nine.\n" +
                                        "Yet I promise I can break your spirit.\n" +
                                        "If you neglect to read between the line.\n\n" +
                                        "");
                                vb3.getChildren().addAll(button3);
                                layout3.getChildren().addAll(text1);
                                button3.setText("Submit");

                                /*
                                    Uncomment to test if user input matching correct answers.
                                    System.out.println(Arrays.deepToString(numbers));
                                    System.out.println(firstAnswer);
                                    System.out.println(secondAnswer);
                                */

                                //User inputs from text fields are compared to the random answers from numbers array.
                                //Correct answer prompts user to the new scene to terminate the program.
                                button3.setOnAction(event7 -> {
                                    if (!((textField2.getText().equals(firstActualAnswer) && textField3.getText().equals(secondActualAnswer))
                                    || (textField2.getText().equals(thirdActualAnswer) && textField3.getText().equals(fourthActualAnswer)))) {
                                        label6.setText("Wrong answer!");
                                    } else {
                                        vb3.getChildren().remove(button3);
                                        vb3.getChildren().add(button4);
                                        label6.setText("Correct!");
                                        button4.setText("Press [ENTER] to continue.");
                                        button4.setOnKeyPressed(event8 -> {
                                           if (event8.getCode().equals(KeyCode.ENTER)) {
                                               vb3.getChildren().removeAll(label4, textField2, label5, textField3, button4, label3);
                                               vb3.getChildren().addAll(button4);
                                               button4.setText("Press [ENTER] to terminate.");
                                               text1.setText("You completed all stages!\n" +
                                                       "Thank you for playing the game!\n\n" +
                                                       "I hope you enjoyed it!");
                                               button4.setOnKeyPressed(event9 -> {
                                                   if (event9.getCode().equals(KeyCode.ENTER)) windowFirst.close();
                                               });
                                           }
                                        });
                                    }
                                });
                            });
                        });
                    });
                }
            }
        });

        //Starting scene in the primary window.
        windowFirst.setScene(scene1);
        windowFirst.show();
    }
}


