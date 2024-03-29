
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class LoginController implements Initializable {

    String url1;

    public static String userName;
    public static String userPassword;

    @FXML
    private TextField userId;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Text errorMessage;
    @FXML
    private AnchorPane loginPane;
    int lan;
    String [] language = {"ar","en"};
    String [] country = {"SA","US"};
    Locale currentLocale;
    ResourceBundle messages;
    @FXML
    private Button ar;
    @FXML
    private Button en;
    @FXML
    private Text Welcomey;
    @FXML
    private Text usery;
    @FXML
    private Text passy;
    @FXML
    private Text loggy;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
    }

    @FXML
    private void processLogin(ActionEvent event) throws IOException {
        
        AnchorPane mainMenu = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        url1 = "jdbc:derby://localhost:1527/cpcs";
        userName = userId.getText();
        userPassword = password.getText();
        String query = "SELECT name,passwod FROM player";
        boolean found = false;
        if(userName.isEmpty()||userPassword.isEmpty()){
            errorMessage.setText("Wrong entry");
            mainMenuController.bgMusicMP3.stop();
            return;
        }
        
        try ( Connection con = DriverManager.getConnection(url1, "cpcs", "cpcs");  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
                String pass = rs.getString("PASSWOD");
                System.out.println(pass);
                if (name.equalsIgnoreCase(userName)) {
                    if (pass.equalsIgnoreCase(userPassword)) {
                        System.out.println("User pass found");
                        loginPane.getChildren().setAll(mainMenu);
                        break;
                    } else {
                        mainMenuController.bgMusicMP3.stop();
                        errorMessage.setText("Wrong Password");
                        found = true;
                        break;
                    }
                }
            }
            
            if (found == false) {
                System.out.println("not found");
                query = "INSERT INTO player VALUES('" + userName + "', '" + userPassword + "',0,0,0,0,'Null','Null')";
                stmt.executeUpdate(query);
                loginPane.getChildren().setAll(mainMenu);
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
    }

    @FXML
    private void arButton(ActionEvent event) {
        lan = 0;
        currentLocale = new Locale(language[lan]);
            messages = ResourceBundle.getBundle("_"+currentLocale);
            usery.setText(messages.getString("User"));
            passy.setText(messages.getString("Pass"));
            Welcomey.setText(messages.getString("Wel"));
            loggy.setText(messages.getString("log"));
            userId.setPromptText(messages.getString("User"));
            password.setPromptText(messages.getString("Pass"));
    }

    @FXML
    private void enButton(ActionEvent event) {
        lan = 1 ;
        currentLocale = new Locale(language[lan]);
            messages = ResourceBundle.getBundle("_"+currentLocale);
            usery.setText(messages.getString("User"));
            passy.setText(messages.getString("Pass"));
            Welcomey.setText(messages.getString("Wel"));
            loggy.setText(messages.getString("log"));
            userId.setPromptText(messages.getString("User"));
            password.setPromptText(messages.getString("Pass"));
    }

}
