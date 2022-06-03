public class Sword extends Weapons{

    public Sword() {
        super("Long Sword",2,5,(int)(Math.random()*10),1);
    }

    public void special(Character character){
        System.out.println("Your character used this sword's special ability." +
                "\nYour character will not take any damage this turn.");
        character.setVisiable(false);
    }
}
