package Game_of_Generals.graphic.loader;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class SoundManager {

    private final Clip theme;

    public SoundManager() {
        this.theme = getClip(loadAudio("Theme_Song"));
    }

    private AudioInputStream loadAudio(String url) {

        try {

            File file = new File("src/resources/audio/" + url + ".wav");
            return AudioSystem.getAudioInputStream(file);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return null;
    }

    private Clip getClip(AudioInputStream stream) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void playBackground() {
        theme.start();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                theme.stop();
                playBackground();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 100000);
    }
}
