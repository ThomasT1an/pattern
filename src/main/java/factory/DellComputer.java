package factory;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 17:05 2020-04-19
 */
public class DellComputer implements Computer{

    @Override
    public void describeComputer() {
        System.out.println("This is a dell");
    }
}
