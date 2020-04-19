package factory;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 18:47 2020-04-19
 */
public class WindowsSystem implements OperatingSystem {
    @Override
    public void getSystemName() {
        System.out.println("This is windows System");
    }
}
