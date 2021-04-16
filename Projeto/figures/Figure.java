package figures;

import java.awt.*;
import java.util.Random;

public abstract class Figure {
    public Color borderColor;
    protected Color fillColor;
    protected int x, y;
    protected int width, height;
    protected static int defaultSize = 50;
    protected static Random random = new Random();

    protected Figure(int x, int y, int width, int height, Color borderColor, Color fillColor) {
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;
        
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    public abstract void Paint(Graphics g);
    public abstract boolean IsInsideFigure(Point mousePointPosition);
    public abstract void applyRedSelection(Graphics g);
    public abstract void drag(int dx, int dy);

    protected static Color getRandomColor() {
        return new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
    }
}