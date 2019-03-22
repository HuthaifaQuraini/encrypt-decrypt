
package encrypt;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Huthaifa A Quraini
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXTextField txt2;

    @FXML
    private JFXTextField txt1;

    @FXML
    void Encrypt(ActionEvent event) {
        txt2.getText();
        encrypt x = new encrypt(txt1.getText());
        txt2.setText(x.toString());

    }

    @FXML
    void Decrypt(ActionEvent event) {
        txt2.getText();
        decrypt x = new decrypt(txt1.getText());
        txt2.setText(x.toString());
    }

    @FXML
    void replace(ActionEvent event) {
        txt1.setText(txt2.getText());
        txt2.setText("");
    }

    @FXML
    void Encrypt_File(ActionEvent event) throws FileNotFoundException {
             txt2.getText();
             if(txt3.getText().isEmpty()){
                 JOptionPane.showMessageDialog(null, "Read correct File");
             }
             else{
            encrypt x = new encrypt(txt3.getText());
            FileChooser f = new FileChooser();
            File SelectFile = f.showSaveDialog(null);
            File file = new File(SelectFile.getPath());
            txt2.setText(x.toString());
            PrintWriter write = new PrintWriter(file.getPath());
            write.print(x.toString());
            write.close();

        
             }
    }

    @FXML
    void Decrypt_File(ActionEvent event) throws FileNotFoundException {
        txt2.getText();
        if(txt3.getText().isEmpty()){
                 JOptionPane.showMessageDialog(null, "Read correct File");
             }
             else{
            decrypt x = new decrypt(txt3.getText());
            FileChooser f = new FileChooser();
            File SelectFile = f.showSaveDialog(null);
            File file = new File(SelectFile.getPath());
            txt2.setText(x.toString());
            PrintWriter write = new PrintWriter(file.getPath());
            write.print(x.toString());
            write.close();

        
        }
    }
    @FXML
    private JFXToggleButton JT;
    @FXML
    private JFXButton B2;
    @FXML
    private JFXButton B1;
    @FXML
    private JFXTextField txt3;
    @FXML
    private JFXButton B3;

    @FXML
    private JFXButton B4;
    @FXML
    private JFXButton Read;

    @FXML
    void Read_file(ActionEvent event) throws IOException {
        txt2.setText("");
        FileChooser f = new FileChooser();
        File SelectFile = f.showOpenDialog(null);
        if (SelectFile != null) {

            try (InputStreamReader writer = new InputStreamReader(new FileInputStream(SelectFile.getPath()), StandardCharsets.UTF_8)) {
                String r="";
                int num;
                while((num=writer.read())!=-1){
                    r+=(char)num+"";
                }
                txt3.setText(r);
                
            }
                
               
                
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid file");
        }
    }

    @FXML
    private JFXButton Swap;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        JT.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                boolean isSelected = JT.isSelected();
                if (isSelected) {
                    txt2.setText("");
                    B1.setVisible(false);
                    B2.setVisible(false);
                    B3.setVisible(true);
                    B4.setVisible(true);
                    Read.setVisible(true);
                    txt3.setVisible(true);
                    txt1.setVisible(false);
                    Swap.setVisible(false);
                    txt3.setDisable(true);
                    txt2.setDisable(true);
                    ;

                } else {
                    txt1.setText("");
                    txt2.setText("");
                    txt2.setDisable(false);
                    B1.setVisible(true);
                    B2.setVisible(true);
                    B3.setVisible(false);
                    B4.setVisible(false);
                    txt3.setVisible(false);
                    txt1.setVisible(true);
                    Read.setVisible(false);
                    Swap.setVisible(true);
                }

            }
        });
    }

}
