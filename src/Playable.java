import java.util.ArrayList;

public interface Playable {


    default void addWeapons(Weapons weapons){
        onHand[0] = weapons;
    }
    default void addClothing(Clothing clothing){
        onBody[0] = clothing;
    }
}
