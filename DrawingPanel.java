import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Write a description of class DrawingPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DrawingPanel extends JPanel
{
    private Circle circle;

    public DrawingPanel(){
        setBackground(Color.GRAY);
        color = new Color(245, 253, 1);
        radius = 25;
        changeColor = false;
        circle = new Circle(radius, color);
        
        addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent event){
                System.out.println(String.format("click at: %s, %s", event.getX(), event.getY()));                
                circle.clickAt(event.getX(), event.getY());
                repaint();
            }
        });
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        xCenter = getWidth()/2;
        yCenter = getHeight()/2;
                
        //g.setColor(color);
        circle.draw(g, xCenter, yCenter);
    }

}