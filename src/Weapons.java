public class Weapons extends Items{
    private int damage;


    public Weapons(String name, double weight, int value,int damage) {
        super(name,weight,value);
        this.damage = damage;
    }

    public String getName(){
        return super.getName();
    }
    public double getWeight(){
        return super.getWeight();
    }
    public int getValue(){
        return super.getValue();
    }

    @Override
    public void showInfo(){
        System.out.println("Name of weapon:"+getName()+"\n"+
                           "Weight of weapon"+getWeight()+"\n"+
                           "Value of weapon"+getValue()+"\n"+
                           "Damage of weapon"+ getDamage());
    }

    public int getDamage() {
        return damage;
    }
}
