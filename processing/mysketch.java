import processing.core.PApplet;

public class mysketch extends PApplet {
    int x, y;
    public void settings() {
        size(720, 450);

    }

    public void setup() {
        var size = 200;
    }

    public void draw() {
        background(185,0,200);
        // Your drawing code here
        if (keyPressed) {
            background(100, 4, 12);
            x++;
            y++;
            text(300,250,0,0);
            System.out.println("Color Changed...");
            System.out.println("Circle Moving...");
        }
        fill(180,0,50);
        ellipse(x,y,20,20);
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "mysketch" };
        PApplet.main(appletArgs);
    }
}
