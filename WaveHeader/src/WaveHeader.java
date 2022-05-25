import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class WaveHeader {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException {
        String path = "/Resource/Music/";
        File file = new File(path);
        System.out.println("nepu");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        double Audiolength = file.length();
        System.out.println("File size: " + Audiolength);
        AudioFormat format = audioInputStream.getFormat();
        System.out.println("Audio toString is: " + audioInputStream.toString());

    }
}
