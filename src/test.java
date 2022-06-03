import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Character> Level = new ArrayList<>();
        ArrayList<Character> actionOrder = new ArrayList<>();
        int turn = 1;
        int enemyNumber = 1;
        int floorNumber = 0;

        /*Karakterler için kıyafet oluşturduğumuz kısım*/
        Light_Armor light_armor = new Light_Armor();
        Medium_Armor medium_armor = new Medium_Armor();
        Heavy_Armor heavy_armor = new Heavy_Armor();
        /*Karakterler için silah oluşturduğumuz kısım*/
        Sword sword = new Sword();
        Wand wand = new Wand();
        Shield shield = new Shield();
        /*Karakterleri oyunun level'ına eklediğimiz kısım*/
        System.out.println("Please give your FIGHTER a name:");
        String fighterName=input.nextLine();
        System.out.println("Please give your HEALER a name:");
        String healerName=input.nextLine();
        System.out.println("Please give your TANK a name:");
        String tankName=input.nextLine();
        Fighter fighter = new Fighter(fighterName);
        Healer healer = new Healer(healerName);
        Tank tank = new Tank(tankName);
        fighter.addClothing(medium_armor);
        healer.addClothing(light_armor);
        tank.addClothing(heavy_armor);
        fighter.addWeapons(sword);
        healer.addWeapons(wand);
        tank.addWeapons(shield);
        Level.add(fighter);
        Level.add(healer);
        Level.add(tank);



        while(true){
            System.out.println("You are on dungeon "+floorNumber+"\n"+
                               "There are "+enemyNumber+" enemy in front of you.");
            for (int i = enemyNumber;i>0;i-- ){
                createEnemy(new Enemy(),Level);
            }
            do {
                int willDelete = 0;
                Character[] highestChar = new Character[1];
                highestChar[0] = Level.get(0);
                for (int i=0;i<Level.size();i++){
                    if (Level.get(i).getDexerity()>highestChar[0].getDexerity()){
                        highestChar[0] = Level.get(i);
                        willDelete = i;
                    }
                }
                actionOrder.add(highestChar[0]);
                Level.remove(willDelete);

            }while ((enemyNumber+3)!=actionOrder.size());
            int sıra =0;
            while (true){
                boolean areThereEnemy = false;


                showOption(actionOrder.get(sıra),actionOrder,turn);

                for (int i=0;i<actionOrder.size();i++){
                    if (actionOrder.get(i).getType()==4){
                        if (actionOrder.get(i).isVisiable()==true){
                            areThereEnemy = true;
                        }
                    }
                }
                if (areThereEnemy){
                    System.out.println("Henüz bütün düşmanlar ölmedi.Yeni tura geçiliyor");
                }
                else {
                    System.out.println("You have killed all enemy on level. Well done.!.!");
                    int[] indexOfEnemy = new int[enemyNumber];
                    for (int i=0;i<actionOrder.size();i++){
                        int counter = 0;
                        if (actionOrder.get(i).getType()==4){
                            indexOfEnemy[counter] = i;
                            counter+=1;
                        }
                    }
                    for (int i=0;i<enemyNumber;i++){
                        actionOrder.remove(indexOfEnemy[i]);
                    }
                    Level.add(actionOrder.get(0));
                    Level.add(actionOrder.get(1));
                    Level.add(actionOrder.get(2));
                    actionOrder.remove(0);
                    actionOrder.remove(0);
                    actionOrder.remove(0);
                    break;
                }

                if (sıra != actionOrder.size()){
                    sıra = sıra + 1;
                    System.out.println(sıra);
                }
                else if(sıra == actionOrder.size()-1){
                    sıra = 0;
                    turn += 1;
                }
            }
        floorNumber +=1;
        enemyNumber *=2;
            
        }
    }
    public static void createEnemy(Enemy enemy,ArrayList<Character>Level){
        Level.add(enemy);
    }

    public static void showOption(Character character,ArrayList<Character>actionOrder,int turn){
        Scanner input = new Scanner(System.in);
        
        if (character.getType()==1&&character.isVisiable()==true){
            System.out.println("Now it is Fighter's turn:");}
        else if (character.getType()==2&&character.isVisiable()==true){
            System.out.println("Now it is Healer's turn::");}
        else if (character.getType()==3&&character.isVisiable()==true){
            System.out.println("Now it is Tank's turn:");}
        else if (character.getType()==4&&character.isVisiable()==true){
            if (character.isStunned()==true){
                System.out.println("This enemy is stunned.");
            }
            else if (character.isStunned()==false && character.isVisiable()==true){
                boolean isTankAlive=false;
                int indexOfTank=0;
                boolean isFighterAlive=false;
                int indexOfFighter=0;
                boolean isHealerAlive=false;
                int indexOfHealer=0;
                for (int i=0;i<actionOrder.size();i++){
                    if (actionOrder.get(i).getType()==3&&actionOrder.get(i).isVisiable()==true){
                       isTankAlive = true;
                       indexOfTank = i;
                    }
                    if (actionOrder.get(i).getType()==1&&actionOrder.get(i).isVisiable()==true){
                        isFighterAlive=true;
                        indexOfFighter = i;
                    }
                    if (actionOrder.get(i).getType()==2&&actionOrder.get(i).isVisiable()==true){
                        isHealerAlive=true;
                        indexOfHealer=i;
                    }
                }
                if (isTankAlive==true){
                    System.out.println("Enemy is attacking Tank");
                    actionOrder.get(indexOfTank).takeDamage(character.attack());
                    actionOrder.get(indexOfTank).showInfo();
                    if (actionOrder.get(indexOfTank).getHP()<=0){
                        System.out.println("This character's is dead");
                        actionOrder.get(indexOfTank).setVisiable(false);
                    }
                }
                else if (isTankAlive==false&&isFighterAlive==true){
                    System.out.println("Enemy is attacking Fighter");
                    actionOrder.get(indexOfFighter).takeDamage(character.attack());
                    actionOrder.get(indexOfFighter).showInfo();
                    if (actionOrder.get(indexOfFighter).getHP()<=0){
                        System.out.println("This character's is dead");
                        actionOrder.get(indexOfFighter).setVisiable(false);
                    }
                }
                else if (isFighterAlive==false&&isFighterAlive==false&&isHealerAlive==true){
                    System.out.println("Enemy is attacking Healer");
                    actionOrder.get(indexOfHealer).takeDamage(character.attack());
                    actionOrder.get(indexOfHealer).showInfo();
                    if (actionOrder.get(indexOfHealer).getHP()<=0){
                        System.out.println("This character's is dead");
                        actionOrder.get(indexOfHealer).setVisiable(false);
                    }
                }
            }
        }
        if ((character.getType()==1||character.getType()==2||character.getType()==3)&&character.isVisiable()==true){
            System.out.println("\nHere what you can do:" +
                    "\n1-Attack" +
                    "\n2-Weapon's Speacial Move");
            int choice = input.nextInt();
            if (choice==1){
                int index = getIndexOfEnemy(actionOrder);
                actionOrder.get(index).takeDamage(character.attack());
                actionOrder.get(index).showInfo();
                if (actionOrder.get(index).getHP()<=0){
                    System.out.println("This character's is dead");
                    actionOrder.get(index).setVisiable(false);
                }
            }
            else if (choice==2){

                if (character.onHand[0].getType()==2){
                    int index = getIndexOfEnemy(actionOrder);
                    character.onHand[0].special(character,actionOrder.get(index));
                }
                else if (character.onHand[0].getType()==3){
                    int index = getIndexOfEnemy(actionOrder);
                    character.onHand[0].special(actionOrder.get(index),turn);
                }
                else if (character.onHand[0].getType()==1){
                    character.onHand[0].special(character);
                }
            }
        }
    }


    public static int getIndexOfEnemy(ArrayList<Character>actionOrder){
        Scanner input = new Scanner(System.in);
        System.out.println("Enemy list that you can attack:");
        for (int i = 0;i<actionOrder.size();i++){
            if (actionOrder.get(i).isVisiable()==true){
                System.out.println(i+"-"+actionOrder.get(i).getName());
            }

        }
        System.out.println("Please write number of Character that you want to have action on:");
        int choice = input.nextInt();
        return choice;
    }    

    }
    


