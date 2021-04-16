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
        this.x2 = x1 + defaultSize;
        this.y2 = y1;
        this.lineColor = lineColor;

        this.lineSegment = new Line2D.Float(this.x1, this.y1, this.x2, this.y2); 
    }

    public LineSegment(int x1, int y1) {
        super(0, 0, 0, 0, null, null);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1 + defaultSize;
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
        int crossProduct = (mousePointPosition.y - this.y1) * (this.x2 - this.x1) - (mousePointPosition.x - this.x1) * (this.y2 - this.y1);

        if (Math.abs(crossProduct) != 0) {
            return false;
        }
    
        int dotProduct = (mousePointPosition.x - this.x1) * (this.x2 - this.x1) + (mousePointPosition.y - this.y1)*(this.y2 - this.y1);

        if (dotProduct < 0) {
            return false;
        }
    
        int squaredLineLength = (this.x2 - this.x1)*(this.x2 - this.x1) + (this.y2 - this.y1)*(this.y2 - this.y1);

        if (dotProduct > squaredLineLength) {
            return false;
        }
    
        return true;
    }

    @Override
    public void applyRedSelection(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(1.5f));

        g2d.setColor(Color.RED);
        g2d.drawLine(this.x1, this.y1, this.x2, this.y2);
    }   

    @Override
    public void drag(int dx, int dy) {
        this.x1 += dx;
        this.x2 += dx;

        this.y1 += dy;
        this.y2 += dy;

        this.lineSegment = new Line2D.Float(this.x1, this.y1, this.x2, this.y2);
    }
}
