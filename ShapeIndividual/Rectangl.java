public class Rectangl extends Shape{
    private double width, height;

    public Rectangl(String id, double x, double y, double width, double height) throws InvalidShapeException {
        super(id, x, y);
        if (width <= 0 || height <= 0) {
            throw new InvalidShapeException("Некорректные стороны прямоугольника");
        }
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
        System.out.println("Прямоугольник " + getID() + " перемещен в точку (" + x + ", " + y + ")");
    }
}

