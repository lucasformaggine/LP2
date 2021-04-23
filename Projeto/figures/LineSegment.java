package figures;

import java.awt.*;
import java.awt.geom.*;


public class LineSegment extends Figure {
    private int x1, y1;
    private int x2, y2;
    private Color lineColor;
    Line2D lineSegment;
    

    public LineSegment(int x1, int y1, Color lineColor) {
        super(0, 0, 0, 0, lineColor, lineColor);

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1 + 2*defaultSize;
        this.y2 = y1;
        this.lineColor = lineColor;

        this.lineSegment = new Line2D.Float(this.x1, this.y1, this.x2, this.y2); 
    }

    public LineSegment(int x1, int y1) {
        super(0, 0, 0, 0, null, null);

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1 + 2*defaultSize;
        this.y2 = y1;
        this.lineColor = Color.BLACK;

        this.lineSegment = new Line2D.Float(this.x1, this.y1, this.x2, this.y2); 
    }

    @Override
    public void Paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setStroke(new BasicStroke(2.5f));

        g2d.setColor(lineColor);
        g2d.drawLine(this.x1, this.y1, this.x2, this.y2);
    }

    @Override
    public boolean IsInsideFigure(Point mousePointPosition) {
        return this.lineSegment.ptSegDist(mousePointPosition) <= 5;
    }

    @Override
    public void applyRedSelection(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(defaultThickness));

        g2d.setColor(Color.RED);
        g2d.drawLine(this.x1, this.y1, this.x2, this.y2);
    }   

    @Override
    public void move(int dx, int dy) {
        super.move(0, 0);
        
        this.x1 += dx;
        this.x2 += dx;

        this.y1 += dy;
        this.y2 += dy;
    }

    @Override
    public void dragFigure(Point mousePointPosition, int dx, int dy) {
        Point p1 = new Point(this.x1, this.y1);
        Point p2 = new Point(this.x2, this.y2);

        if (p1.distance(mousePointPosition) <= 5) {
            this.x1 += dx;
            this.y1 += dy;
        } else if (p2.distance(mousePointPosition) <= 5) {
            this.x2 += dx;
            this.y2 += dy;
        } else {
            move(dx, dy);
        }

        this.lineSegment.setLine(p1, p2);
    }
}
