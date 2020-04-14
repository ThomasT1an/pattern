package decorator;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 10:58 2020-04-14
 */
public class Test {
    public static void main(String[] args) {
        Equipment sword=new Sword();
        sword=new GreenGemStone(new GreenGemStone(new RedGemStone(sword)));
        System.out.println(sword.getAttack()); //121
        System.out.println(sword.getDesc()); //剑+红宝石+绿宝石+绿宝石
    }
}
