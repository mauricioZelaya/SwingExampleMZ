
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;
import java.util.List;
import java.util.Comparator;

/**
 * Write a description of class DrawingPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DrawingPanel extends JPanel
{
    private Collection<AbstractShape> shapes;
    
    public DrawingPanel() {
        
        shapes = new Vector<AbstractShape>();
        
        setBackground(Color.GRAY);
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent event) {
                addNewShape(event);
                Collections.sort((List<AbstractShape>)shapes, new ShapeComparator());
                repaint();
            }
            
        });
        
        addMouseMotionListener(new MouseMotionAdapter() {
            
            @Override
            public void mouseDragged(MouseEvent event) {
                System.out.println(event.getX()+ ", " + event.getY());
            }
        });
    }
       
    private boolean clickIsInsideAnyShape(MouseEvent event) {
        boolean isInsideAnyShape = false;
        for (AbstractShape shape: shapes) {
            shape.clickAt(event.getX(), event.getY());
            if (shape.contains(event.getX(), event.getY())) {
                isInsideAnyShape = true;
            }            
        }
        return isInsideAnyShape;
    }
    
    private void addNewShape(MouseEvent event) {
        int random = (int)(Math.random() * 2);
         if (random == 1) {
             shapes.add(new Circle(event.getX(), event.getY()));
             //shapes.add(new Circle(event.getX(), event.getY()));
            }
         else{
              shapes.add(new Square(event.getX(), event.getY()));
              }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (AbstractShape shape: shapes) {
            shape.draw(g);
        }
    }
    
    private class ShapeComparator implements Comparator<AbstractShape>
    {
        @Override
        public int compare(AbstractShape first, AbstractShape second) {
            if (first.shapeArea() == second.shapeArea()) {
                return 0;
            }
            else if (first.shapeArea() > second.shapeArea()) {
                return -1;
            }
            else {
                return 1;
            }
        }
    }
}