package OOP.InterfaceSegregationPrinciple;

//Class implementing relevant interface
public class Robot implements Workable {
    //    <write your code here>
    @Override
    public void work() {
        System.out.println("Robot is working");
    }
}
