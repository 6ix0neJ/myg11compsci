import processing.core.PApplet;
import processing.sound.*;

public class FAH extends PApplet {
    float buttonX, buttonY, buttonW, buttonH;
    SoundFile fah;

    public static void main(String[] args) {
        PApplet.main("FAH");
    }

    public void settings() {
        //fullScreen();
        size(800, 600);
    }

    public void setup() {
        fah = new SoundFile(this, "sounds/FAH.wav");

        textAlign(CENTER, CENTER);
        textSize(64);

        buttonW = 300;
        buttonH = 150;
        buttonX = width / 2 - buttonW / 2;
        buttonY = height / 2 - buttonH / 2;
    }

    public void draw() {
        background(20);
        fill(255);
        rect(buttonX, buttonY, buttonW, buttonH, 25);
        fill(0);
        text("FAHHH", width / 2, height / 2);
    }

    public void mousePressed() {
        if (mouseX > buttonX && mouseX < buttonX + buttonW &&
                mouseY > buttonY && mouseY < buttonY + buttonH) {
            fah.play();
        }
    }

}
