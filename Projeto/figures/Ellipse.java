package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Figure {
    Ellipse2D ellipse;

    public Ellipse(int x, int y, int width, int height, Color borderColor, Color fillColor) {
        super(x, y, width, height, borderColor, fillColor);

        this.ellipse = new Ellipse2D.Float(x, y, width, height);
    }

    public Ellipse(int x, int y, int width, int height) {
        super(x, y, width, height, Color.BLACK, Color.WHITE);

        this.ellipse = new Ellipse2D.Float(x, y, width, height);
    }

    @Override
    public void Paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        this.ellipse = new Ellipse2D.Double(this.x, this.y, this.width, this.height);

        g2d.setStroke(new BasicStroke(defaultThickness*3/2));

        g2d.setColor(borderColor);
        g2d.draw(ellipse);

        g2d.setColor(fillColor);
        g2d.fill(ellipse);
    }

    public boolean IsInsideFigure(Point mousePointPosition) {
        return super.IsInsideFigure(mousePointPosition);
    }

    public void applyRedSelection(Graphics g) {
        super.applyRedSelection(g);
    }   

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
    }

    @Override
    public void dragFigure(Point mousePointPosition, int dx, int dy) {
        Point pointToResize = new Point(this.x + this.width, this.y + this.height);

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

        this.ellipse.setFrame(this.x, this.y, this.width, this.height);
    }
}