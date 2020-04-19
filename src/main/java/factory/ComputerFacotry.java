package factory;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 17:08 2020-04-19
 */
public  interface ComputerFacotry {
     Computer createComputer();
     OperatingSystem loadSystem();
}
