import java.awt.*;

/**
 * Write a description of class Square here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square extends AbstractShape
{
    private int side;
    
    public Square(int side, Color color) {
        this.side = side;
        this.color = color;
    }
    
    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        color = getNextColor();
        side = 25;
    }
    
    public void draw(Graphics g, int x, int y) {
        this.draw(g);
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics g) {
        
        g.setColor(color);
        g.fillRect(x - side, y - side, side * 2, side * 2);
    }
    
    public void clickAt(int x, int y) {
        changeAspect = contains(x, y);
        if (changeAspect) {
            color = getNextColor();
            changeAspect = false;
            side = (int)(200 * Math.random());
        }
    }
    
    public boolean contains(int x, int y) {
        return this.x <= x && x <= this.x + side && this.y <= y && y <= this.y + side;
    }
    
    public int getSide() {
        return side;
    }
}
