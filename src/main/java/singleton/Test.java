package singleton;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

/**
 * @Author: tzy
 * @Description:
 * @Date: Create in 19:05 2020-04-01
 */
@Slf4j
public class Test {

    public static void main(String[] args)throws Exception {
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
//        for(int i=0;i<100;i++){
//            new Thread(()->{
//                System.out.println(Singleton3.getInstance());
//            }).start();
//        }

        //4. 双重校验锁
//        for(int i=0;i<100;i++){
//            new Thread(()->{
//                System.out.println(Singleton4.getInstance());
//            }).start();
//        }

        //6.枚举

//        for(int i=0;i<100;i++){
//            new Thread(()->{
//                System.out.println(Singleton6.getInstance());
//            }).start();
//        }

        //反射测试
//        Singleton5 singleton5A=Singleton5.getInstance();
//        Singleton5 singleton5B=Singleton5.getInstance();
//        System.out.println(singleton5A==singleton5B);
//        Constructor con=Class.forName("singleton.Singleton5").getDeclaredConstructor();
//        con.setAccessible(true);
//        Object obj=con.newInstance();
//        Singleton5 singleton5C=(Singleton5)obj;
//        System.out.println(singleton5A==singleton5C);

//        Singleton6 singleton6A=Singleton6.getInstance();
//        Singleton6 singleton6B=Singleton6.getInstance();
//        System.out.println(singleton6A==singleton6B);
//        Constructor con=Class.forName("singleton.Singleton6").getDeclaredConstructor(String.class,int.class);
//        con.setAccessible(true);
//        Object obj=con.newInstance();
//        Singleton6 singleton6C=(Singleton6)obj;
//        System.out.println(singleton6A==singleton6C);

    }
}
