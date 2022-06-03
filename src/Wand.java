public class Wand extends Weapons{
    private int healPoint;

    public Wand(){

        super("Shord sword",1,3,(int)(Math.random()*8),2);
        healPoint = (int)(Math.random()*8);
    }

    public void special (Character holder, Character effected){
        System.out.println("Your character used this wand's special ability." +
                "\nHP of character you have choose increase");
        effected.setHP(holder.getIntelligent()+healPoint);
    }
}
