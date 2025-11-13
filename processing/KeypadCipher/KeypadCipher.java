import processing.core.PApplet;
import processing.core.PImage;
import java.util.Arrays;

public class KeypadCipher extends PApplet {
    float cX, cY;
    final int RED = color(255, 0, 0);
    final int WHITE = color(255, 255, 255);

    PImage keypad, keysprite;

    KeypadButton[] keys = new KeypadButton[9];
    boolean[] currentState = new boolean[9];
    boolean[] solutionState = {
            true,
            true,
            true,
            true,
            false,
            true,
            true,
            true,
            true,
    };
    boolean bPuzzleSolved, bInputEnabled, bStarted;
    int timeStamp;
    Timer timer;

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
        frameRate(30);
        windowTitle("BioForge");
        cX = width / 2;
        cY = height / 2;

        keys[0] = new KeypadButton(this, 1, keysprite, 326,345);   // Bottom Left
        keys[1] = new KeypadButton(this, 2, keysprite, 453,345);   // Bottom Mid
        keys[2] = new KeypadButton(this, 3, keysprite, 578,345);   // Bottom Right
        keys[3] = new KeypadButton(this, 4, keysprite, 326,218);   // Mid Left
        keys[4] = new KeypadButton(this, 5, keysprite, 453,218);   // Dead Center
        keys[5] = new KeypadButton(this, 6, keysprite, 578,218);   // Mid Right
        keys[6] = new KeypadButton(this, 7, keysprite, 326,88);    // Top Left
        keys[7] = new KeypadButton(this, 8, keysprite, 453,88);    // Top Mid
        keys[8] = new KeypadButton(this, 9, keysprite, 578,88);    // Top Right
        randomize();

        bInputEnabled = true;
        timer = new Timer(this);
    }
    public void keyPressed() {
        if (!bInputEnabled) {
            return;
        }
        if (keyCode >= 129 && keyCode <= 137) {
            keys[keyCode - 129].
        }
    }
    public void mousePressed() {
        if (!bInputEnabled) {
            return;
        }
        for (KeypadButton key : keys) {
            if(key.mouseOverKey()) {
                break;
            }
        }

    }
    public void draw () {
        image (keypad, 0, 0);
        for (KeypadButton key : keys) {
            key.draw();
        }
         if (bPuzzleSolved) {
            textSize(60);
            textAlign(CENTER, CENTER);
            text("DISARMED", cX, 622);

            for (KeypadButton k : keys)  {
                if (k.key != 5)
                    k.switchState();
            }

            int now = millis();
            if (now - timeStamp >= 1000) {
                bInputEnabled = true;
                bPuzzleSolved = false;
                randomize();
            }
        else{
            timer.draw();
            }
        }
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
    void puzzlesSolved (boolean value) {
        bPuzzleSolved = value;
        if (bPuzzleSolved) {
            bInputEnabled = false;
            timeStamp = millis();
        }
    }
    void randomize () {
        for ( KeypadButton key : keys) {
            if (Math.random() < 0.5) {
                key.switchState();
            }
        }
    }
    void startTimer() {
        bStarted = true;
        timer.start();
    }
}

class Timer {
    int secondsLeft = 240;
    int timeStamp;
    int minutes, timeSec;
    //String timeSec;
    boolean bRunning;
    KeypadCipher p;
    Timer(KeypadCipher p) {
        this.p = p;
        setTimeString();
    }
    void start () {
        bRunning = true;
        timeStamp = p.millis();
    }
    void update () {
        int now = p.millis();
        if (now - timeStamp >= 1000) {
            secondsLeft--;
            timeStamp += 1000;
            setTimeString();
        }
    }
    void setTimeString () {
        minutes = secondsLeft / 60;
        int seconds = secondsLeft % 60;
        String timeSec = String.valueOf(seconds);
        if (seconds > 10) {
            timeSec = "0" + timeSec;
        }
    }
    void draw () {
        if (bRunning ) return;
        if (secondsLeft > 0) update();
        p.textSize(42);
        p.textAlign(PApplet.CENTER, PApplet.CENTER);
        p.text (minutes + ":" + timeSec, p.cX, 622);

    }
}

class KeypadButton {
    float x, y;
    PImage sprite;
    KeypadCipher p;
    boolean isOn;
    int key;

    KeypadButton(KeypadCipher p, int key, PImage sprite, float x, float y) {
        this.p = p;
        this.key = key;
        this.sprite = sprite;
        this.x = x;
        this.y = y;
    }
    void switchState() {
        isOn = !isOn;
        p.currentState[key - 1] = isOn;
    }
    void keyPressed () {
        if (!p.bStarted) {
            p.startTimer();
        }
        switchState();
        switch (key) {
            case 1:
                p.keys[5].switchState();
                p.keys[7].switchState();
                break;
            case 2:
                p.keys[6].switchState();
                p.keys[8].switchState();
                break;
            case 3:
                p.keys[3].switchState();
                p.keys[7].switchState();
                break;
            case 4:
                p.keys[2].switchState();
                p.keys[8].switchState();
                break;
            case 5:
                p.keys[0].switchState();
                p.keys[2].switchState();
                p.keys[6].switchState();
                p.keys[8].switchState();
                break;
            case 6:
                p.keys[0].switchState();
                p.keys[6].switchState();
                break;
            case 7:
                p.keys[1].switchState();
                p.keys[5].switchState();
                break;
            case 8:
                p.keys[0].switchState();
                p.keys[2].switchState();
                break;
            case 9:
                p.keys[1].switchState();
                p.keys[3].switchState();
                break;

        }
    }
    boolean mouseOverKey() {
        if (p.mouseX > x && p.mouseX < x + 127 && p.mouseY > y && p.mouseY < y + 127) {
            if (Arrays.equals(p.currentState, p.solutionState)) {
                System.out.println("Puzzle Solved");
                p.puzzlesSolved(true);
            }
            else p.puzzlesSolved(false);
            return true;
        }
        return false;
    }
    void draw () {
        if (isOn)
            p.image(sprite, x, y);
    }
}
