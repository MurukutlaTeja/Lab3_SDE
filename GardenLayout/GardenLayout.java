package application;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class GardenLayout extends Application {
    private double lastX, lastY;
    private Flower draggedFlower = null;
    private FlowerBed draggedFlowerBed = null;
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        scene.setFill(Color.GREEN);
        Flower flower = new Flower(new Point2D(100, 100), Color.RED, true);
        FlowerBed flowerBed = new FlowerBed(new Point2D(200, 200));
        root.getChildren().addAll(flowerBed.getRectangle(), flower.getCircle());
        scene.setOnMousePressed(e -> {
            if (flower.getCircle().contains(e.getX(), e.getY())) {
                draggedFlower = flower;
                lastX = e.getSceneX();
                lastY = e.getSceneY();
            } else if (flowerBed.getRectangle().contains(e.getX(), e.getY())) {
                draggedFlowerBed = flowerBed;
                lastX = e.getSceneX();
                lastY = e.getSceneY();
            }
        });
        scene.setOnMouseDragged(e -> {
            if (draggedFlower != null) {
                double deltaX = e.getSceneX() - lastX;
                double deltaY = e.getSceneY() - lastY;
                draggedFlower.move(deltaX, deltaY);
                lastX = e.getSceneX();
                lastY = e.getSceneY();
            } else if (draggedFlowerBed != null) {
                double deltaX = e.getSceneX() - lastX;
                double deltaY = e.getSceneY() - lastY;
                draggedFlowerBed.move(deltaX, deltaY);
                lastX = e.getSceneX();
                lastY = e.getSceneY();
            }
        });
        scene.setOnMouseReleased(e -> {
            if (draggedFlower != null) {
                if (flowerBed.getRectangle().contains(draggedFlower.getCircle().getCenterX(), draggedFlower.getCircle().getCenterY())) {
                    flowerBed.addFlower(draggedFlower);
                } else {
                    flowerBed.removeFlower(draggedFlower);
                }
                draggedFlower = null;
            }
            draggedFlower = null;
            draggedFlowerBed = null;
        });
        primaryStage.setTitle("Garden Layout - Drag Flower and Flower Bed");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
