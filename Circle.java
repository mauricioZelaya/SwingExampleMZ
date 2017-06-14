
import java.awt.*;

/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circle extends AbstractShape
{
    private int radius;
    
    
    public Circle(int radius, Color color) {
        this.radius = radius;
        this.color = color;
    }
    
    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
        color = getNextColor();
        radius = 25;
    }
    
    @Override
    public void changeAspect() {
        radius = (int)(200 * Math.random());
    }
    
        
    public void drawShape(Graphics g) {        
        g.fillOval(x - radius , y - radius, radius * 2, radius * 2);
    }
    
    @Override
    public boolean contains(int x, int y) {
        int xCenter = this.x;
        int yCenter = this.y;
        double d = Math.hypot(yCenter - y, xCenter - x);
        return d <= radius;
    }
    
    public int getRadius() {
        return radius;
    }
}
