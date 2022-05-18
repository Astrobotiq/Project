import java.util.ArrayList;

public interface Playable {
    Weapons[] onHand = new Weapons[1];
    Clothing[] onBody = new Clothing[1];

    default void addWeapons(Weapons weapons){
        onHand[0] = weapons;
    }
    default void addClothing(Clothing clothing){
        onBody[0] = clothing;
    }
}
