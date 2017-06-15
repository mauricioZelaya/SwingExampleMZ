
import java.awt.*;

/**
 * Write a description of class Line here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Line extends AbstractShape
{
    private int endX;
    private int endY;
    private int size;
    
    public Line(int size, Color color) {
        this.size = size;
        this.color = color;
    }
    
    public Line(int x, int y) {
        this.x = x;
        this.y = y;
        color = getNextColor();
        size = 25;
        endX = x + size;
        endY = y + size;
    }
    
    public boolean contains(int x, int y){
        return false;
    }
    
    public void changeAspect() {
        size = size;
    }
    
    public void drawShape(Graphics g) {        
        g.drawLine(x, y, endX, endY);
    }
    
    public double shapeArea(){
        return Math.sqrt(Math.pow((endX-x),2)+Math.pow((endY-y),2));
    }
}
