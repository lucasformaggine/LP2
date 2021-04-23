package handlers;

import java.awt.event.*;
import java.awt.Point;

import java.util.ArrayList;

import figures.*;

public class MouseButtonHandler {

    public class MouseButtons {
        public static final int MOUSE1 = 1;
    }

    public static Figure SelectFigure(MouseEvent mouseEvent, ArrayList<Figure> figures, Figure selectedFigure) {
        selectedFigure = null;
        
        if (mouseEvent.getButton() == MouseButtons.MOUSE1) {
            Point mousePointPosition = new Point(mouseEvent.getX(), mouseEvent.getY());

            for (Figure figure : figures) {
                if (figure.IsInsideFigure(mousePointPosition) == true) {
                    selectedFigure = figure;
                }
            }

            if (selectedFigure != null) {
                figures.remove(selectedFigure);
                figures.add(selectedFigure);
            }
        }

        return selectedFigure;
    }

    public static Figure SelectAndDragFigure(MouseEvent mouseEvent, ArrayList<Figure> figures, Figure selectedFigure, Point mousePointPosition) {
        if (selectedFigure != null) {
            selectedFigure.dragFigure(mousePointPosition, mouseEvent.getX() - mousePointPosition.x, mouseEvent.getY() - mousePointPosition.y);
        }

        return selectedFigure;
    }
}
