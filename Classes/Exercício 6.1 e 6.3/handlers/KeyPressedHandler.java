package handlers;

import figures.*;
import java.awt.event.*; 
import java.util.Random;

public class KeyPressedHandler {
    private Random random = new Random();

    public KeyPressedHandler() {
    
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
        }
        return null; 
    }

}
