import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class PaintApp {
    public static void main(String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}


class PaintFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    Rect r1, r2, r3;

    PaintFrame() {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.setTitle("Painting Figures");
        this.setSize(350, 350);

        this.r1 = new Rect(175, 175, 110, 40, Color.YELLOW, Color.ORANGE);
        this.r2 = new Rect(175, 218, 110, 21, Color.BLACK, Color.BLUE);
        this.r3 = new Rect(175, 240, 110, 21, Color.PINK, Color.RED);
        
    }

    public void paint(Graphics g) {
        super.paint(g);

        this.r1.Paint(g);
        this.r2.Paint(g);
        this.r3.Paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    Color filledColor;
    Color borderColor;

    Rect(int x, int y, int w, int h, Color borderColor, Color filledColor) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.borderColor = borderColor;
        this.filledColor = filledColor;
    }

    void Print() {
        System.out.format("Retangulo de tamanho(%d, %d) na posicao (%d, %d).\n",
        this.w, this.h, this.x, this.y);
    }

    void Paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(this.borderColor);
        g2d.drawRect(this.x, this.y, this.w, this.h);

        g2d.setColor(this.filledColor);
        g2d.fillRect(this.x+1, this.y+1, this.w-1, this.h-1);
    }

}