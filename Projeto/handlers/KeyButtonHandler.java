package handlers;

import figures.*;
import java.awt.event.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class KeyButtonHandler {
    private Random random = new Random();

    public class KeyButtons {
        public static final int DEL = 127;
    }

    public void KeyButtonPressed(KeyEvent keyEvent, ArrayList<Figure> figures, Figure selectedFigure, Point mousePointPosition) {
        if (keyEvent.getKeyChar() == 'r') {
            Rectangle rectangle = new Rectangle(mousePointPosition.x, mousePointPosition.y, random.nextInt(500/2), random.nextInt(500/2));
            figures.add(rectangle);
            //selectedFigure = rectangle;
        } else if (keyEvent.getKeyChar() == 'e') {
            Ellipse ellipse = new Ellipse(mousePointPosition.x, mousePointPosition.y, random.nextInt(500/2), random.nextInt(500/2));
            figures.add(ellipse);
            //selectedFigure = ellipse;
        } else if (keyEvent.getKeyChar() == 'l') {
            LineSegment line = new LineSegment(mousePointPosition.x, mousePointPosition.y, random.nextInt(500/2), random.nextInt(500/2));
            figures.add(line);
            //selectedFigure = line;
        } else if (keyEvent.getKeyCode() == KeyButtons.DEL) {
            if (selectedFigure != null) {
                figures.remove(selectedFigure);
                //selectedFigure = null;
            }
        }
    }
}
