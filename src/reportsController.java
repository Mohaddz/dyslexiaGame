import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

public class reportsController implements Initializable{

    @FXML
    private Text dateSG;

    @FXML
    private Text dateWG;

    @FXML
    private Text missesSG;

    @FXML
    private Text missesWG;

    @FXML
    private Text pointSG;

    @FXML
    private Text pointsWG;

    @FXML
    private Text usernameMessage;
    
    @FXML
    private AnchorPane reportPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    @FXML
    private void exitClicked(ActionEvent event) throws IOException {
         AnchorPane mainMenu = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
         mainMenuController.bgMusicMP3.stop();
         reportPane.getChildren().setAll(mainMenu);
    }
}
