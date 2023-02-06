
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class DyslexiaFXMLController implements Initializable {

    public static int countPoints = 0;
    public static int countMisses = 0;
    private int level = 0;
    int randomWord = 0;
    int randomImage = 0;
    double currentRate = 1;
    rhymeWords chosenWord;
    private Media correctAudio = new Media(new File("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/audio/correct.mp3").toURI().toString());
    private Media wrongAudio = new Media(new File("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/audio/wrong.mp3").toURI().toString());
    private Media bgMusic = new Media(new File("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/audio/backgroundMusic.mp3").toURI().toString());

    private Image lakeImage = new Image("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/img/Lake.png", 330, 353, true, true);
    private Media lakeAudio = new Media(new File("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/audio/Lake.mp3").toURI().toString());
    private rhymeWords lake = new rhymeWords("Lake", lakeImage, lakeAudio);

    private Image cakeImage = new Image("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/img/cake.png", 330, 353, true, true);
    private Media cakeAudio = new Media(new File("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/audio/Cake.mp3").toURI().toString());
    private rhymeWords cake = new rhymeWords("Cake", cakeImage, cakeAudio);

    private Image bookImage = new Image("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/img/book.png", 330, 353, true, true);
    private Media bookAudio = new Media(new File("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/audio/book.mp3").toURI().toString());
    private rhymeWords book = new rhymeWords("Book", bookImage, bookAudio);

    private Image cookImage = new Image("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/img/cook.png", 330, 353, true, true);
    private Media cookAudio = new Media(new File("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/audio/cook.mp3").toURI().toString());
    private rhymeWords cook = new rhymeWords("Cook", cookImage, cookAudio);
    
    private Image barkImage = new Image("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/img/bark.png", 330, 353, true, true);
    private Media barkAudio = new Media(new File("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/audio/bark.mp3").toURI().toString());
    private rhymeWords bark = new rhymeWords("Bark", barkImage, barkAudio);

    private Image parkImage = new Image("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/img/park.png", 330, 353, true, true);
    private Media parkAudio = new Media(new File("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/audio/park.mp3").toURI().toString());
    private rhymeWords park = new rhymeWords("Park", parkImage, parkAudio);
    
    private Image lampImage = new Image("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/img/lamp.png", 330, 353, true, true);
    private Media lampAudio = new Media(new File("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/audio/lamp.mp3").toURI().toString());
    private rhymeWords lamp = new rhymeWords("lamp", lampImage, lampAudio);
    
    private Image campImage = new Image("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/img/camp.png", 330, 353, true, true);
    private Media campAudio = new Media(new File("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/audio/camp.mp3").toURI().toString());
    private rhymeWords camp = new rhymeWords("camp", campImage, campAudio);
    
    private Image batImage = new Image("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/img/bat.png", 330, 353, true, true);
    private Media batAudio = new Media(new File("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/audio/bat.mp3").toURI().toString());
    private rhymeWords bat = new rhymeWords("Bat", batImage, batAudio);
    
    private Image catImage = new Image("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/img/cat.png", 330, 353, true, true);
    private Media catAudio = new Media(new File("C:/Users/moham/Documents/NetBeansProjectsb/dyslexiaGame/src/audio/cat.mp3").toURI().toString());
    private rhymeWords cat = new rhymeWords("Cat", catImage, catAudio);
    
    
    
    
    
    private rhymeWords[][] pairs = {{lake, cake},
                                    {book, cook},
                                    {bark, park},
                                    {lamp, camp},
                                    {cat, bat}};

    MediaPlayer chosenWordMP3;
    MediaPlayer correctMP3;
    MediaPlayer wrongMP3;
    MediaPlayer bgMusicMP3;
    @FXML
    private ImageView image1;
    @FXML
    private Button sound;
    @FXML
    private Text points;
    @FXML
    private Text misses;
    @FXML
    private Button exitGame;
    @FXML
    private Button buttonimg1;
    @FXML
    private Button buttonimg2;
    @FXML
    private Text imgOneName;
    @FXML
    private Text imgTwoName;
    @FXML
    private ImageView image2;
    @FXML
    private Text result;
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
        randomWord = new Random().nextInt(2);
        randomImage = new Random().nextInt(2);
        chosenWord = pairs[level][randomWord];
        points.setText(Integer.toString(countPoints));
        misses.setText(Integer.toString(countMisses));
        result.setText("");
        System.out.println(randomImage);
        if (randomImage == 0) {
            image1.setImage(pairs[level][randomImage].getImage());
            imgOneName.setText(pairs[level][randomImage].getWord());
            image2.setImage(pairs[level][1].getImage());
            imgTwoName.setText(pairs[level][1].getWord());
        } else if (randomImage == 1) {
            image1.setImage(pairs[level][randomImage].getImage());
            imgOneName.setText(pairs[level][randomImage].getWord());
            image2.setImage(pairs[level][0].getImage());
            imgTwoName.setText(pairs[level][0].getWord());
        }
        chosenWordMP3 = new MediaPlayer(chosenWord.getAudio());
        correctMP3 = new MediaPlayer(correctAudio);
        wrongMP3 = new MediaPlayer(wrongAudio);
        bgMusicMP3 = new MediaPlayer(bgMusic);
        bgMusicMP3.setVolume(0.2);
        bgMusicMP3.setRate(0.9);
        bgMusicMP3.play();
        bgMusicMP3.setCycleCount(MediaPlayer.INDEFINITE);
        hardButton.setStyle("-fx-background-color: orange;");
        hardButton.setStyle("-fx-border-color: black;");
    }

    @FXML
    private void soundClicked(ActionEvent event) {
        chosenWordMP3.seek(chosenWordMP3.getStartTime());
        chosenWordMP3.play();

    }

    @FXML
    private void exitClicked(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void buttonimg1Clicked(ActionEvent event) throws InterruptedException, IOException {
        if (imgOneName.getText().equalsIgnoreCase(chosenWord.getWord())) {
            points.setText(Integer.toString(++countPoints));
            correctMP3.seek(correctMP3.getStartTime());
            correctMP3.play();
            reInitialize();

        } else {
            misses.setText(Integer.toString(++countMisses));
            result.setText("Try Again!!!");
            wrongMP3.seek(wrongMP3.getStartTime());
            wrongMP3.play();
        }
        TimeUnit.SECONDS.sleep(1);

    }

    @FXML
    private void buttonimg2Clicked(ActionEvent event) throws InterruptedException, IOException {
        if (imgTwoName.getText().equalsIgnoreCase(chosenWord.getWord())) {
            points.setText(Integer.toString(++countPoints));
            correctMP3.seek(correctMP3.getStartTime());
            correctMP3.play();
            reInitialize();
        } else {
            misses.setText(Integer.toString(++countMisses));
            result.setText("Try Again!!!");
            wrongMP3.seek(wrongMP3.getStartTime());
            wrongMP3.play();
        }
    }

    private void reInitialize() throws InterruptedException, IOException {
        level++;
        if (level == pairs.length) {
            TimeUnit.SECONDS.sleep(1);
            AnchorPane endScreen = FXMLLoader.load(getClass().getResource("endSreenFXML.fxml"));
            gamePane.getChildren().setAll(endScreen);
            }
        randomWord = new Random().nextInt(2);
        randomImage = new Random().nextInt(2);
        chosenWord = pairs[level][randomWord];
        System.out.println(randomImage);
        if (randomImage == 0) {
            image1.setImage(pairs[level][randomImage].getImage());
            imgOneName.setText(pairs[level][randomImage].getWord());
            image2.setImage(pairs[level][1].getImage());
            imgTwoName.setText(pairs[level][1].getWord());
        } else {
            image1.setImage(pairs[level][randomImage].getImage());
            imgOneName.setText(pairs[level][randomImage].getWord());
            image2.setImage(pairs[level][0].getImage());
            imgTwoName.setText(pairs[level][0].getWord());
        }
        chosenWordMP3 = new MediaPlayer(chosenWord.getAudio());
        chosenWordMP3.setRate(currentRate);
        result.setText("");
    }

    @FXML
    private void easyClicked(ActionEvent event) {
        currentRate = 0.67;
        chosenWordMP3.setRate(currentRate);
        easyButton.setStyle("-fx-background-color: orange;");
        easyButton.setStyle("-fx-border-color: black;");
        mediumButton.setStyle("-fx-background-color: gold;");
        hardButton.setStyle("-fx-background-color: gold;");
    }

    @FXML
    private void mediumClicked(ActionEvent event) {
        currentRate = 0.75;
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
