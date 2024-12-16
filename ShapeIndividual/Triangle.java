public class Triangle extends Shape{
    private double a, b, c;

    public Triangle(String id, double x, double y, double a, double b, double c) throws InvalidShapeException {
        super(id, x, y);
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            throw new InvalidShapeException("Некорректные стороны треугольника");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
        System.out.println("Треугольник " + getID() + " перемещен в точку (" + x + ", " + y + ")");
    }
}

