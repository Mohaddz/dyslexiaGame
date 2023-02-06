
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class EndSreenFXMLController implements Initializable {
    
    @FXML
    private Text points;
    @FXML
    private Text misses;
    @FXML
    private Button exitGame;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        points.setText(Integer.toString(DyslexiaFXMLController.countPoints));
        misses.setText(Integer.toString(DyslexiaFXMLController.countMisses));
    }    

    @FXML
    private void exitClicked(ActionEvent event) {
        System.exit(0);
    }
    
}
