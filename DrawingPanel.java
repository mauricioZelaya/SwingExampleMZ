import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Vector;

/**
 * Write a description of class DrawingPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DrawingPanel extends JPanel
{
    //private Circle circle;
    private Collection<Circle> circles;

    public DrawingPanel(){
        setBackground(Color.GRAY);
        
        //circle = new Circle(25, Color.yellow);
        circles = new Vector<Circle>();
        
        addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent event){
                //System.out.println(String.format("click at: %s, %s", event.getX(), event.getY()));                
                
                //circle.clickAt(event.getX(), event.getY());
                if(!clickIsInsideAnyCircle(event)){
                    addNewCircle(event);                        
                }
                
                repaint();
            }
        });
    }
    private boolean clickIsInsideAnyCircle (MouseEvent event){
        boolean isInsideCircle = false;
        for(Circle circle: circles){
            circle.clickAt(event.getX(), event.getY());
            if(circle.isInsideCircle(event.getX(), event.getY())){
                isInsideCircle = true;
            }
        }
        return isInsideCircle;
    }    
    
    private void addNewCircle(MouseEvent event){
        circles.add(new Circle(event.getX(), event.getY()));
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);                
        //g.setColor(color);
        for (Circle circle: circles){
            circle.draw(g);
        }
        
        //int xCenter = getWidth()/2;
        //int yCenter = getHeight()/2;
        
        //circle.draw(g, xCenter, yCenter);
    }

}