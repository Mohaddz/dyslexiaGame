
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class reportsController implements Initializable {

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
    @FXML
    private Button exitGame;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String url1 = "jdbc:derby://localhost:1527/cpcs";
        String query = "SELECT SP_POINTS,SP_MISSES,SP_DATE,W_POINTS,W_MISSES,W_DATE FROM player WHERE name='" + LoginController.userName + "'";
        try ( Connection con = DriverManager.getConnection(url1, "cpcs", "cpcs");  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                usernameMessage.setText("High scores for " + LoginController.userName);
                pointSG.setText(Integer.toString(rs.getInt("SP_POINTS")));
                missesSG.setText(Integer.toString(rs.getInt("SP_MISSES")));
                dateSG.setText(rs.getString("SP_DATE"));
                
                pointsWG.setText(Integer.toString(rs.getInt("W_POINTS")));
                missesWG.setText(Integer.toString(rs.getInt("W_MISSES")));
                dateWG.setText(rs.getString("W_DATE"));
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
    }

    @FXML
    private void exitClicked(ActionEvent event) throws IOException {
        AnchorPane mainMenu = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        mainMenuController.bgMusicMP3.stop();
        reportPane.getChildren().setAll(mainMenu);
    }
}
