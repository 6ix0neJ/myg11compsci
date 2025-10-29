import processing.core.PApplet;
import processing.core.PImage;
import processing.sound.SoundFile;

public class Ball extends PApplet {

    final float DAMPENING = 0.93f;
    float RADIUS;

    final float JUMP_VEL = 800;
    final float X_VEL_SENSITIVITY = 4.f;
    final float X_MAXSPEED = 800;
    final float BOUNCE_THRESHOLD = 30;


    float x, y, xVel, yVel, textVel;
    float clampedT = -1;
    float deltaT = 1.f/60;
    float floor;
    float rotation;

    PImage basketball;
    SoundFile bounce, music;

    Bounce p;

    public Ball (Bounce p, float x, float y, float floor) {
        this.p = p;
        this.x = x;
        this.y = y;
        this.floor = floor;
        this.bounce = p.bounce;
        this.basketball = p.basketball;
        this.RADIUS = 12 * p.PIXELS_PER_CM;
    }
    public void update() {
        float nexty;

        if (p.bLeft) {
            if (Math.abs(xVel) < X_MAXSPEED)
                xVel -= X_VEL_SENSITIVITY;
            else
                xVel = -X_MAXSPEED;
        }
        if (p.bRight) {
            if (Math.abs(xVel) < X_MAXSPEED)
                xVel += X_VEL_SENSITIVITY;
            else
                xVel = X_MAXSPEED;
        }
        x += xVel * deltaT * p.PIXELS_PER_CM;
        if (x < RADIUS || x > p.width - RADIUS) {
            if (x < RADIUS)
                x = RADIUS;
            else
                x = p.width - RADIUS;
            bounce.play();
            xVel *= -DAMPENING;
        }

        if (xVel != 0) {
            float dist = xVel * deltaT * p.PIXELS_PER_CM;
            rotation =(rotation +  dist / RADIUS) % (2 *(float)Math.PI);
        }

        if (clampedT != -1) {
            nexty = y + yVel * clampedT * p.PIXELS_PER_CM;
            clampedT = -1;
        } else {
            nexty = y + yVel * deltaT * p.PIXELS_PER_CM;
        }
        if (nexty > floor) {
            //yVel -= p.GRAVITY * deltaT * Math.abs(nexty - floor) / Math.abs(nexty - y);
            clampedT = deltaT * Math.abs(floor - y) / Math.abs(nexty - y);

            if (y < RADIUS) {
                y = RADIUS;
            } else {
                y = floor;
            }
            if (yVel > BOUNCE_THRESHOLD) {
                bounce.play();
                yVel *= -DAMPENING;
            } else {
                yVel = 0;
            }
            xVel *= DAMPENING * 1.07;

            if (p.bUp) {
                yVel = -JUMP_VEL;
            }
        } else {
            yVel += p.GRAVITY * deltaT;
            y = nexty;
        }
    }

    public void display () {
        p.pushMatrix();
        p.translate(x, y);
        p.rotate(rotation);
        p.image(basketball, -RADIUS, -RADIUS, 2 * RADIUS, 2 * RADIUS);
        p.popMatrix();
    }
}
