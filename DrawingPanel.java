
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
    //private Circle circle;
    private Collection<Circle> circles;
    private Collection<Square> squares;
    
    public DrawingPanel() {
        
        //circle = new Circle(25, Color.yellow);
        circles = new Vector<Circle>();
        squares = new Vector<Square>();
        
        setBackground(Color.GRAY);
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent event) {
                int random = (int)(Math.random() * 2);
                //if (!clickIsInsideAnyCircle(event) && !clickIsInsideAnySquare(event)) {
                    if (random == 1) {
                        addNewCircle(event);
                    }
                    else {
                        addNewSquare(event);
                    }
                //}
                
                Collections.sort((List<Circle>)circles, new CircleComparator());
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
    
    private boolean clickIsInsideAnyCircle(MouseEvent event) {
        boolean isInsideAnyCircle = false;
        for (Circle circle: circles) {
            circle.clickAt(event.getX(), event.getY());
            if (circle.contains(event.getX(), event.getY())) {
                isInsideAnyCircle = true;
            }            
        }
        return isInsideAnyCircle;
    }
    
    private void addNewCircle(MouseEvent event) {
        circles.add(new Circle(event.getX(), event.getY()));
    }
    
    private void addNewSquare(MouseEvent event) {
        squares.add(new Square(event.getX(), event.getY()));
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        for (Circle circle: circles) {
            circle.draw(g);
        }
        
        for (Square square: squares) {
            square.draw(g);
        }
    }
    
    private class CircleComparator implements Comparator<Circle>
    {
        @Override
        public int compare(Circle first, Circle second) {
            if (first.getRadius() == second.getRadius()) {
                return 0;
            }
            else if (first.getRadius() > second.getRadius()) {
                return -1;
            }
            else {
                return 1;
            }
        }
    }
}
