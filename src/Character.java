public class Character implements Playable{
    private int strenght;
    private int vitality;
    private int intelligent;
    private int HP;
    private int maxHP;
    private int dexerity;
    private boolean playable;
    private boolean stunned;
    private int playableTurn;
    private int type;
    private String name;
    private boolean visiable;


    public boolean isVisiable() {
        return visiable;
    }

    public void setVisiable(boolean visiable) {
        this.visiable = visiable;
    }


    public Character(int strenght,int vitality,int intelligent,int dexerity,boolean playable,int type, String name){
        this.setStrenght(strenght);
        this.setVitality(vitality);
        this.setIntelligent(intelligent);
        this.setDexerity(dexerity);
        HP = (int)((0.7*vitality)+(0.2*strenght)+(0.1*intelligent));
        this.setPlayable(playable);
        this.type = type;
        maxHP = HP;
        this.name=name;
        visiable = true;
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
    public void setHP(int HP){
        if (this.HP+HP>maxHP){
            this.HP=maxHP;
        }
        else {
            this.HP += HP;
        }
    }
    public int getDexerity() {
        return dexerity;
    }

    public void setDexerity(int dexerity) {
        this.dexerity = dexerity;
    }

    public boolean isPlayable() {
        return playable;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }
    public int getType(){
        return type;
    }
    public String getName(){
        return name;
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
