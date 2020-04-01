package singleton;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 19:48 3030-04-01
 */

/**
 * 线程安全的懒汉式
 */
public class Singleton3 {
    private Singleton3(){};
    private static Singleton3 instance;

    public static Singleton3 getInstance(){
        synchronized(Singleton3.class){
            if(instance==null){
                try{
                    Thread.sleep(10);
                }
                catch (Exception e){}
                instance=new Singleton3();
            }
            return instance;
        }
    }
}
