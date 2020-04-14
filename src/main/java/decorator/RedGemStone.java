package decorator;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 10:55 2020-04-14
 */
public class RedGemStone extends GemStone {
    public RedGemStone(Equipment equipment) {
        super(equipment);
    }

    @Override
    public int getAttack() {
        return 5+equipment.getAttack();
    }

    @Override
    public String getDesc() {
        return equipment.getDesc()+"+红宝石";
    }
}
