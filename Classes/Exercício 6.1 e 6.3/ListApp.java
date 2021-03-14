import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.*;

class ListApp {
    public static void main(String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    ArrayList<Figure> figs = new ArrayList<Figure>();
    
    Random rand = new Random();

    private Color getRandomColor() {
        return new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
    }

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed(KeyEvent evt) {
                    int x1 = rand.nextInt(350);
                    int y1 = rand.nextInt(350);

                    int x2 = rand.nextInt(350) % 200 + 100;
                    int y2 = rand.nextInt(350) % 200 + 100;

                    int x3 = rand.nextInt(350) % 200 + 100;
                    int y3 = rand.nextInt(350) % 200 + 100;

                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
                    
                    Color borderColor = getRandomColor();
                    Color fillColor = getRandomColor();

                    if (evt.getKeyChar() == 'r') {
                        Rect r = new Rect(x1, y1, w, h, borderColor, fillColor);
                        figs.add(r);
                    } else if (evt.getKeyChar() == 'e') {
                        Ellipse e = new Ellipse(x1, y1, w, h, borderColor, fillColor);
                        figs.add(e);
                    } else if (evt.getKeyChar() == 't') {
                        Triangle t = new Triangle(x1, y1, x2, y2, x3, y3, borderColor, fillColor);
                        figs.add(t);
                    }

                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (Figure fig: this.figs) {
            fig.Paint(g);
        }
    }   
}