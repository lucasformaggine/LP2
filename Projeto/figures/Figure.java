package figures;

import java.awt.*;

import java.util.ArrayList;
import java.util.Arrays;

import interfaces.IVisible;

public abstract class Figure implements IVisible {
    protected Color borderColor;
    protected Color fillColor;
    protected int x, y;
    protected int width, height;
    protected static int defaultSize = 100;
    protected static float defaultThickness = 2.5f;
    public int fillColorIndex = 0;
    public int borderColorIndex = 10;

    ArrayList<Color> fillColorPallet = new ArrayList<Color>(
        Arrays.asList(Color.WHITE, Color.GRAY, Color.MAGENTA, Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED, Color.DARK_GRAY, Color.BLACK));

    ArrayList<Color> borderColorPallet = new ArrayList<Color>(
        Arrays.asList(Color.WHITE, Color.GRAY, Color.MAGENTA, Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED, Color.DARK_GRAY, Color.BLACK));

    protected Figure(int x, int y, int width, int height, Color borderColor, Color fillColor) {
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;
        
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    public abstract void Paint(Graphics g);

    public boolean IsInsideFigure(Point mousePointPosition) {
        return (mousePointPosition.x >= this.x) && (mousePointPosition.x <= this.x + width) && (mousePointPosition.y >= this.y) && (mousePointPosition.y <= this.y + height);
    }

    public void applyRedSelection(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(1.5f));

        g2d.setColor(Color.RED);
        g2d.drawRect(this.x, this.y, this.width, this.height);
    }

    public abstract void dragFigure(Point mousePointPosition, int dx, int dy);

    public void move(int dx, int dy) {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        int userWidth = gd.getDisplayMode().getWidth();
        int userHeight = gd.getDisplayMode().getHeight();

        if (this.x + dx >= 0 && this.x + dx <= userWidth) {
            this.x += dx;
        }
        
        if (this.y + dy >= 0 && this.y + dy <= userHeight - 100) {
            this.y += dy;
        }
    }

    public void applyFillColorChange() {
        this.fillColor = this.fillColorPallet.get(this.fillColorIndex);
    }   

    public void applyBorderColorChange() {
        this.borderColor = this.borderColorPallet.get(this.borderColorIndex);
    }   
}