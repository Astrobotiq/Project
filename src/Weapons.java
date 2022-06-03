public class Weapons extends Items{
    private int damage;
    private int type;

    public Weapons(String name, double weight, int value,int damage,int type) {
        super(name,weight,value);
        this.damage = damage;
        this.type = type;
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
    public int getType(){
        return type;
    }
    public void special(Character holder, Character effected){
    }
    public void special(Character character,int turn){

    }
    public void special(Character character){}

}
