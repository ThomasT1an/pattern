package factory;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 17:05 2020-04-19
 */
public class MacBookComputer implements Computer {
    @Override
    public void describeComputer() {
        System.out.println("This is a macbook");
    }
}
