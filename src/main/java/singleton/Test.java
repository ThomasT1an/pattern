package singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 19:05 2020-04-01
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        //1.饿汉式
//        Singleton1 singleton1A=Singleton1.getInstance();
//        Singleton1 singleton1B=Singleton1.getInstance();
//        log.info(singleton1A.toString());
//        log.info(singleton1B.toString());

        //2.懒汉式
//        for(int i=0;i<100;i++){
//            new Thread(()->{
//                System.out.println(Singleton2.getInstance());
//            }).start();
//        }

        //3.线程安全懒汉式
        //2.懒汉式
        for(int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Singleton3.getInstance());
            }).start();
        }


    }
}
