public class Character {
    private int strenght;
    private int vitality;
    private int intelligent;
    private int HP;

    Weapons[] onHand = new Weapons[1];
    Clothing[] onBody = new Clothing[1];

    public Character(int strenght,int vitality,int intelligent){
        this.setStrenght(strenght);
        this.setVitality(vitality);
        this.setIntelligent(intelligent);
        HP = (int)((0.7*vitality)+(0.2*strenght)+(0.1*intelligent));
    }

    public void showInfo(){
        System.out.println("Strengt of Character:"+getStrenght()+"\n"+
                "Vitality of Character:"+getVitality()+"\n"+
                "Intelligent of Character:"+getIntelligent()+"\n"+
                "Hit point of Character:"+getHP());

    }

    public int attack(){
        return 0;
    }
    public void takeDamage(int damage){
        HP = HP - damage;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getIntelligent() {
        return intelligent;
    }

    public void setIntelligent(int intelligent) {
        this.intelligent = intelligent;
    }

    public int getHP() {
        return HP;
    }
}
