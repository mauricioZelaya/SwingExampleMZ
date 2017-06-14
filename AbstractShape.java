import java.awt.Color;
import java.awt.Graphics;

/**
 * Abstract class AbstractShape - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class AbstractShape
{
    protected int x;
    protected int y;
    protected Color color;
    protected boolean changeAspect;
    
    
    protected Color getNextColor() {
        int red = (int) (255 * Math.random());
        int green = (int) (255 * Math.random());
        int blue = (int) (255 * Math.random());
        
        return new Color(red, green, blue);
    }
    
    //template method
    public void clickAt(int x, int y) {
        changeAspect = contains(x, y);
        if (changeAspect) {
            color = getNextColor();
            changeAspect = false;
            changeAspect();
        }
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        drawShape(g);
    }
    
    public abstract boolean contains(int x, int y);
    
    public abstract void changeAspect();
    
    public abstract void drawShape(Graphics g);
    
    public abstract double shapeArea();
    
}
