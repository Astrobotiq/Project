public class Shield extends Weapons{

    public Shield(){

        super("Shield",5,4,(int)(Math.random()*10),3);


    }
    public void special (Character character,int turn){
        System.out.println("Your character used this shield's special ability." +
                "\nThe character you have choose will stunned for 3 turn.");
        character.setStunned(true,turn);
    }
}
