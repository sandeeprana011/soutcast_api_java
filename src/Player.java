
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
528480
 */

/**
 *
 * @author sandeep
 */
public class Player {
//    static String url;
//    String devID="dnHoPZSjLfVVdI8N";
//    static URL ur;
    public static void main(String[] args) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        
//        ur=new URL("http://79.114.56.236:8020");
            AudioInputStream ais=AudioSystem.getAudioInputStream(new URL("http://79.114.56.236:8020"));
            Clip clip =AudioSystem.getClip();
            clip.open(ais);
            clip.start();
            
            
            
    }
}
