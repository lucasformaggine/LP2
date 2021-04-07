package frame;

import java.awt.*;
import java.awt.event.*;
import java.awt.Point;

import javax.swing.*;

import java.util.ArrayList;

import figures.*;
import handlers.*;
public class Frame extends JFrame {
    private static final long serialVersionUID = 1L;

    ArrayList<Figure> figures = new ArrayList<Figure>();
    Figure selectedFigure = null;

    KeyButtonHandler keyButtonHandler = new KeyButtonHandler();
    
    Point mousePointPosition = new Point(0, 0);
    
    public Frame() {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent) {
                    System.exit(0);
                }
            }
        );

        this.addMouseMotionListener (
            new MouseAdapter() {
                public void mouseMoved(MouseEvent mouseEvent) {
                    mousePointPosition.x = mouseEvent.getX();
                    mousePointPosition.y = mouseEvent.getY();
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed(KeyEvent keyEvent) {
                    keyButtonHandler.KeyButtonPressed(keyEvent, figures, selectedFigure, mousePointPosition);
                    repaint();
                }
            }
        );

        this.setTitle("Vectorial Graphic Editor");
        this.setSize(500, 500);
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (Figure fig: this.figures) {
            fig.Paint(g);
        }
    }
}
