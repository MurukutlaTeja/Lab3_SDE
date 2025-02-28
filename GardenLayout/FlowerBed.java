package application;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class FlowerBed implements iComposite {
    private Rectangle rectangle;
    private List<Flower> flowers;
    public FlowerBed(Point2D position) {
        flowers = new ArrayList<>();
        rectangle = new Rectangle();
        rectangle.setX(position.getX());
        rectangle.setY(position.getY());
        rectangle.setWidth(100);
        rectangle.setHeight(200);
        rectangle.setFill(Color.BLACK);
        rectangle.setStroke(Color.GREY);
        rectangle.setStrokeWidth(1);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
    public void addFlower(Flower flower) {
        if (!flowers.contains(flower)) {
            flowers.add(flower);
        }
    }
    public void removeFlower(Flower flower) {
        flowers.remove(flower);
    }
    @Override
    public void move(double dx, double dy) {
        rectangle.setX(rectangle.getX() + dx);
        rectangle.setY(rectangle.getY() + dy);
        for (Flower flower : flowers) {
            flower.move(dx, dy);
        }
    }
}
