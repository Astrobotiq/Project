public class Healer extends Character implements Playable{



    public Healer(String name){
        super( (int)(3+Math.floor(Math.random()*5)),(int)(1+Math.floor(Math.random()*5)),(int)(6+Math.floor(Math.random()*5)),(int)(1+Math.floor(Math.random()*20)),true,2);

    }

    @Override
    public void showInfo(){
        System.out.println(
                "Strengt of Healer:"+getStrenght()+"\n"+
                "Vitality of Healer:"+getVitality()+"\n"+
                "Intelligent of Healer:"+getIntelligent()+"\n"+
                "Hit point of Healer:"+getHP()+"\n"+
                "Healer holds a "+ onHand[0].getName()+"\n"+
                "Healer wears a "+ onBody[0].getName());
    }
    @Override
    public int attack(){
        return onHand[0].getDamage()+super.getStrenght();
    }
}
