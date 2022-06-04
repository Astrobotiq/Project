public class Tank extends Character{





    public Tank(String name){
        super( (int)(1+Math.floor(Math.random()*5)),(int)(6+Math.floor(Math.random()*5)),(int)(3+Math.floor(Math.random()*5)),(int)(1+Math.floor(Math.random()*20)),true,3,"Tank");

    }

    @Override
    public void showInfo(){
        System.out.println(
                "Strengt of Tank:"+getStrenght()+"\n"+
                "Vitality of Tank:"+getVitality()+"\n"+
                "Intelligent of Tank:"+getIntelligent()+"\n"+
                "Hit point of Tank:"+getHP()+"\n"+
                "Tank holds a "+ onHand[0].getName()+"\n"+
                "Tank wears a "+ onBody[0].getName());
    }
    @Override
    public int attack(){
        return onHand[0].getDamage()+super.getStrenght();
    }

}
