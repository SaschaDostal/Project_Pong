package de.hft.ip1.group_3;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    static void PlaySound(String sound) {
        
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream asi = AudioSystem.getAudioInputStream(new URL("file", "localhost", sound));
            clip.open(asi);
            clip.start();
           
            
        } catch (Exception e) {
           e.printStackTrace();
        }    
        
    }

    static void sound(String sound) {
        try {
            Clip clip = AudioSystem.getClip();

            AudioInputStream asi = AudioSystem.getAudioInputStream(new URL("file", "localhost", sound));
            clip.open(asi);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
