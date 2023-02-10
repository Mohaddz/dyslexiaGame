import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

public class EndSreenFXMLController implements Initializable {

    MediaPlayer bgMusicMP3;
    
    @FXML
    private Text points;
    @FXML
    private Text misses;
    @FXML
    private Button exitGame;
    @FXML
    private AnchorPane endScreenPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mainMenuController.bgMusicMP3.play();
        mainMenuController.bgMusicMP3.setCycleCount(MediaPlayer.INDEFINITE);
        if (mainMenuController.gameChoice == 0) {
            points.setText(Integer.toString(SpillingFXMLController.countPoints));
            misses.setText(Integer.toString(SpillingFXMLController.countMisses));
        } else {

            points.setText(Integer.toString(DyslexiaFXMLController.countPoints));
            misses.setText(Integer.toString(DyslexiaFXMLController.countMisses));
        }
    }

    @FXML
    private void exitClicked(ActionEvent event) throws IOException {
        AnchorPane mainMenu = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        mainMenuController.bgMusicMP3.stop();
        endScreenPane.getChildren().setAll(mainMenu);
        
    }

}
