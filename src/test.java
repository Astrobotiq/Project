import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Character> Level = new ArrayList<>();
        Enemy enemy;
        int enemyNumber = 4;
        int floorNumber = 2;

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

            for (int i=0;i<Level.size();i++){
                Level.get(i).showInfo();
            }

            break;
        }
    }

    public static void createEnemy(Enemy enemy,ArrayList<Character>Level){
        Level.add(enemy);
    }
}
