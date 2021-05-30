package interfaces;

import java.awt.*;

public interface IVisible {
    public boolean IsInsideFigure(Point mousePointPosition);
    public void Paint(Graphics g);
    public void applyRedSelection(Graphics g);
}
