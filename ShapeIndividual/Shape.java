abstract class Shape {
    private String id;
    double x,y;
    public Shape(String id,double x,double y){
        this.id=id;
        this.x=x;
        this.y=y;
    }

    public String getID(){
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public abstract double getArea();

    public abstract void move(double dx,double dy);
}
