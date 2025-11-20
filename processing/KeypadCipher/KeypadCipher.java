import processing.core.PApplet;
import processing.core.PImage;
import processing.sound.SoundFile;
import java.util.Arrays;

public class KeypadCipher extends PApplet {
    float cX, cY;
    final int RED = color(255, 0, 0);
    final int WHITE = color(255, 255, 255);

    PImage keypad, keysprite, redLights, explosionSprite;
    SoundFile  keybeep, timertick, Solved, FAH;
    SoundFile[] explosionSfx = new SoundFile[3];

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
    boolean bPuzzleSolved, bInputEnabled, bStarted, bDisarmed, bGameOver;
    int timeStamp;
    Timer timer;
    ProgressBar pBar;
    Explosion explosion;

    boolean isHovering;
    public static void main (String[] args) {
        PApplet.main("KeypadCipher");
    }
    public void settings () {
        size(1024, 768, P2D);
        keypad = loadImage("sprites/keypad_sourceart.png");
        keysprite = loadImage("sprites/keyOn.png");
        redLights = loadImage("sprites/red_lights.png");
        explosionSprite = loadImage("sprites/explosion.png");

        explosionSfx[0] = new SoundFile(this, "sounds/explosion.wav");
        explosionSfx[1] = new SoundFile(this, "sounds/explosion1.wav");
        explosionSfx[2] = new SoundFile(this, "sounds/explosion2.wav");

        keybeep = new SoundFile(this, "sounds/keybeep.wav");
        timertick = new SoundFile(this, "sounds/timertick.wav");
        Solved = new SoundFile(this, "sounds/deactivated.wav");
        FAH = new SoundFile(this, "sounds/FAH.wav");

    }
    public void setup () {
        frameRate(60);
        windowTitle("BioForge");
        cX = width / 2;
        cY = height / 2;

        keys[0] = new KeypadButton(this, 1, keysprite, 326,345);   // Bottom Left
        keys[1] = new KeypadButton(this, 2, keysprite, 453,345);   // Bottom Mid
        keys[2] = new KeypadButton(this, 3, keysprite, 578,345);   // Bottom Right
        keys[3] = new KeypadButton(this, 4, keysprite, 326,218);   // Mid Left
        keys[4] = new KeypadButton(this, 5, keysprite, 453,218);   // Dead Center
        keys[5] = new KeypadButton(this, 6, keysprite, 578,218);   // Mid Right
        keys[6] = new KeypadButton(this, 7, keysprite, 326,89);    // Top Left
        keys[7] = new KeypadButton(this, 8, keysprite, 453,89);    // Top Mid
        keys[8] = new KeypadButton(this, 9, keysprite, 578,89);    // Top Right
        randomize();

        bInputEnabled = true;
        timer = new Timer(this);
        pBar = new ProgressBar(this, redLights);
    }
    public void init() {
        bDisarmed = false;
        bGameOver = false;
        bPuzzleSolved = false;
        bInputEnabled = true;
        bStarted = false;
        pBar.init();
        timer.init();
        randomize();
    }
    public void keyPressed() {
        if (bGameOver || bDisarmed) {
            init();
            return;
        }
        if (!bInputEnabled) {
            return;
        }
        if (keyCode >= 129 && keyCode <= 137) {
            keys[keyCode - 129].keyPressed();
        }
    }
    public void mousePressed() {
        if (bGameOver || bDisarmed) {
            init();
            return;
        }
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
        if (bGameOver) {
            background(0);
            textSize(60);
            textAlign(CENTER, CENTER);
            text("GAME OVER", cX, cY);
            textSize(30);
            text("Press Any Key to Restart", cX, cY + 60);
            return;
        }
        image (keypad, 0, 0);
        if (!bDisarmed) pBar.draw();
        for (KeypadButton key : keys) {
            key.draw();
        }

        if (bPuzzleSolved) {
            textSize(60);
            textAlign(CENTER, CENTER);
            if (bDisarmed) {
                text("DISARMED", cX, 622);
            }
            else {
                text("PHASE: " + pBar.phase, cX, 622);
            }
            Solved.play();
            for (KeypadButton k : keys)  {
                if (k.key != 5)
                    k.switchState();
            }

            int now = millis();
            if (now - timeStamp >= 1000) {
                if(!bDisarmed) {
                    bInputEnabled = true;
                    randomize();
                }
                bPuzzleSolved = false;
            }
        }
        else {
            timer.draw();
        }
        if (explosion != null) {
            explosion.draw();
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
        //Solved.play();
        bPuzzleSolved = value;
        if (bPuzzleSolved) {
            bInputEnabled = false;
            timeStamp = millis();
            pBar.update();
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
    void disarm() {
        bDisarmed = true;
        bInputEnabled = false;
        timer.stop();
    }
    void explode() {
        bInputEnabled = false;
        timer.stop();
        explosion = new Explosion(this, explosionSprite, explosionSfx);
    }
    void gameOver() {
        bGameOver = true;
        explosion = null;
    }
}
class Explosion {
    final float GROWTH = 64;
    float size = 256;
    float x, y;
    int alpha = 255;
    PImage sprite;
    KeypadCipher p;
    SoundFile[] sfx;
    Explosion(KeypadCipher p, PImage sprite, SoundFile[] sfx) {
        this.p = p;
        this.sprite = sprite;
        x = p.cX;
        y = p.cY;
        this.sfx = sfx;
        explode();
    }
    void explode() {
        int randIndex = (int) p.random(0, 3);
        sfx[randIndex].play();
        p.FAH.play();
    }
    void draw () {
        if (size < 5000) size += GROWTH;
        else {
            p.background(0);
            p.tint(255, alpha);
            if (alpha > 0) alpha -= 5;
            else {
                p.gameOver();
            }
        }
        p.imageMode(PApplet.CENTER);
        p.image(sprite, x, y, size, size);
        p.imageMode(PApplet.CORNER);
        p.tint(255, 255);
    }
}
class ProgressBar {
    final int POS_X = 514, POS_Y = 564;
    int[] WIDTHS = { 338, 304, 266, 212, 152, 98, 42 };
    int phase, offset;
    PImage sprite;
    KeypadCipher p;
    ProgressBar(KeypadCipher p, PImage sprite) {
        this.p = p;
        this.sprite = sprite;
        init();
    }
    void init () {
        phase = 0;
        offset = 0;
    }
    void update () {
        if (phase < WIDTHS.length - 1) {
            phase++;
            offset = (WIDTHS[0] - WIDTHS[phase]) / 2;
        }
        else {
            p.disarm();
        }
    }
    void draw () {
        p.imageMode(PApplet.CENTER);
        p.image(sprite, POS_X, POS_Y, WIDTHS[phase], 60, offset, 0, WIDTHS[0] - offset, 60);
        p.imageMode(PApplet.CORNER);
        gameWon();
    }
    void gameWon() {
        if (phase == 7) {
            p.background(0);
            p.textSize(70);
            p.text("CONGRATULATIONS!", p.cX, p.cY);
            p.text("YOU WON", p.cX, p.cY + 60);
            p.bGameOver = true;
        }
    }
}
class Timer {
    int secondsLeft = 240;
    int timeStamp;
    int minutes;
    String timeSec;
    boolean bRunning, bDisplay;
    KeypadCipher p;
    Timer(KeypadCipher p) {
        this.p = p;
        init();
    }
    void init () {
        bDisplay = false;
        secondsLeft = 240;
        setTimeString();
    }
    void start () {
        bDisplay = true;
        bRunning = true;
        timeStamp = p.millis();
    }
    void stop () {
        bRunning = false;
    }
    void update () {
        int now = p.millis();
        if (now - timeStamp >= 1000) {
            secondsLeft--;
            if (secondsLeft == 0) {
                p.explode();
            }
            timeStamp += 1000;
            setTimeString();
        }
    }
    void setTimeString () {
        minutes = secondsLeft / 60;
        int seconds = secondsLeft % 60;
        timeSec = String.valueOf(seconds);
        if (seconds < 10) {
            timeSec = "0" + timeSec;
        }
    }
    void draw () {
        if (!bDisplay) return;
        if (bRunning && secondsLeft > 0) update();
        p.textSize(42);
        p.textAlign(PApplet.CENTER, PApplet.CENTER);
        //String formattedSeconds = (timeSec < 10) ? "0" + timeSec : String.valueOf(timeSec);
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
        p.keybeep.play();
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
        if (Arrays.equals(p.currentState, p.solutionState)) {
            System.out.println("Puzzle Solved");
            p.puzzlesSolved(true);
        }
        else p.puzzlesSolved(false);
    }
    boolean mouseOverKey() {
        if (p.mouseX > x && p.mouseX < x + 127 && p.mouseY > y && p.mouseY < y + 127) {
            keyPressed();
            return true;
        }
        return false;
    }
    void draw () {
        if (isOn)
            p.image(sprite, x, y);
    }
}
