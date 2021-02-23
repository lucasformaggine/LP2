import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
        frame.setVisible(true);
    }
}

class Hello2DFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    public Hello2DFrame() {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Circle inscribed in a square");

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        int userWidth = gd.getDisplayMode().getWidth();
        int userHeight = gd.getDisplayMode().getHeight();
        
        this.setSize(userWidth, userHeight);

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        int squareSize = 400;

        g.setColor(Color.black);
        g.fillRect(0, 0, w, h);

        g2d.setPaint(Color.white);
        g2d.drawRect(w/2 - squareSize/2, h/2 - squareSize/2, squareSize, squareSize);

        g2d.setPaint(Color.green);    
        g2d.fillRect(w/2 - squareSize/2, h/2 - squareSize/2, squareSize, squareSize);

        g2d.setPaint(Color.white);
        g2d.drawArc(w/2 - squareSize/2, h/2 - squareSize/2, squareSize, squareSize, 0, 360);

        g2d.setPaint(Color.blue);
        g2d.fillArc(w/2 - squareSize/2, h/2 - squareSize/2, squareSize, squareSize, 0, 360);

    }
}