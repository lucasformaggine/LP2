package figures;

import java.awt.*;

public class Rect extends Figure {
    Rectangle rectangle;

    public Rect(int x, int y, int width, int height, Color borderColor, Color fillColor) {
        super(x, y, width, height, borderColor, fillColor);

        this.rectangle = new Rectangle(this.x, this.y, this.width, this.height);
    }

    public Rect(int x, int y, int width, int height) {
        super(x, y, width, height, Color.BLACK, Color.WHITE);

        this.rectangle = new Rectangle(this.x, this.y, this.width, this.height);
    }

    @Override
    public void Paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(defaultThickness));

        g2d.setColor(fillColor);
        g2d.fillRect(this.x, this.y, this.width, this.height);
        
        g2d.setColor(borderColor);
        g2d.drawRect(this.x, this.y, this.width, this.height);
        
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

        this.rectangle.setFrame(this.x, this.y, this.width, this.height);
    }
}
