package OOP.PresentsManagement;

public abstract class Sweet {
    private String name;
    private double SugarWeight;
    private double weight;
    public Sweet(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSugarWeight(double sugarWeight) {
        SugarWeight = sugarWeight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getSugarWeight() {
        return SugarWeight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Sweet{" +
                "name='" + name + '\'' +
                ", SugarWeight=" + SugarWeight +
                ", weight=" + weight +
                '}';
    }
}
