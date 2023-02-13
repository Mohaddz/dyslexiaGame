
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
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
    String url1;

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

        url1 = "jdbc:derby://localhost:1527/cpcs";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        
        if (mainMenuController.gameChoice == 0) {
            String query = "SELECT SP_POINTS,SP_MISSES FROM player WHERE name='" + LoginController.userName + "'";
            try ( Connection con = DriverManager.getConnection(url1, "cpcs", "cpcs");  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    if (rs.getInt("SP_POINTS") - rs.getInt("SP_MISSES") <= SpillingFXMLController.countPoints - SpillingFXMLController.countMisses) {
                        LocalDateTime now = LocalDateTime.now();  
                        query = "UPDATE player SET SP_POINTS=" + SpillingFXMLController.countPoints + ",SP_MISSES=" + SpillingFXMLController.countMisses + ",SP_DATE="+dtf.format(now)+" WHERE name='" + LoginController.userName + "'";
                        stmt.executeUpdate(query);
                    }

                }
            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e);
            }
            points.setText(Integer.toString(SpillingFXMLController.countPoints));
            misses.setText(Integer.toString(SpillingFXMLController.countMisses));
        } else {
            String query = "SELECT W_POINTS,W_MISSES FROM player WHERE name='" + LoginController.userName + "'";
            try ( Connection con = DriverManager.getConnection(url1, "cpcs", "cpcs");  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    if (rs.getInt("W_POINTS") - rs.getInt("W_MISSES") <= DyslexiaFXMLController.countPoints - DyslexiaFXMLController.countMisses) {
                        LocalDateTime now = LocalDateTime.now();  
                        System.out.println(dtf.format(now));
                        query = "UPDATE player SET W_POINTS=" + DyslexiaFXMLController.countPoints  + ",W_MISSES=" + DyslexiaFXMLController.countMisses + ",W_DATE="+dtf.format(now)+" WHERE name='" + LoginController.userName + "'";
                        stmt.executeUpdate(query);
                    }

                }
            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e);
            }
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
