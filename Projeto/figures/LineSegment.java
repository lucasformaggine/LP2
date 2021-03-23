package figures;

import java.awt.*;
import java.awt.Color;

public class LineSegment extends Figure {
    private int x1, y1;
    private int x2, y2;
    private Color lineColor;

    public LineSegment(int x1, int y1, int x2, int y2, Color lineColor) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.lineColor = lineColor;
    }

    public LineSegment(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.lineColor = getRandomColor();
    }

    public void Paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(lineColor);
        g2d.drawLine(this.x1, this.y1, this.x2, this.y2);
    }

}
