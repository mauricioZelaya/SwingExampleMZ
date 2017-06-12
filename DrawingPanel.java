import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
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
    private Collection<Circle> circles;
    private Collection<Square> squares;
    private int randomDraw;

    public DrawingPanel(){
        setBackground(Color.GRAY);
        circles = new Vector<Circle>();
        squares = new Vector<Square>();
        

        addMouseListener(new MouseAdapter(){

                @Override
                public void mouseClicked(MouseEvent event){
                    //System.out.println(randomDraw);
                    randomDraw = (int)(Math.random()*2);
                    if(randomDraw == 1){
                        if(!clickIsInsideAnyCircle(event)){
                            addNewCircle(event);                        
                        //addNewSquare(event);
                    }
                }
                else{
                    if(!clickIsInsideAnySquare(event)){
                        //addNewCircle(event);                        
                        addNewSquare(event);
                    }
                }
                    Collections.sort((List<Circle>)circles, new circleComparator());
                    Collections.sort((List<Square>)squares, new squareComparator());
                    repaint();
                }
                
                @Override
                public void mouseDragged(MouseEvent event){
                    System.out.println(event.getX() + " - " + event.getY());
                }
            });
    }

    private boolean clickIsInsideAnyCircle (MouseEvent event){
        boolean isInsideCircle = false;
        for(Circle circle: circles){
            circle.clickAt(event.getX(), event.getY());
            if(circle.contains(event.getX(), event.getY())){
                isInsideCircle = true;
            }
        }
        return isInsideCircle;
    }    
    
    private boolean clickIsInsideAnySquare (MouseEvent event){
        boolean isInsideSquare = false;
        for(Square square: squares){
            square.clickAt(event.getX(), event.getY());
            if(square.contains(event.getX(), event.getY())){
                isInsideSquare = true;
            }
        }
        return isInsideSquare;
    }    

    private void addNewCircle(MouseEvent event){
        circles.add(new Circle(event.getX(), event.getY()));
    }
    
    private void addNewSquare(MouseEvent event){
        squares.add(new Square(event.getX(), event.getY()));
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);                
        for (Circle circle: circles){
            circle.draw(g);
            //square.draw(g);
        }
        for (Square square: squares){
            //circle.draw(g);
            square.draw(g);
        }
    }

    private class circleComparator implements Comparator<Circle>{
        @Override
        public int compare(Circle first, Circle second){
            if(first.getRadius() == second.getRadius()){
                return 0;
            }
            else if (first.getRadius() > second.getRadius()){
                return -1;
            }
            else{
                return 1;
            }

        }
    }
    
    private class squareComparator implements Comparator<Square>{
        @Override
        public int compare(Square first, Square second){
            if(first.getSide() == second.getSide()){
                return 0;
            }
            else if (first.getSide() > second.getSide()){
                return -1;
            }
            else{
                return 1;
            }

        }
    }
}