package singleton;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 15:22 2020-04-02
 */
public class Singleton5 {
    private Singleton5(){};
    private static class Singleton5Holder{
        private static final Singleton5 instance=new Singleton5();
    }
    public static Singleton5 getInstance(){
        return Singleton5Holder.instance;
    }
}
