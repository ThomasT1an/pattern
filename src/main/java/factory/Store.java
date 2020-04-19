package factory;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 16:44 2020-04-19
 */
public class Store {
    public void buy(Computer computer){
        computer.describeComputer();
    }

    public void use(OperatingSystem operatingSystem){
        operatingSystem.getSystemName();
    }
}
