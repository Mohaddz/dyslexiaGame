/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Mohad
 */
public class SpillingFXMLController implements Initializable {

    int countPoints = 0;
    int countMisses = 0;
    private int level = 0;
    int randomWord = 0;
    int randomImage = 0;
    double currentRate = 1;
    rhymeWords chosenWord;
    private Media correctAudio = new Media(new File("src\\audio\\correct.mp3").toURI().toString());
    private Media wrongAudio = new Media(new File("src\\audio\\wrong.mp3").toURI().toString());
    private Media bgMusic = new Media(new File("src\\audio\\backgroundMusic.mp3").toURI().toString());

//    private Image lakeImage = new Image("C:\\Users\\Mohad\\Documents\\NetBeansProjects\\dyslexiaGame\\src\\img\\Lake.png", 330, 353, true, true);
//    private Media FirstAudio = new Media(new File("src\\audio\\Lake.mp3").toURI().toString());
//    private rhymeWords lake = new rhymeWords("Lake", lakeImage, lakeAudio);
//
//    private Image cakeImage = new Image("src\\img\\cake.png", 330, 353, true, true);
//    private Media cakeAudio = new Media(new File("src\\audio\\Cake.mp3").toURI().toString());
//    private rhymeWords cake = new rhymeWords("Cake", cakeImage, cakeAudio);
//
//    private Image bookImage = new Image("src\\img\\book.png", 330, 353, true, true);
//    private Media bookAudio = new Media(new File("src\\audio\\book.mp3").toURI().toString());
//    private rhymeWords book = new rhymeWords("Book", bookImage, bookAudio);
//
//    private Image cookImage = new Image("src\\img\\cook.png", 330, 353, true, true);
//    private Media cookAudio = new Media(new File("src\\audio\\cook.mp3").toURI().toString());
//    private rhymeWords cook = new rhymeWords("Cook", cookImage, cookAudio);
//    
//    private Image barkImage = new Image("src\\img\\bark.png", 330, 353, true, true);
//    private Media barkAudio = new Media(new File("src\\audio\\bark.mp3").toURI().toString());
//    private rhymeWords bark = new rhymeWords("Bark", barkImage, barkAudio);
//
//    private Image parkImage = new Image("src\\img\\park.png", 330, 353, true, true);
//    private Media parkAudio = new Media(new File("src\\audio\\park.mp3").toURI().toString());
//    private rhymeWords park = new rhymeWords("Park", parkImage, parkAudio);
//    
//    private Image lampImage = new Image("src\\img\\lamp.png", 330, 353, true, true);
//    private Media lampAudio = new Media(new File("src\\audio\\lamp.mp3").toURI().toString());
//    private rhymeWords lamp = new rhymeWords("lamp", lampImage, lampAudio);
//    
//    private Image campImage = new Image("src\\img\\camp.png", 330, 353, true, true);
//    private Media campAudio = new Media(new File("src\\audio\\camp.mp3").toURI().toString());
//    private rhymeWords camp = new rhymeWords("camp", campImage, campAudio);
//    
//    private Image batImage = new Image("src\\img\\bat.png", 330, 353, true, true);
//    private Media batAudio = new Media(new File("src\\audio\\bat.mp3").toURI().toString());
//    private rhymeWords bat = new rhymeWords("Bat", batImage, batAudio);
//    
//    private Image catImage = new Image("src\\img\\cat.png", 330, 353, true, true);
//    private Media catAudio = new Media(new File("src\\audio\\cat.mp3").toURI().toString());
//    private rhymeWords cat = new rhymeWords("Cat", catImage, catAudio);
    MediaPlayer chosenWordMP3;
    MediaPlayer wrongMP3;
    int lvl = 0;
    char[] pool = new char[8];
    StringBuilder answer = new StringBuilder();
    ArrayList<rhymeWords> Level = new ArrayList<rhymeWords>();
    @FXML
    private ImageView Image;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Label Ltr1;
    MediaPlayer correctMP3;
    @FXML
    private Text points;
    @FXML
    private Text misses;
    @FXML
    private Button exitGame;
    @FXML
    private Button sound;
    @FXML
    private Button easyButton;
    @FXML
    private Button mediumButton;
    @FXML
    private Button hardButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Level.add(new rhymeWords("first", new Image("C:\\Users\\Mohad\\Documents\\NetBeansProjects\\dyslexiaGame\\src\\img\\first.png", 330, 353, true, true), new Media(new File("src\\audio\\first.mp3").toURI().toString())));
        Level.add(new rhymeWords("space", new Image("C:\\Users\\Mohad\\Documents\\NetBeansProjects\\dyslexiaGame\\src\\img\\space.jpg", 330, 353, true, true), new Media(new File("src\\audio\\space.mp3").toURI().toString())));
        Level.add(new rhymeWords("people", new Image("C:\\Users\\Mohad\\Documents\\NetBeansProjects\\dyslexiaGame\\src\\img\\people.png", 330, 353, true, true), new Media(new File("src\\audio\\people.mp3").toURI().toString())));
        Level.add(new rhymeWords("date", new Image("C:\\Users\\Mohad\\Documents\\NetBeansProjects\\dyslexiaGame\\src\\img\\date.png", 330, 353, true, true), new Media(new File("src\\audio\\date.mp3").toURI().toString())));
        Level.add(new rhymeWords("fact", new Image("C:\\Users\\Mohad\\Documents\\NetBeansProjects\\dyslexiaGame\\src\\img\\fact.png", 330, 353, true, true), new Media(new File("src\\audio\\fact.mp3").toURI().toString())));
        
