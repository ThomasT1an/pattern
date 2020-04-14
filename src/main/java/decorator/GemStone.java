package decorator;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 10:53 2020-04-14
 */
public abstract class GemStone implements Equipment{
    protected Equipment equipment;

    public GemStone(Equipment equipment){
        this.equipment=equipment;
    }

    public abstract int getAttack();

    public abstract String getDesc();
}
