package src;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import src.Enemy.Personality;
import src.GameMap.Locations;
public class Main implements Runnable {
	public static Scanner sc = new Scanner(System.in);
	boolean playCompleted;

    public static void main(String[] args) throws LineUnavailableException, UnsupportedAudioFileException{
   new Thread(new Main()).start();
    	GameMap.locationInit(Locations.RUINS_OF_AVARICE);
    
}


	@Override
	public void run() {
	 	try {
	 		System.out.println();
    	    File audioFile = new File("src/MainMusic.wav");
    		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
    		AudioFormat format = audioInputStream.getFormat();
    		DataLine.Info info = new DataLine.Info(Clip.class, format);
    		Clip audioClip = (Clip) AudioSystem.getLine(info);
    		audioClip.open(audioInputStream);
    		audioClip.loop(Clip.LOOP_CONTINUOUSLY);
    		audioClip.start();
	 	
	 	 while (!playCompleted) {
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException ex) {
                 ex.printStackTrace();
             }
	 	 }
         
	 	}
    	    catch(IOException e) {
    	    	e.printStackTrace();
    	    } catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	 
	}

	  public void update(LineEvent event) {
	        LineEvent.Type type = event.getType();
	         
	        if (type == LineEvent.Type.START) {
	            System.out.println("Playback started.");
	             
	        } else if (type == LineEvent.Type.STOP) {
	            playCompleted = true;
	            System.out.println("Playback completed.");
	        }
	 
	    }
	 
    
}