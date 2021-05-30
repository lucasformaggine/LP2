package handlers;

import java.awt.event.*;
import java.awt.Point;

import java.util.ArrayList;

import figures.*;

import buttons.*;

public class MouseButtonHandler {
    private static final int defaultSize = 100;
    
    private class MouseButtons {
        private static final int MOUSE1 = 1;
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

    public static Button SelectButton(MouseEvent mouseEvent, ArrayList<Button> buttons, Button selectedButton) {
        selectedButton = null;

        if (mouseEvent.getButton() == MouseButtons.MOUSE1) {
            Point mousePointPosition = new Point(mouseEvent.getX(), mouseEvent.getY());

            for (Button button : buttons) {
                if (button.IsInsideFigure(mousePointPosition) == true) {
                    selectedButton = button;
                }
            }
        }

        return selectedButton;
    }

    public static Button CreateFigureByButton(MouseEvent mouseEvent, ArrayList<Button> buttons, Button selectedButton, ArrayList<Figure> figures) {
        if (selectedButton != null && mouseEvent.getButton() == MouseButtons.MOUSE1) {
            Point mousePointPosition = new Point(mouseEvent.getX(), mouseEvent.getY());
            boolean isClickingInButton = false;

            for (Button button : buttons) {
                if (button.IsInsideFigure(mousePointPosition) == true) {
                    isClickingInButton = true;
                }
            }

            if (isClickingInButton == false) {
                switch (selectedButton.buttonIndex) {
                    case 0:
                        Rect rectangle = new Rect(mousePointPosition.x, mousePointPosition.y, defaultSize, defaultSize);
                        figures.add(rectangle);
                        break;
                    case 1:
                        Ellipse ellipse = new Ellipse(mousePointPosition.x, mousePointPosition.y, defaultSize, defaultSize);
                        figures.add(ellipse);
                        break;
                    case 2:
                        Triangle triangle = new Triangle(mousePointPosition.x, mousePointPosition.y, defaultSize, defaultSize);
                        figures.add(triangle);
                        break;
                    case 3:
                        LineSegment line = new LineSegment(mousePointPosition.x, mousePointPosition.y, defaultSize);
                        figures.add(line);
                        break;
                    default:
                }
            }
            
            selectedButton = null;
        }
        return selectedButton;
    }

    public static Figure SelectAndDragFigure(MouseEvent mouseEvent, ArrayList<Figure> figures, Figure selectedFigure, Point mousePointPosition) {
        if (selectedFigure != null) {
            selectedFigure.dragFigure(mousePointPosition, mouseEvent.getX() - mousePointPosition.x, mouseEvent.getY() - mousePointPosition.y);
        }

        return selectedFigure;
    }
}
