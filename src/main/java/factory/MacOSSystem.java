package factory;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 18:46 2020-04-19
 */
public class MacOSSystem implements OperatingSystem {
    @Override
    public void getSystemName() {
        System.out.println("This is MacOsSystem");
    }
}