        lvl = 0;
        chosenWordMP3 = new MediaPlayer(Level.get(lvl).getAudio());
        chosenWordMP3.setRate(currentRate);
        game();

    }

    public void game() {
        
        Image.setImage(Level.get(lvl).getImage());
        wrongMP3 = new MediaPlayer(wrongAudio);
        correctMP3 = new MediaPlayer(correctAudio);
        Level.get(lvl).getWord().getChars(0, Level.get(lvl).getWord().length(), pool, 0);

        Random r = new Random();
        for (int i = Level.get(lvl).getWord().length(); i < 8; i++) {
            char randC = (char) (r.nextInt(26) + 'a');
            if (!isContains(pool, randC)) {
                pool[i] = randC;
            } else {
                i--;
            }
        }

        for (int i = 0; i < pool.length; i++) {
            int randomIndexToSwap = r.nextInt(pool.length);
            char temp = pool[randomIndexToSwap];
            pool[randomIndexToSwap] = pool[i];
            pool[i] = temp;
        }

        btn1.setText(Character.toString(pool[0]));
        btn2.setText(Character.toString(pool[1]));
        btn3.setText(Character.toString(pool[2]));
        btn4.setText(Character.toString(pool[3]));
        btn5.setText(Character.toString(pool[4]));
        btn6.setText(Character.toString(pool[5]));
        btn7.setText(Character.toString(pool[6]));
        btn8.setText(Character.toString(pool[7]));
        
    }

    public boolean isContains(char[] ch, char c) {
        for (char i : ch) {
            if (i == c) {
                System.out.println(i + " " + c);
                return true;
            }
        }
        return false;
    }

    @FXML
    private void btn1ltr(ActionEvent event) {
        answer.append(btn1.getText());
        Ltr1.setText(answer.toString());

    }

    @FXML
    private void btn2ltr(ActionEvent event) {
        answer.append(btn2.getText());
        Ltr1.setText(answer.toString());
    }

    @FXML
    private void btn3ltr(ActionEvent event) {
        answer.append(btn3.getText());
        Ltr1.setText(answer.toString());
    }

    @FXML
    private void btn4ltr(ActionEvent event) {
        answer.append(btn4.getText());
        Ltr1.setText(answer.toString());
    }

    @FXML
    private void btn5ltr(ActionEvent event) {
        answer.append(btn5.getText());
        Ltr1.setText(answer.toString());
    }

    @FXML
    private void btn6ltr(ActionEvent event) {
        answer.append(btn6.getText());
        Ltr1.setText(answer.toString());
    }

    @FXML
    private void btn7ltr(ActionEvent event) {
        answer.append(btn7.getText());
        Ltr1.setText(answer.toString());
    }

    @FXML
    private void btn8ltr(ActionEvent event) {
        answer.append(btn8.getText());
        Ltr1.setText(answer.toString());
    }

    @FXML
    private void checkBtn(ActionEvent event) {
        if (answer.toString().equalsIgnoreCase(Level.get(lvl).getWord())) {
            points.setText(Integer.toString(++countPoints));
            lvl++;
            Ltr1.setText(answer.delete(0, answer.length()).toString());
            correctMP3.seek(correctMP3.getStartTime());
            correctMP3.play();
            game();
        } else {
            misses.setText(Integer.toString(++countMisses));
            wrongMP3.seek(wrongMP3.getStartTime());
            wrongMP3.play();
        }
    }

    @FXML
    private void del(ActionEvent event) {
        answer.delete(answer.length() - 1, answer.length());
        Ltr1.setText(answer.toString());
    }

    @FXML
    private void clear(ActionEvent event) {
        answer.delete(0, answer.length());
        Ltr1.setText(answer.toString());
    }

    @FXML
    private void exitClicked(ActionEvent event) {
    }

    @FXML
    private void soundClicked(ActionEvent event) {
        chosenWordMP3.seek(chosenWordMP3.getStartTime());
        chosenWordMP3.play();
    }

    @FXML
    private void easyClicked(ActionEvent event) {
        currentRate = 0.75;
        chosenWordMP3.setRate(currentRate);
        easyButton.setStyle("-fx-background-color: orange;");
        easyButton.setStyle("-fx-border-color: black;");
        mediumButton.setStyle("-fx-background-color: gold;");
        hardButton.setStyle("-fx-background-color: gold;");
    }

    @FXML
    private void mediumClicked(ActionEvent event) {
        currentRate = 0.8;
        chosenWordMP3.setRate(currentRate);
        easyButton.setStyle("-fx-background-color: gold;");
        mediumButton.setStyle("-fx-background-color: orange;");
        mediumButton.setStyle("-fx-border-color: black;");
        hardButton.setStyle("-fx-background-color: gold;");
    }

    @FXML
    private void hardClicked(ActionEvent event) {
        currentRate = 1;
        chosenWordMP3.setRate(currentRate);
        easyButton.setStyle("-fx-background-color: gold;");
        mediumButton.setStyle("-fx-background-color: gold;");
        hardButton.setStyle("-fx-background-color: orange;");
        hardButton.setStyle("-fx-border-color: black;");
    }

}
