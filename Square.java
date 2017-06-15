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
    
    public void drawShape(Graphics g) {
        g.fillRect(x - side, y - side, side * 2, side * 2);
    }
    
    public void changeAspect() {
        side = (int)(200 * Math.random());
    }
    
    
    public boolean contains(int x, int y) {
        return this.x <= x && x <= this.x + side && this.y <= y && y <= this.y + side;
    }
    
    public int getSide() {
        return side;
    }
}