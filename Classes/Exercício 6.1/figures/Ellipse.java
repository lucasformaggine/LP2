package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure {
    private int w, h;

    public Ellipse(int x, int y, int w, int h, Color borderColor, Color fillColor) {
        this.x = x;
        this.y = y;
        
        this.w = w;
        this.h = h;

        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    public void Print() {
        System.out.format("Elipse de eixos (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void Paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(borderColor);
        g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));

        g2d.setColor(fillColor);
        g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
    }
}