import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    Rect r1;
    Ellipse e1;
    Triangle t1;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.setTitle("Java Packages");
        this.setSize(350, 350);

        this.r1 = new Rect(50, 50, 100, 30, Color.BLACK, Color.RED);
        this.e1 = new Ellipse(50, 100, 100, 30, Color.BLUE, Color.GREEN);
        this.t1 = new Triangle(60, 200, 60, 160, 140, 200, Color.ORANGE, Color.YELLOW);
    }

    public void paint (Graphics g) {
        super.paint(g);

        this.r1.Paint(g);
        this.e1.Paint(g);
        this.t1.Paint(g);
    }
}
