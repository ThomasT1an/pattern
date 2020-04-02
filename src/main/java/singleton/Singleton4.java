package singleton;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 14:45 2020-04-02
 */
public class Singleton4 {
    private Singleton4(){};
    private static volatile Singleton4 instance;

    public static Singleton4 getInstance(){
        if(instance==null){
            synchronized (Singleton4.class){
                if(instance==null)
                    instance=new Singleton4();
            }
        }
        return instance;
    }
}
