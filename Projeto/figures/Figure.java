package figures;

import java.awt.*;

import java.util.ArrayList;
import java.util.Arrays;

import handlers.*;

public abstract class Figure {
    protected Color borderColor;
    protected Color fillColor;
    protected int x, y;
    protected int width, height;
    protected static int defaultSize = 100;
    protected static float defaultThickness = 2.5f;
    public int colorPalletIndex = 0;

    ArrayList<Color> colorPallet = new ArrayList<Color>(
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
    public abstract boolean IsInsideFigure(Point mousePointPosition);
    public abstract void applyRedSelection(Graphics g);
    public abstract void dragFigure(Point mousePointPosition, int dx, int dy);
    //public abstract void resize(Point mousePointPosition, int dx, int dy);

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

    public void applyColorChange() {
        this.fillColor = this.colorPallet.get(this.colorPalletIndex);
    }   
}