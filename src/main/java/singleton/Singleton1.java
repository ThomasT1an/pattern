package singleton;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 19:03 2020-04-01
 */

/**
 * 饿汉式
 */
public class Singleton1 {
    private Singleton1(){};
    private static Singleton1 instance=new Singleton1();
    public static Singleton1 getInstance(){
        return instance;
    }
}
