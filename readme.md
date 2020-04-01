# 1.单例模式

作用：

1.避免产生多个实例消耗资源

2.多个实例多次调用可能导致结果出错



场景：

只需要一个实例的对象，如各种Factory、Manager、线程池、配置文件等



设计思想：

1.构造函数私有化 防止使用者自行new对象

2.在类中new对象

3.提供一个允许外部访问的接口，以获取2中new的对象

## 1.1  饿汉式

```
/**
 * 饿汉式
 */
public class Singleton1 {
    private Singleton1(){};
    private static Singleton1 instance=new Singleton1();
    public static Singleton1 getInstance(){
        return instance;
    }
```

实现方式是在类加载的时候完成了new Singleton1()的过程，同样的写法还有将new语句放在静态代码块中，思想上是一致的。

其优点是实现简单 且线程安全

缺点是无论是否使用 在类初始化时对象都被创建出来了



## 1.2 懒汉式

```
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
```

这种实现在第一次被使用时才开始加在 理想中的情况是 if语句在第一次访问后就不再进入

但实际上当有两个线程几乎同时到达if(instance==null)时 当A线程进入if 却还没来得及执行instance=new Singleton2时 B线程也开始进行if判断 而此时由于A线程的instance还没有被new出来 那么B线程也进入if 执行new操作 此时就会出现两个实例 若想还原这种情况可以在new语句前加上sleep语句



## 1.3 线程安全的懒汉式

为解决1.2中线程不安全的问题 可以通过加锁的方法来避免多个线程同时进入if语句

```
public class Singleton3 {
    private Singleton3(){};
    private static Singleton3 instance;

    public static synchronized Singleton3 getInstance(){
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
```

也可以把锁加在方法内

```
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
```

但是如果锁再往下移动一行

```
public static Singleton3 getInstance(){
        if(instance==null) {
            synchronized (Singleton3.class) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }
                instance = new Singleton3();
            }
        }
        return instance;
}
```

是无法保证线程安全的，这是由于若某个线程A和B同时进入if后，A拿到了锁，执行了new语句后再释放锁，此时B又拿到了锁 那么对象就会被new两次





