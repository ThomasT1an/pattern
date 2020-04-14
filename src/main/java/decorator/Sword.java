package decorator;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 10:48 2020-04-14
 */
public class Sword implements Equipment {
    @Override
    public int getAttack() {
        return 100;
    }

    @Override
    public String getDesc() {
        return "剑";
    }
}
