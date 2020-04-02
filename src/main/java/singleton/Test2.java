package singleton;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 10:02 2020-04-02
 */
public class Test2 {
    public static void main(String[] args) {
        for(double t=1;t<=1000;t++){
            System.out.println("t:"+t+"    res:"+cal(t));
        }
    }

    private static Double cal(Double t){
        double temp=(-(5610-105*t+0.49*t*t)/(12*t));
        double e=Math.exp(temp);
        return 6.575*e/t;
    }
}
