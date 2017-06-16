
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
    
    public Line(int x, int y, int endX, int endY) {
        this.x = x;
        this.y = y;
        this.endX = endX;
        this.endY = endY;
        color = Color.BLACK;
        size = 25;        
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
