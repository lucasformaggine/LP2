package handlers;

import figures.*;

import java.awt.event.*;
import java.awt.Point;

import java.util.ArrayList;

public class KeyButtonHandler {
    //private Random random = new Random();
    private static final int defaultSize = 50;
    public class KeyButtons {
        public static final int DEL = 127;
        public static final int TAB = KeyEvent.VK_TAB; 
        public static final int UP = 38;
        public static final int DOWN = 40;
        public static final int LEFT = 37;
        public static final int RIGHT = 39;
    }

    public static Figure KeyButtonPressed(KeyEvent keyEvent, ArrayList<Figure> figures, Figure selectedFigure, Point mousePointPosition) {
        if (keyEvent.getKeyChar() == 'r') {
            Rect rectangle = new Rect(mousePointPosition.x, mousePointPosition.y, defaultSize, defaultSize);
            figures.add(rectangle);
        } else if (keyEvent.getKeyChar() == 'e') {
            Ellipse ellipse = new Ellipse(mousePointPosition.x, mousePointPosition.y, defaultSize, defaultSize);
            figures.add(ellipse);
        } else if (keyEvent.getKeyChar() == 't') {
            Triangle triangle = new Triangle(mousePointPosition.x, mousePointPosition.y, defaultSize, defaultSize);
            figures.add(triangle);
        } else if (keyEvent.getKeyChar() == 'l') {
            LineSegment line = new LineSegment(mousePointPosition.x, mousePointPosition.y);
            figures.add(line);
        } else if (keyEvent.getKeyCode() == KeyButtons.UP) {
            selectedFigure.drag(0, -10);
        } else if (keyEvent.getKeyCode() == KeyButtons.DOWN) {
            selectedFigure.drag(0, 10);
        } else if (keyEvent.getKeyCode() == KeyButtons.LEFT) {
            selectedFigure.drag(-10, 0);
        } else if (keyEvent.getKeyCode() == KeyButtons.RIGHT) {
            selectedFigure.drag(10, 0);
        } else if (keyEvent.getKeyCode() == KeyButtons.DEL) {
            if (selectedFigure != null) {
                figures.remove(selectedFigure);        
                selectedFigure = null;
            }
        } 
        /*} else if (keyEvent.getKeyCode() == KeyButtons.TAB) {
            if (selectedFigure != null) {
                selectedFigure = figures.get(figures.size() - 1);
            }
        }*/

        return selectedFigure;
    }
}
