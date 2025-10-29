import processing.core.PApplet;
import processing.core.PImage;
import processing.sound.*;

import java.util.ArrayList;

public class Bounce extends PApplet {

    final float GRAVITY = 980;
    final int PIXELS_PER_CM = 5;
    final int ORANGE = color(220, 100, 0);

    boolean bNextFrame;
    boolean bLeft, bRight, bUp;

    float lastMusicTimeStamp;
    float lastFrameTime = 0;

    PImage basketball;
    SoundFile bounce, music;

    ArrayList<Ball> ballActors = new ArrayList<>();

    public static void main(String[] args) {
        PApplet.main("Bounce");
    }

    public void settings() {
        fullScreen();
        //size(1920, 1080);
    }
    public void setup() {

        basketball = loadImage("sprites/basketball.png");
        bounce = new SoundFile(this, "sounds/FAH.wav");
        ballActors.add(new Ball (this,width / 2, height / 2, height - RADIUS));
        textSize(64);


        //music = new SoundFile(this, "music/Marvel83' - Golden Dawn.mp3");
        //music.play();
    }

    public void keyPressed() {
        switch (keyCode) {
            case ENTER:
                bNextFrame = true; break;
            case LEFT:
                bLeft = true; break;
            case RIGHT:
                bRight = true; break;
            case UP:
                bUp = true; break;
        }
    }
    public void keyReleased() {
        switch (keyCode) {
            case LEFT:
                bLeft = false; break;
            case RIGHT:
                bRight = false; break;
            case UP:
                bUp = false; break;
        }
    }

    public void mousePressed() {
        switch (mouseButton) {
            case LEFT:
                ballActors.add(new Ball(this, mouseX, mouseY, height - RADIUS)); break;
            case RIGHT:
                ballActors.remove(0); break;
        }

    }
    public void draw() {
        float now = millis();
        //deltaT = (now - lastFrameTime) / 1000.f;
        lastFrameTime = now;

        /*
        if (now - lastMusicTimeStamp > 1000) {
            if (!music.isPlaying()) {
                music.play();
            }
            lastMusicTimeStamp();
        }
        */

        background(100);

        for (Ball b : ballActors) {
            if (bNextFrame) {
            //bNextFrame = false;
            b.update();
        }
            b.display();
        }


    }
}
