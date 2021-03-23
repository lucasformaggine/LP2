import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.*;
import handlers.*;

class GraphicEditor {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setVisible(true);
    }
}

class Frame extends JFrame {
    private static final long serialVersionUID = 1L;

    ArrayList<Figure> figs = new ArrayList<Figure>();

    Handlers Handler = new Handlers();

    Random rand = new Random();
    
    Frame() {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addMouseListener (
            new MouseAdapter() {
                public void mouseMoved(MouseEvent evt) {
                    
                }
            }


        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed(KeyEvent evt) {
                    Figure fig = Handler.HandleWithKey(evt);

                    if (fig != null) {
                        figs.add(fig);
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