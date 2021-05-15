package figures;

import java.awt.*;

public class Triangle extends Figure {
    Polygon triangle;
    int xArray[], yArray[];

    public Triangle(int x, int y, int width, int height, Color borderColor, Color fillColor) {
        super(x, y, width, height, borderColor, fillColor);
    }

    public Triangle(int x, int y, int width, int height) {
        super(x, y, width, height, Color.BLACK, Color.WHITE);
    }

    @Override
    public void Paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int x1 = this.x;
        int y1 = this.y;
        int x2 = x1;
        int y2 = y1 + this.height;
        int x3 = x1 + this.width;
        int y3 = y1 + this.height;

        int xValues[] = {x1, x2, x3};
        int yValues[] = {y1, y2, y3};

        this.xArray = xValues;
        this.yArray = yValues;
        
        this.triangle = new Polygon(xArray, yArray, 3);
        
        g2d.setStroke(new BasicStroke(defaultThickness));

        g2d.setColor(fillColor);
        g2d.fillPolygon(this.triangle);

        g2d.setColor(borderColor);
        g2d.drawPolygon(this.triangle);
    }

    @Override
    public boolean IsInsideFigure(Point mousePointPosition) {
        return this.triangle.contains(mousePointPosition);
    }

    @Override
    public void applyRedSelection(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(defaultThickness));

        g2d.setColor(Color.RED);
        g2d.drawPolygon(this.xArray, this.yArray, 3);
    }   

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
    }

    @Override
    public void dragFigure(Point mousePointPosition, int dx, int dy) {
        Point pointToResize = new Point(this.xArray[2], this.yArray[2]);

        if (pointToResize.distance(mousePointPosition) <= 5) {
            if (this.width + dx >= 10) {
                this.width += dx;
            }

            if (this.height + dy >= 10) {
                this.height += dy;
            }
        } else {
            move(dx, dy);
        }

        int x1 = this.x;
        int y1 = this.y;
        int x2 = x1;
        int y2 = y1 + this.height;
        int x3 = x1 + this.width;
        int y3 = y1 + this.height;

        int xValues[] = {x1, x2, x3};
        int yValues[] = {y1, y2, y3};

        this.xArray = xValues;
        this.yArray = yValues;
    }
}
