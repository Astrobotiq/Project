public class Items {
    private String name;
    private double weight;
    private int value;

    public Items(String name, double weight, int value) {
        this.setName(name);
        this.setWeight(weight);
        this.setValue(value);
    }

    public void showInfo(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
