package decorator;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 10:58 2020-04-14
 */
public class GreenGemStone extends GemStone {
    public GreenGemStone(Equipment equipment) {
        super(equipment);
    }

    @Override
    public int getAttack() {
        return 8+equipment.getAttack();
    }

    @Override
    public String getDesc() {
        return equipment.getDesc()+"+绿宝石";
    }
}
