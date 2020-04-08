package observer;

import java.util.Observable;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 19:43 2020-04-07
 */
public class SubjectA extends Observable {
    private String message;

    public String getMessage(){return message;}

    public void setMessage(String message){
        this.message=message;
        setChanged();
        notifyObservers();
    }
}
