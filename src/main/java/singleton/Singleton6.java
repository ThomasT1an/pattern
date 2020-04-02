package singleton;
import java.lang.Enum;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 15:29 2020-04-02
 */
public enum Singleton6 {
    INSTANCE;

    public static Singleton6 getInstance(){
        return INSTANCE;
    }
}
