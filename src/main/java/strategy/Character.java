package strategy;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 15:41 2020-04-07
 */
public abstract class Character {
    String name;
    Weapon weapon;

    public void setWeapon(Weapon weapon){
        this.weapon=weapon;
    }

    public void attack(){
        //将攻击行为委托给武器
        weapon.attack();
    }
}
