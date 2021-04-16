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
    }

    @Override
    public void Paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(1));

        g2d.setColor(fillColor);
        g2d.fillRect(this.x, this.y, this.width, this.height);
        
        g2d.setColor(borderColor);
        g2d.drawRect(this.x, this.y, this.width, this.height);
        
    }

    @Override
    public boolean IsInsideFigure(Point mousePointPosition) {
        return (mousePointPosition.x >= this.x) && (mousePointPosition.x <= this.x + width) && (mousePointPosition.y >= this.y) && (mousePointPosition.y <= this.y + height);
    }

    @Override
    public void applyRedSelection(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(1.5f));

        g2d.setColor(Color.RED);
        g2d.drawRect(this.x, this.y, this.width, this.height);
    }

    @Override
    public void drag(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}
