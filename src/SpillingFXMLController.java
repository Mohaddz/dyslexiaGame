import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

public class SpillingFXMLController implements Initializable {

    static int countPoints = 0;
    static int countMisses = 0;
    double currentRate = 1;
    rhymeWords chosenWord;
    private Media correctAudio = new Media(new File("src\\audio\\correct.mp3").toURI().toString());
    private Media wrongAudio = new Media(new File("src\\audio\\wrong.mp3").toURI().toString());

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
    @FXML
    private AnchorPane gamePane;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Level.add(new rhymeWords("first", new Image("C:\\Users\\moham\\Documents\\NetBeansProjectsb\\dyslexiaGame\\src\\img\\First.png", 330, 353, true, true), new Media(new File("src\\audio\\first.mp3").toURI().toString())));
        Level.add(new rhymeWords("space", new Image("C:\\Users\\moham\\Documents\\NetBeansProjectsb\\dyslexiaGame\\src\\img\\space.jpg", 330, 353, true, true), new Media(new File("src\\audio\\space.mp3").toURI().toString())));
        Level.add(new rhymeWords("people", new Image("C:\\Users\\moham\\Documents\\NetBeansProjectsb\\dyslexiaGame\\src\\img\\people.png", 330, 353, true, true), new Media(new File("src\\audio\\people.mp3").toURI().toString())));
        Level.add(new rhymeWords("date", new Image("C:\\Users\\moham\\Documents\\NetBeansProjectsb\\dyslexiaGame\\src\\img\\date.png", 330, 353, true, true), new Media(new File("src\\audio\\date.mp3").toURI().toString())));
        Level.add(new rhymeWords("fact", new Image("C:\\Users\\moham\\Documents\\NetBeansProjectsb\\dyslexiaGame\\src\\img\\fact.png", 330, 353, true, true), new Media(new File("src\\audio\\fact.mp3").toURI().toString())));
        mainMenuController.bgMusicMP3.play();
        mainMenuController.bgMusicMP3.setCycleCount(MediaPlayer.INDEFINITE);
        hardButton.setStyle("-fx-background-color: orange;");
        hardButton.setStyle("-fx-border-color: black;");
        
        lvl = 0;
        try {
            game();
        } catch (IOException ex) {
            Logger.getLogger(SpillingFXMLController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(SpillingFXMLController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }

    public void game() throws IOException, InterruptedException {
            if (lvl == Level.size()) {
            TimeUnit.SECONDS.sleep(1);
            AnchorPane endScreen = FXMLLoader.load(getClass().getResource("endSreenFXML.fxml"));
            gamePane.getChildren().setAll(endScreen);
            }
                
        chosenWordMP3 = new MediaPlayer(Level.get(lvl).getAudio());
        chosenWordMP3.setRate(currentRate);
        
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
    private void checkBtn(ActionEvent event) throws IOException, InterruptedException {
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
    private void exitClicked(ActionEvent event) throws IOException {
         AnchorPane mainMenu = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
         mainMenuController.bgMusicMP3.stop();
         gamePane.getChildren().setAll(mainMenu);
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
