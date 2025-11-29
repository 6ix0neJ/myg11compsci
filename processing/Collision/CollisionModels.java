import processing.core.PApplet;
public class CollisionModels extends PApplet {
    int rectW, rectH, rectX, rectY;
    int cx, cy, cr;
    public static void main(String[] args) {
        PApplet.main("CollisionModels");
    }
    public void settings () {
        size(800, 600, P2D);
    }
    public void setup() {
        rectW = 50;
        rectH = 50;
        rectX = 100;
        rectY = 200;
        cr = 50;
    }
    public void draw() {
        background(255);

        cx = mouseX;
        cy = mouseY;

        rect(rectX, rectY, rectW, rectH);
        circle(cx, cy, cr*2);
        updateCollision();
    }

    public void updateCollision () {
        boolean bIsColliding = false;

        if (cx > rectX && cx < rectX + rectW) {
            if(cx >= rectY && cy <= rectY + rectH) {
                bIsColliding = true;
            } else {
                if (cy < rectY) {
                    if (rectY - cy < cr)
                        bIsColliding = true;
                } else {
                    if (cy - (rectY + rectH) < cr)
                        bIsColliding = true;
                }
            }
        } else {
            if(cy >= rectY && cy <= rectY + rectH) {
                if (cx < rectX) {
                    if (rectX - cx < cr)
                        bIsColliding = true;
                } else {
                    if (cx - (rectX + rectW) < cr)
                        bIsColliding = true;
                }
            }
        }
        if (bIsColliding) {
            fill(255, 0, 0);
        } else {
            fill(0);
        }
    }
}
