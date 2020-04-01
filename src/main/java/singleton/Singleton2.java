package singleton;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 19:35 2020-04-01
 */

/**
 * 懒汉式
 */
public class Singleton2 {
    private Singleton2(){};
    private static Singleton2 instance;

    public static Singleton2 getInstance(){
        if(instance==null)
            instance=new Singleton2();
        return instance;
    }
}
