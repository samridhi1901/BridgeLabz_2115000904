public class Circle {
    private double radius;
    public Circle() {
        this(1.0);
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public void displayCircleInfo() {
        System.out.println("Radius: " + radius);
    }

    public static void main(String[] args) {
        Circle defaultCircle = new Circle();
        defaultCircle.displayCircleInfo();
        System.out.println();
        Circle customCircle = new Circle(5.5);
        customCircle.displayCircleInfo();
    }
}