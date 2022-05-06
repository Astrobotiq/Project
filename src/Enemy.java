public class Enemy extends Character{
    public Enemy(){
        super( (int)(1+Math.floor(Math.random()*5)),(int)(1+Math.floor(Math.random()*5)),(int)(1+Math.floor(Math.random()*5)) );
    }


    @Override
    public void showInfo(){
        System.out.println("Strengt of enemy: "+getStrenght()+"\n"+
                "Vitality of enemy: "+getVitality()+"\n"+
                "Intelligent of enemy: "+getIntelligent());
    }
    @Override
    public int attack(){
        return onHand[0].getDamage()+super.getStrenght();
    }
}
