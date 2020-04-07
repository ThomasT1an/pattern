package strategy;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 15:22 2020-04-03
 */
public class Test {
    public static void main(String[] args) {
        Character character=new Knight("骑士A");
        character.setWeapon(new Knife());
        character.attack();
        character.setWeapon(new Arrow());
        character.attack();
    }
}
