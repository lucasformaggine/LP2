package handlers;

import figures.*;
import java.awt.event.*; 
import java.util.Random;

public class Handlers {
    private Random random = new Random();

    public Handlers() {
    
    };

    public Figure HandleWithKey(KeyEvent evt) {
        if (evt.getKeyChar() == 'r') {
            Rect r = new Rect(random.nextInt(350), random.nextInt(350), random.nextInt(350), random.nextInt(350));
            return r; 
        } else if (evt.getKeyChar() == 'e') {
            Ellipse e = new Ellipse(random.nextInt(350), random.nextInt(350), random.nextInt(350), random.nextInt(350));
            return e;
        } else if (evt.getKeyChar() == 't') {
            Triangle t = new Triangle(random.nextInt(350) % 200 + 100, random.nextInt(350) % 200 + 100, random.nextInt(350) % 200 + 100, random.nextInt(350) % 200 + 100, random.nextInt(350) % 200 + 100, random.nextInt(350) % 200 + 100);
            return t;
        } else if (evt.getKeyChar() == 'l') {
            LineSegment l = new LineSegment(random.nextInt(350), random.nextInt(350), random.nextInt(350), random.nextInt(350));
            return l;
        }
        return null; 
    }
}
