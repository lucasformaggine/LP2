package frame;

import java.awt.*;
import java.awt.event.*;
import java.awt.Point;

import java.io.*;

import java.util.ArrayList;

import javax.swing.*;

import figures.*;
import handlers.*;

public class Frame extends JFrame {
    private static final long serialVersionUID = 1L;

    ArrayList<Figure> figures = new ArrayList<Figure>();
    Figure selectedFigure = null;

    Point mousePointPosition = new Point(0, 0);

    public Frame() {
        try {
            FileInputStream file = new FileInputStream("project.bin");
            ObjectInputStream object = new ObjectInputStream(file);

            this.figures = (ArrayList<Figure>) object.readObject();

            object.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        this.setFocusTraversalKeysEnabled(false);
        
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent) {
                    try {
                        FileOutputStream file = new FileOutputStream("project.bin");
                        ObjectOutputStream object = new ObjectOutputStream(file);

                        object.writeObject(figures);
                        object.flush();
                        object.close();
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }

                    System.exit(0);
                }
            }
        );

        this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed(MouseEvent mouseEvent) {
                    selectedFigure = MouseButtonHandler.SelectFigure(mouseEvent, figures, selectedFigure);
                    mouseMoved(mouseEvent); 
                    repaint();
                }
            }

        );

        this.addMouseMotionListener (
            new MouseAdapter() {
                public void mouseMoved(MouseEvent mouseEvent) {
                    mousePointPosition.x = mouseEvent.getX();
                    mousePointPosition.y = mouseEvent.getY();
                }

                public void mouseDragged(MouseEvent mouseEvent) {
                    selectedFigure = MouseButtonHandler.SelectAndDragFigure(mouseEvent, figures, selectedFigure, mousePointPosition);
                    mouseMoved(mouseEvent);
                    repaint();
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed(KeyEvent keyEvent) {
                    selectedFigure = KeyButtonHandler.KeyButtonPressed(keyEvent, figures, selectedFigure, mousePointPosition);
                    repaint();
                }
            }
        );

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        int userWidth = gd.getDisplayMode().getWidth();
        int userHeight = gd.getDisplayMode().getHeight();

        this.setTitle("Vectorial Graphic Editor");
        this.setSize(userWidth, userHeight);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Figure figure: this.figures) {
            figure.Paint(g);
        }

        if (selectedFigure != null) {
            selectedFigure.applyRedSelection(g);
        }

    }
}