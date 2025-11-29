import processing.core.PApplet;
public class boxCollision extends PApplet{

    // Rectangle A
    float ax;
    float ay;
    float aw = 150;
    float ah = 100;

    // Rectangle B
    float bx = 300;
    float by = 250;
    float bw = 150;
    float bh = 100;

    boolean isColliding;

    final int WHITE = color(255, 255, 255);
    final int GRAY = color(130);

    public static void main (String[] args) {
        PApplet.main("boxCollision");
    }
    public void settings () {
        size(1024, 768, P2D);
    }
    public void setup () {
        frameRate(60);
    }
    public void draw () {
        background(GRAY);

        ax = mouseX;
        ay = mouseY;

        isColliding = checkCollision(ax, ay, aw, ah, bx, by, bw, bh);

        fill(WHITE);
        rect(ax, ay, aw, ah);
        rect(bx, by, bw, bh);

        if (isColliding) {
            fill(255, 0, 0);
            textSize(30);
            text("COLLIDING", 400, 100);
        }
    }

    boolean checkCollision(float x1, float y1, float w1, float h1,
                          float x2, float y2, float w2, float h2) {

        return x1 < x2 + w2 && x1 + w1 > x2 && y1 < y2 + h2 && y1 + h1 > y2;
    }
}
