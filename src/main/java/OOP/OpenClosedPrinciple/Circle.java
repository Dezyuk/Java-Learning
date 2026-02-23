package OOP.OpenClosedPrinciple;

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return Math.pow(this.radius, 2)*Math.PI;
    }
//    <write your code here>
}
