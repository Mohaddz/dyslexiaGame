/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class mainMenuController implements Initializable {

    public static int gameChoice;
    public static MediaPlayer bgMusicMP3;
    public static Media bgMusic = new Media(new File("src\\audio\\backgroundMusic.mp3").toURI().toString());
    
    @FXML
    private Button spellingGame;
    @FXML
    private Button reports;
    @FXML
    private Button exit;
    @FXML
    private Button wordGame;
    @FXML
    private AnchorPane mainMenuPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bgMusicMP3 = new MediaPlayer(bgMusic);
        bgMusicMP3.setVolume(0.2);
        bgMusicMP3.setRate(0.9);
        bgMusicMP3.play();
        bgMusicMP3.setCycleCount(MediaPlayer.INDEFINITE);
    }

    @FXML
    private void spellingGameClicked(ActionEvent event) throws IOException {
        AnchorPane spellingGame = FXMLLoader.load(getClass().getResource("SpillingFXML.fxml"));
        gameChoice=0;
        mainMenuPane.getChildren().setAll(spellingGame);

    }

    @FXML
    private void reportsClicked(ActionEvent event) throws IOException {
        AnchorPane reports = FXMLLoader.load(getClass().getResource("reports.fxml"));
        mainMenuPane.getChildren().setAll(reports);
    }

    @FXML
    private void exitClicked(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void wordGameClicked(ActionEvent event) throws IOException {
        AnchorPane wordGame = FXMLLoader.load(getClass().getResource("dyslexiaFXML.fxml"));
        gameChoice=1;
        mainMenuPane.getChildren().setAll(wordGame);
    }

}
