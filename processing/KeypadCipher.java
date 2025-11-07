import processing.core.PApplet;
import processing.core.PImage;

public class KeypadCipher extends PApplet {
    float cX, cY;
    final int RED = color(255, 0, 0);
    final int WHITE = color(255, 255, 255);

    PImage keypad, keysprite;

    KeypadButton[] keys = new KeypadButton[9];

    boolean isHovering;

    public static void main (String[] args) {
        PApplet.main("KeypadCipher");
    }
    public void settings () {
        size(1024, 768, P2D);
        keypad = loadImage("sprites/keypad_sourceart.png");
        keysprite = loadImage("sprites/keyOn.png");
    }
    public void setup () {
        windowTitle("BioForge");
        cX = width / 2;
        cY = height / 2;

        keys[0] = new KeypadButton(this, keysprite, 326,345);   // Bottom Left
        keys[1] = new KeypadButton(this, keysprite, 453,345);   // Bottom Mid
        keys[2] = new KeypadButton(this, keysprite, 578,345);   // Bottom Right
        keys[3] = new KeypadButton(this, keysprite, 326,218);   // Mid Left
        keys[4] = new KeypadButton(this, keysprite, 453,218);   // Dead Center
        keys[5] = new KeypadButton(this, keysprite, 578,218);   // Mid Right
        keys[6] = new KeypadButton(this, keysprite, 326,88);    // Top Left
        keys[7] = new KeypadButton(this, keysprite, 453,88);    // Top Mid
        keys[8] = new KeypadButton(this, keysprite, 578,88);    // Top Right


    }

    public void mousePressed() {
        for (KeypadButton key : keys) {
            if(key.mouseOverKey())
                break;
        }
    }
    public void draw () {
        image (keypad, 0, 0);
        for (KeypadButton key : keys) {
            key.draw();
        }
        text (frameRate, 100, 100);
        //if (mouseX > cX && mouseX < cX + 200 && mouseY > cY && mouseY < cY + 100) {
        /*
        if (sqrt(pow(mouseX - cX, 2) + pow(mouseY - cY, 2)) < 100) {
            isHovering = true;
            fill(RED);
        }
        else {
            isHovering = false;
            fill(WHITE);
        }
        circle(cX, cY ,200);
        text("BUTTON", cX, cY);
        text("Framerate: " + (int)frameRate, 100, 100);
         */
    }
}

class KeypadButton {
    float x, y;
    PImage sprite;
    KeypadCipher p;
    boolean isOn;

    KeypadButton(KeypadCipher p, PImage sprite, float x, float y) {
        this.p = p;
        this.sprite = sprite;
        this.x = x;
        this.y = y;
    }
    boolean mouseOverKey() {
        if (p.mouseX > x && p.mouseX < x + 127 && p.mouseY > y && p.mouseY < y + 127) {
            isOn = true;
            return true;
        }
        return false;
    }
    void draw () {
        if (isOn)
            p.image(sprite, x, y);
    }
}
