package figures;

import java.awt.Graphics;
import java.awt.*;

public abstract class Figure {
    Color borderColor, fillColor;

    int x, y;
    int w, h;

    public abstract void Paint(Graphics g);
}