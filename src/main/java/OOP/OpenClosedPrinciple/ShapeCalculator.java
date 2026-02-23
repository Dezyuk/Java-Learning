package OOP.OpenClosedPrinciple;

import java.util.List;

public class ShapeCalculator {
    public double calculateTotalArea(List<Shape> shapes) {
//		<write your code here>
        double totalArea = 0;
        if (shapes == null || shapes.size() == 0) {
            return totalArea;
        }
        for (Shape shape : shapes) {
            if (shape != null) {
                totalArea += shape.getArea();
            }
        }
        return totalArea;
    }
}

