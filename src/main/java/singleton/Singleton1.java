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
    public String msg;
    private Singleton1(String msg){this.msg=msg;};
    private static Singleton1 instance=new Singleton1("测试");
    public static Singleton1 getInstance(){
        return instance;
    }
}
