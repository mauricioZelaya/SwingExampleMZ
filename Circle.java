import java.awt.Color;
import java.awt.Graphics;
import java.util.Comparator;

/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle implements Comparable<Circle>
{
    private int x;
    private int y;
    private int radius;
    private Color color;
    private boolean changeAspect;
    
    public Circle(int radius, Color color){
        this.radius = radius;
        this.color = color;
    }
    
    public Circle(int x, int y){
        this.x = x;
        this.y = y;
        color = getNextColor();
        radius = 25;
    }
    
    public int getRadius(){
        return radius;
    }
    
    public void draw(Graphics g, int x, int y){
        this.draw(g);
        this.x=x;
        this.y =y;
    }
    
    public void draw(Graphics g){        
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius*2, radius*2);
    }
    
    public void clickAt(int x, int y){
        changeAspect = isInsideCircle(x, y);
        if(changeAspect){
            color = getNextColor();
            changeAspect = false;
            radius = (int)(200 * Math.random());
        }
    }
    
    private Color getNextColor(){
        int red = (int)(255 * Math.random());
        int green = (int)(255 * Math.random());
        int blue = (int)(255 * Math.random());
        
        return new Color(red, green, blue);
    }
    
    public boolean isInsideCircle(int x, int y){
        int xCenter = this.x;
        int yCenter = this.y;
        double d = Math.hypot(yCenter - y, xCenter - x);
        return (d <= radius);
    }
    
    public int compareTo(Circle compareCircle) {

		int compareRadius = ((Circle) compareCircle).getRadius();

		//ascending order
		//return this.radius - compareRadius;

		//descending order
		return compareRadius - this.radius;

	}
}
