package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Figure {
    Ellipse2D ellipse;

    public Ellipse(int x, int y, int width, int height, Color borderColor, Color fillColor) {
        super(x, y, width, height, borderColor, fillColor);
    }

    public Ellipse(int x, int y, int width, int height) {
        super(x, y, width, height, Color.BLACK, Color.WHITE);
    }

    @Override
    public void Paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        this.ellipse = new Ellipse2D.Double(this.x, this.y, this.width, this.height);

        g2d.setStroke(new BasicStroke(2.5f));

        g2d.setColor(borderColor);
        g2d.draw(ellipse);

        g2d.setColor(fillColor);
        g2d.fill(ellipse);
    }

    @Override
    public boolean IsInsideFigure(Point mousePointPosition) {
        return this.ellipse.contains(mousePointPosition);
    }

    @Override
    public void applyRedSelection(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(1.5f));

        g2d.setColor(Color.RED);
        g2d.draw(this.ellipse);
    }

    @Override
    public void drag(int dx, int dy) {
        this.x += dx;
        this.y += dy;

        this.ellipse = new Ellipse2D.Double(this.x, this.y, this.width, this.height);
    }
}