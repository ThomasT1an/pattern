package factory;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 17:07 2020-04-19
 */
public class Test {
    public static void main(String[] args) {
        Store store=new Store();
        ComputerFacotry computerFacotry=new MacBookFactory();
        Computer computer=computerFacotry.createComputer();
        OperatingSystem operatingSystem=computerFacotry.loadSystem();

        store.buy(computer);
        store.use(operatingSystem);
    }
}
