package figures;

import java.awt.*;

public class Rect extends Figure {
    private int x, y;
    private int w, h;

    public Rect(int x, int y, int w, int h, Color borderColor, Color fillColor) {
        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;

        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    public Rect(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;

        this.borderColor = getRandomColor();
        this.fillColor = getRandomColor();
    }

    public void Paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(borderColor);
        g2d.drawRect(this.x, this.y, this.w, this.h);

        g2d.setColor(fillColor);
        g2d.fillRect(this.x, this.y, this.w, this.h);
    }
}
