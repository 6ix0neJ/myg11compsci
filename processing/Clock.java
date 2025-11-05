import processing.core.PApplet;
import processing.sound.SoundFile;

public class Clock extends PApplet {
    int backgroundColor;
    float centerX, centerY;

    float SECHAND_LENGTH = 420;
    float MINHAND_LENGTH = 390;
    float HOURHAND_LENGTH = 350;

    SoundFile minuteUpdate;
    public static void main(String[] args) {
        PApplet.main("Clock");
    }

    public void settings() {
        size(1000, 600);
    }

    public void setup() {
        backgroundColor = color(127, 127, 127);
        centerX = width / 2;
        centerY = height / 2;

        minuteUpdate = new SoundFile(this, "sounds/FAH.wav");

        textSize(30);
        textAlign(CENTER, CENTER);
    }

    public void draw() {
        background(backgroundColor);

        // Frame
        fill(0);
        circle(centerX, centerY, 600);
        fill(255);
        circle(centerX, centerY, 570);

        fill(255);
        float offset = 200;

        pushMatrix();
        translate(centerX, centerY);


        float scaleFactor = (float)0.9;
        for (int i = 1; i <= 12; i++) {
            rotate(radians(30));

            //x = r * Math.cos(radians(angle));
            //y = r * Math.sin(radians(angle));
            //triangle(0, -50 - offset, 50, -offset + 20, -50, 20 - offset);
            fill(2, 56, 234);
            triangle(0, -25 - offset, 25, -offset + 10, -25, 10 - offset);

            fill(0);
            text(i, 0, -offset - 50);
            fill(255);
        }


        popMatrix();

        //Clock Timing
        int ms = (int)(System.currentTimeMillis() % 1000);
        int s = second();
        int m = minute();
        int h = hour();

        // Second Hand
        strokeWeight(4);
        pushMatrix();
        translate(centerX, centerY);
        float secondAngleDeg = 6 * (s + ms / 1000.f);
        rotate(radians(secondAngleDeg));
        line(0, 150, 0, 150 - SECHAND_LENGTH);
        popMatrix();

        // Minute Hand
        strokeWeight(8);
        pushMatrix();
        translate(centerX, centerY);
        float minuteAngleDeg = (m + s/60f + ms/60000f) * 6f;
        rotate(radians(minuteAngleDeg));
        line(0, 125, 0, 150 - MINHAND_LENGTH);
        popMatrix();

        // Hour Hand
        strokeWeight(11);
        pushMatrix();
        translate(centerX, centerY);
        float hourAngleDeg = ((h % 12) + m/60f + s/3600f) * 30f;
        rotate(radians(hourAngleDeg));
        line(0, 100, 0, 150 - HOURHAND_LENGTH);
        popMatrix();


        // Centre Pin
        fill(255);
        stroke(0);
        strokeWeight(5);
        circle(centerX, centerY, 30);

        fill(0);
        //circle(centerX, centerY, 20);
        //text(System.currentTimeMillis() % 1000, centerX - 300, centerY-200);

        // Minute Notification
        if (s == 59.0f) {
            minuteUpdate.play();
        }

        // Digital Clock
        fill(57,255,20);
        text(h + ":" + m + ":" + s, 830, 100);

    }
}
