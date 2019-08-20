
package loginexample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ProfileController implements Initializable {
    
    MediaPlayer mediaPlayer;
    
     @FXML
    private Button play;

    @FXML
    private Button pause;

    @FXML
    private Button stop;

    @FXML
    void pauseButton(ActionEvent event) {
        mediaPlayer.pause();
    }

    @FXML
    void playButton(ActionEvent event) {
        mediaPlayer.play();
    }

    @FXML
    void stopButton(ActionEvent event) {
        mediaPlayer.stop();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        music();
    }    

    private void music() {
        try{
            Media musicFile = new Media("file:///C:/Users/Emanuel/Desktop/DefaultSong.mp3");
            mediaPlayer = new MediaPlayer(musicFile);
            mediaPlayer.setVolume(0.5);
        } catch(Exception ex){
            System.out.println("Error");
        }
    }
    
}
