
package encrypt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Huthaifa A Quraini
 */
public class Encrypt1 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Encrypt-Decrypt");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.getIcons().add(
                new Image(
                        encrypt.class.getResourceAsStream("data-encryption-256.png")));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
