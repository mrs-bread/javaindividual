class ShapeContainer <T extends Shape>{
    private T shape;
    public ShapeContainer(T shape){
        this.shape=shape;
    }

    public double getArea(){
        return shape.getArea();
    }

    public String getID(){
        return shape.getID();
    }

    public void move(double dx, double dy){
        shape.move(dx,dy);
    }

    public static <T extends Shape> int compare(ShapeContainer<? extends Shape> shape1, ShapeContainer<? extends Shape> shape2){
        return Double.compare(shape1.getArea(),shape2.getArea());
    }
}
