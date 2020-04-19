package factory;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 18:09 2020-04-19
 */
public class MacBookFactory implements ComputerFacotry {
    @Override
    public Computer createComputer() {
        return new MacBookComputer();
    }

    @Override
    public OperatingSystem loadSystem() {
        return new MacOSSystem();
    }
}
