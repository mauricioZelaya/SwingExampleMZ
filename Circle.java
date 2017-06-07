import java.awt.Color;
import java.awt.Graphics;

/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle
{
    private int x;
    private int y;
    private int radius;
    private Color color;
    
    public Circle(int radius, Color color){
        this.radius = radius;
        this.color = color;
    }
    
    public void draw(Graphics g, int x, int y){
        if(changeAspect){
            color = getNextColor();
            changeAspect =false;
            radius = (int)(200 * Math.random());
        }
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius*2, radius*2);
        this.x=x;
        this.y =y;
    }
    
    public void clickAt(){
        changeAspect = isInsideTheCircle(x, y);
    }
    
    private Color getNextColor(){
        int red = (int)(255 * Math.random());
        int green = (int)(255 * Math.random());
        int blue = (int)(255 * Math.random());
        
        return new Color(red, green, blue);
    }
}
