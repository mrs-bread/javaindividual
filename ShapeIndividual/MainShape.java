import java.awt.Rectangle;
import java.util.Random;

public class MainShape {
    public static void main(String[] args){
        Random random = new Random();
        String id1 = "Triangle-" + random.nextInt(100);
        String id2 = "Rectangl-" + random.nextInt(100);

        try {
            ShapeContainer<Triangle> triangleContainer = new ShapeContainer<>(new Triangle(id1, 10, 10, 3, 4, 5));
            ShapeContainer<Rectangl> rectangleContainer = new ShapeContainer<>(new Rectangl(id2, 20, 20, 4, 6));

            System.out.println("Площадь треугольника: " + triangleContainer.getArea());
            System.out.println("Площадь прямоугольника: " + rectangleContainer.getArea());

            triangleContainer.move(10, 20);
            rectangleContainer.move(5, 15);

            int comparisonResult = ShapeContainer.compare(triangleContainer, rectangleContainer);
            System.out.println("Сравнение площадей: " + (comparisonResult > 0 ? "Треугольник больше" : (comparisonResult < 0 ? "Прямоугольник больше" : "Площади равны")));
            ShapeContainer<Rectangl> ErrorRectangle = new ShapeContainer<>(new Rectangl(id1,10,10,0,3));

        } catch (InvalidShapeException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
