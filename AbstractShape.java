import java.awt.Color;

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
    
}
