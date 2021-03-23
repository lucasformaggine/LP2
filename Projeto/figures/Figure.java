package figures;

import java.awt.Graphics;
import java.awt.*;
import java.util.Random;

public abstract class Figure {
    public Color borderColor, fillColor;
    public int x, y;
    public static Random random = new Random();

    public abstract void Paint(Graphics g);

    public Color getRandomColor() {
        return new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
    }
}