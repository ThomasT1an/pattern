package observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 14:10 2020-04-08
 */
public class ObserverA implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof SubjectA){
            System.out.println("接受到来自SubjectA的数据"+((SubjectA) o).getMessage());
        }
    }
}
