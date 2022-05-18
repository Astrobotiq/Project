public class Enemy extends Character{
    boolean stunned;
    int playableTurn;
    public Enemy(){
        super( (int)(1+Math.floor(Math.random()*5)),(int)(1+Math.floor(Math.random()*5)),(int)(1+Math.floor(Math.random()*5)),(int)(1+Math.floor(Math.random()*20)) );
        stunned = false;
    }


    @Override
    public void showInfo(){
        System.out.println("Strengt of enemy: "+getStrenght()+"\n"+
                "Vitality of enemy: "+getVitality()+"\n"+
                "Intelligent of enemy: "+getIntelligent()+
                "\nHit point of Enemy:"+super.getHP());
    }
    @Override
    public int attack(){
        return (int)(Math.random()*10)+super.getStrenght();
    }

    public boolean isStunned(){
        return stunned;
    }
    public void isPlayableTurnCome(int turn){
        if (turn==playableTurn){
            stunned=false;
            attack();
        }
        else if(turn != playableTurn ){
            System.out.println("this enemy look like mess");
        }

    }

}

