package OOP.LiskovSubstitutionPrinciple;

public abstract class Shape {
    //    <write your code here>
    protected int width;
    protected int height;

    public void setWidth(int width) {
        if(width <= 0 ){
            throw new IllegalArgumentException();
        }
        this.width = width;
    }

    public void setHeight(int height) {

        if(height <= 0){
            throw new IllegalArgumentException();
        }
        this.height = height;
    }

    public int calculateArea() {
        return width * height;
    }
}
