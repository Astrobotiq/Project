public class Fighter extends Character implements Playable{
    private String name;

    public Fighter(String name){
        super( (int)(6+Math.floor(Math.random()*5)),(int)(3+Math.floor(Math.random()*5)),(int)(1+Math.floor(Math.random()*5)),(int)(1+Math.floor(Math.random()*20)));
        this.name = name;
    }

    @Override
    public void showInfo(){
        System.out.println("Name of Fighter:"+name+"\n"+
                "Strengt of Fighter:"+getStrenght()+"\n"+
                "Vitality of Fighter:"+getVitality()+"\n"+
                "Intelligent of Fighter:"+getIntelligent()+"\n"+
                "Hit point of Fighter:"+getHP()+"\n"+
                "Fighter holds a "+ onHand[0].getName()+"\n"+
                "Fighter wears a "+ onBody[0].getName());
    }
    @Override
    public int attack(){
        return onHand[0].getDamage()+super.getStrenght();
    }
    public void addWeapons(Weapons weapons){
        onHand[0] = weapons;
    }
    public void addClothing(Clothing clothing){
        onBody[0] = clothing;
    }
}
