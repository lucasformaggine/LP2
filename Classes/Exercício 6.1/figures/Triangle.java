package figures;

import java.awt.*;

public class Triangle extends Figure {
    private int x1, y1;
    private int x2, y2;
    private int x3, y3;
    
    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color borderColor, Color fillColor) {
        this.x1 = x1;
        this.y1 = y1;

        this.x2 = x2;
        this.y2 = y2;

        this.x3 = x3;
        this.y3 = y3;

        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    public void Print() {
        System.out.format("Triangulo de vertices (%d, %d), (%d, %d) e (%d, %d).\n",
            this.x1, this.y1, this.x2, this.y2, this.x3, this.y3);
    }

    public void Paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(borderColor);

        g2d.drawLine(this.x1, this.y1, this.x2, this.y2);
        g2d.drawLine(this.x2, this.y2, this.x3, this.y3);
        g2d.drawLine(this.x3, this.y3, this.x1, this.y1);

        int x[] = {this.x1, this.x2, this.x3};
        int y[] = {this.y1, this.y2, this.y3};

        Polygon TriangleInterior = new Polygon(x, y, 3);

        g2d.setColor(fillColor);
        g2d.fillPolygon(TriangleInterior);
    }
}
