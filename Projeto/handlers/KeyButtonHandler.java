package handlers;

import figures.*;

import java.awt.event.*;
import java.awt.Point;

import java.util.ArrayList;

public class KeyButtonHandler {
    private static final int defaultSize = 100;
    public class KeyButtons {
        public static final int DEL = 127;
        public static final int TAB = 9; 
        public static final int UP = 38;
        public static final int DOWN = 40;
        public static final int LEFT = 37;
        public static final int RIGHT = 39;
        public static final int PAGEUP = 33;
        public static final int PAGEDOWN = 34;
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
        } else if (keyEvent.getKeyCode() == KeyButtons.TAB) {
            if (selectedFigure == null) {
                if (figures.size() > 0) {
                    selectedFigure = figures.get(0);
                }
            } else {
                selectedFigure = figures.get((figures.indexOf(selectedFigure) + 1) % figures.size());
            }
        } else if (selectedFigure != null) {
            if (keyEvent.getKeyCode() == KeyButtons.UP) {
                selectedFigure.move(0, -10);
            } else if (keyEvent.getKeyCode() == KeyButtons.DOWN) {
                selectedFigure.move(0, 10);
            } else if (keyEvent.getKeyCode() == KeyButtons.LEFT) {
                selectedFigure.move(-10, 0);
            } else if (keyEvent.getKeyCode() == KeyButtons.RIGHT) {
                selectedFigure.move(10, 0);
            } else if (keyEvent.getKeyCode() == KeyButtons.DEL) {
                figures.remove(selectedFigure);        
                selectedFigure = null; 
            } else if (keyEvent.getKeyCode() == KeyButtons.PAGEUP) {
                selectedFigure.colorPalletIndex++;

                if (selectedFigure.colorPalletIndex > 10) {
                    selectedFigure.colorPalletIndex %= 11;
                }

                selectedFigure.applyColorChange();
            } else if (keyEvent.getKeyCode() == KeyButtons.PAGEDOWN) {
                selectedFigure.colorPalletIndex--;

                if (selectedFigure.colorPalletIndex < 0) {
                    selectedFigure.colorPalletIndex += 11;
                }

                selectedFigure.applyColorChange();
            }
        }

        return selectedFigure;
    }
}
