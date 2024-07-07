import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Bearbuzzer {




    public static void PlayExtra(String location) {

        try {
            File musicPath = new File(location);

            if(musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);

                clip.start();
            }
            else {
                System.out.println("Can't find file");
            }

        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}