package buttons;

import java.awt.*;

import interfaces.*;
import figures.*;

public class Button implements IVisible {
    public int x, y;
    public int size = 50;

    public int buttonIndex;

    public Figure figureButton;

    public Button(Figure figureButton, int buttonIndex) {
        this.figureButton = figureButton;
        this.buttonIndex = buttonIndex;

        this.x = 30;
        this.y = 50 + 55 * buttonIndex;
    }

    public void Paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setStroke(new BasicStroke(1));
        
        g2d.setPaint(Color.GRAY);
        g2d.fillRect(this.x, this.y, this.size, this.size);
        
        g2d.setPaint(Color.BLACK);
        g2d.drawRect(this.x, this.y, this.size, this.size);

        this.figureButton.Paint(g);
    }

    public boolean IsInsideFigure(Point mousePointPosition) {
        return (mousePointPosition.x >= this.x) && (mousePointPosition.x <= this.x + this.size) && (mousePointPosition.y >= this.y) && (mousePointPosition.y <= this.y + this.size);
    }

    public void applyRedSelection(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(1.5f));

        g2d.setColor(Color.RED);
        g2d.drawRect(this.x, this.y, this.size, this.size);
    }
}
