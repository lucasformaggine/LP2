import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class EllipseApp {
    public static void main (String[] args) {
        EllipseFrame frame = new EllipseFrame();
        frame.setVisible(true);
    }
}

class EllipseFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    Ellipse e1, e2, e3;

    EllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Ellipse");
        this.setSize(350, 350);
        this.e1 = new Ellipse(100, 50, 80, 100, Color.RED, Color.PINK);
        this.e2 = new Ellipse(100, 150, 80, 100, Color.ORANGE, Color.YELLOW);
        this.e3 = new Ellipse(100, 250, 80, 100, Color.BLUE, Color.GREEN);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.Paint(g);
        this.e2.Paint(g);
        this.e3.Paint(g);
    }
}

class Ellipse {
    int x, y;
    int w, h;
    Color borderColor;
    Color filledColor;

    Ellipse(int x, int y, int w, int h, Color borderColor, Color filledColor) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.borderColor = borderColor;
        this.filledColor = filledColor;
    }

    void Print() {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void Paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(borderColor);
        g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));

        g2d.setColor(filledColor);
        g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
    }
}