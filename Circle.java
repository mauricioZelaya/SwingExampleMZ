
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
    
    public void changeAspect() {
        radius = (int)(200 * Math.random());
    }
    
        
    public void drawShape(Graphics g) {
        g.fillOval(x - radius , y - radius, radius * 2, radius * 2);
        drawInternalOval(g);
        drawText(g);
    }
    
    private void drawInternalOval(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x - radius+3, y - radius+3, (radius * 2) - 5, (radius * 2)-5);
    }
    
    public void drawText(Graphics g){
        String text = "Task";
        FontMetrics fm = g.getFontMetrics();
        double textWidth = fm.getStringBounds(text, g).getWidth();
        g.setColor(Color.BLACK);
        g.drawString(text, (int) (x - textWidth/2), (int) (y + fm.getMaxAscent() / 2));
    }
    
    @Override
    public boolean contains(int x, int y) {
        int xCenter = this.x;
        int yCenter = this.y;
        double d = Math.hypot(yCenter - y, xCenter - x);
        return d <= radius;
    }
    /*
    public int getRadius() {
        return radius;
    }*/
    
    public double shapeArea(){
        return Math.pow(this.radius,2)*Math.PI;
    }
}