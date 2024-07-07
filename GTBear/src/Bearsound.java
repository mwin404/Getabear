import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Bearsound {



    public static void PlayMusic(String musiclocation) {

        try {
            File musicPath = new File(musiclocation);

            if(GTBear.gameOver==false) {

                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                    clip.start();


            }
            else {

            }

        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
