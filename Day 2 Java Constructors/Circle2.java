public class Circle2 {
    private double radius;
    public Circle() {
        this(1.0);  // default radius = 1.0
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Getter method
    public double getRadius() {
        return radius;
    }

    // Calculate area
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Calculate circumference
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    // Display method
    public void displayInfo() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }

    // Main method to test
    public static void main(String[] args) {
        // Using default constructor
        Circle defaultCircle = new Circle();
        System.out.println("Default Circle:");
        defaultCircle.displayInfo();

        System.out.println();

        // Using parameterized constructor
        Circle customCircle = new Circle(5.5);
        System.out.println("Custom Circle:");
        customCircle.displayInfo();
    }
}
