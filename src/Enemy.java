public class Enemy extends Character{
    private boolean stunned;
    private int playableTurn;
    private String name;
    public Enemy(){
        super( (int)(1+Math.floor(Math.random()*5)),(int)(1+Math.floor(Math.random()*5)),(int)(1+Math.floor(Math.random()*5)),(int)(1+Math.floor(Math.random()*20)),false,4,"Enemy");

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
            stunned = false;
            attack();
        }
        else if(turn != playableTurn ){
            System.out.println("this enemy look like mess");
        }

    }

    public void setStunned(boolean stunned,int turn) {
        this.stunned = stunned;
        playableTurn = turn+3;
    }
}

