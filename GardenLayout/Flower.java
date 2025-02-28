package application;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class Flower {
    private Circle circle;  
    private boolean movable;  
    public Flower(Point2D position, Color color, boolean movable) {
        this.movable = movable;
        circle = new Circle();  
        circle.setCenterX(position.getX()); 
        circle.setCenterY(position.getY()); 
        circle.setRadius(10);  
        circle.setFill(color);  
        circle.setStroke(Color.RED);  
        circle.setStrokeWidth(1); 
    }
    public Circle getCircle() {
        return circle;
    }
    public void move(double dx, double dy) {
        if (movable) {
            circle.setCenterX(circle.getCenterX() + dx);  
            circle.setCenterY(circle.getCenterY() + dy);  
        }
    }
}
