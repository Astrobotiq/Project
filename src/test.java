import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Character> Level = new ArrayList<>();
        ArrayList<Character> actionOrder = new ArrayList<>();
        Enemy enemy;
        int turn = 1;
        int enemyNumber = 2;
        int floorNumber = 1;

        /*Karakterler için kıyafet oluşturduğumuz kısım*/
        Light_Armor light_armor = new Light_Armor();
        Medium_Armor medium_armor = new Medium_Armor();
        Heavy_Armor heavy_armor = new Heavy_Armor();
        /*Karakterler için silah oluşturduğumuz kısım*/
        Long_Sword long_sword = new Long_Sword();
        Short_Sword short_sword = new Short_Sword();
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
        fighter.addWeapons(long_sword);
        healer.addWeapons(short_sword);
        tank.addWeapons(shield);
        Level.add(fighter);
        Level.add(healer);
        Level.add(tank);



        while(true){
            System.out.println("You are on dungeon "+floorNumber+"\n"+
                               "There are "+enemyNumber+" enemy in front of you.");
            for (int i = enemyNumber;i>0;i-- ){
                createEnemy(enemy=new Enemy(),Level);
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
            while (true){
                int sıra =0;
                
                if(sıra==actionOrder.size()){
                    sıra = 0;
                    turn += 1;
                }
                else sıra += 1;
            }

            break;
        }
    }
    public static void createEnemy(Enemy enemy,ArrayList<Character>Level){
        Level.add(enemy);
    }
}

