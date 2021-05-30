package frame;

import java.awt.Color;
import java.awt.event.*;
import java.awt.Point;
import java.awt.GraphicsEnvironment;
import java.awt.Graphics;
import java.awt.GraphicsDevice;

import java.io.*;

import java.util.ArrayList;

import javax.swing.*;

import figures.*;
import handlers.*;

import buttons.*;
public class Frame extends JFrame {
    private static final long serialVersionUID = 1L;

    ArrayList<Figure> figures = new ArrayList<Figure>();

    ArrayList<Button> buttons = new ArrayList<Button>() {
        {
            add(new Button(new Rect(40, 60, 30, 30), 0));
            add(new Button(new Ellipse(40, 115, 30, 30), 1));
            add(new Button(new Triangle(40, 170, 30, 30), 2));
            add(new Button(new LineSegment(40, 240, 15), 3));
        }
    };

    Figure selectedFigure = null;
    Button selectedButton = null;

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

                    selectedButton = MouseButtonHandler.CreateFigureByButton(mouseEvent, buttons, selectedButton, figures);

                    selectedButton = MouseButtonHandler.SelectButton(mouseEvent, buttons, selectedButton);

                    if (selectedButton != null) {
                        selectedFigure = null;
                    }

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
        
        for (Button button: this.buttons) {
            button.Paint(g);
        }

        if (selectedFigure != null) {
            selectedFigure.applyRedSelection(g);
        }

        if (selectedButton != null) {
            selectedButton.applyRedSelection(g);
        }

    }
}