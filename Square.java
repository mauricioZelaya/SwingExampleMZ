import java.awt.Color;
import java.awt.Graphics;

/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Square extends AbstractShape
{
    private int side;
    private boolean changeAspect;
    
    public Square(int side, Color color){
        this.side = side;
        this.color = color;
    }
    
    public Square(int x, int y){
        this.x = x;
        this.y = y;
        color = getNextColor();
        side = 25;
    }
    
    public int getSide(){
        return side;
    }
    
    public void draw(Graphics g, int x, int y){
        this.draw(g);
        this.x=x;
        this.y =y;
    }
    
    public void draw(Graphics g){        
        g.setColor(color);
        g.fillRect(x, y, side, side);
    }
    
    public void clickAt(int x, int y){
        changeAspect = contains(x, y);
        if(changeAspect){
            color = getNextColor();
            changeAspect =false;
            side = (int)(200 * Math.random());
        }
    }
    
    public boolean contains(int x, int y){
        int xCenter = this.x;
        int yCenter = this.y;
        double d = Math.hypot(yCenter - y, xCenter - x);
        return (d <= side);
    }
}

