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

但是这种方法带来的后果就是效率太低，所有对getInstance方法的调用，试图获取对象实例，都需要等待锁释放

也可以把锁加在方法内 但是这样和加在方法上是一样的 核心问题是if(instance==null)这句如果被上锁 那么就会导致所有调用getInstance方法都需要等待锁

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

但是如果锁再往下移动一行 看似是保证了只有最初的一次请求会加锁

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

但是这样是无法保证线程安全的，这是由于若某个线程A和B同时进入if后，A拿到了锁，执行了new语句后再释放锁，此时B又拿到了锁 那么对象就会被new两次



## 1.4 双重校验锁

```
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
```

通过两次if判断，在保证new语句只被执行一次的情况下改善了1.3带来的效率问题

在这种方法中，只有getInstance语句第一次被调用时，调用者才需要等待锁资源

**volatile关键字是必须的**

并不是说不加volatile就会导致可能有多个实例产生

而是在实例化过程中分为三个指令步骤

1.分配内存空间

2.调用构造方法 进行初始化

3.将对象赋值给变量

这几个步骤有可能会被JVM进行指令重排优化 2和3步骤都依赖1步骤 所以1一定是最先执行的 但是2和3的顺序可能颠倒

如果先进行了1后 直接进行了3 那么此时变量并不为null 也就是说他是不会进入外层的if(instance==null)的

而这时候这个对象实际上是不完整的 因为他并没有进行2步骤的初始化过程 就可能会被直接return回去 这个被return回去的对象就是一个异常的对象

所以加上volatile关键字 可以避免指令重排的发生



## 1.5 静态内部类

```
public class Singleton5 {
    private Singleton5(){};
    private static class Singleton5Holder{
        private static final Singleton5 instance=new Singleton5();
    }
    public static Singleton5 getInstance(){
        return Singleton5Holder.instance;
    }
}
```

这种方式与1.1的饿汉式相似 区别在于1.1在Singleton类被装载时 对象就会实例化

而这种方式中的holder类在Singleton类被装载时不会被装载，对象不会直接被实例化，而是在getInstance方法被调用时holder类被装载，对象进行实例化，

JVM来保证了线程的安全性，类加载只会加载一次，holder只会被加载一次，也就保证了new语句只执行一次



## 1.6 枚举实现

```
public enum Singleton6 {
    INSTANCE;

    public static Singleton6 getInstance(){
        return INSTANCE;
    }
}
```

不添加getInstance方法直接使用Singleton.INSTANCE也可以

枚举实现可以防止通过反射的方式强行调用私有的构造器

在前五个类中都可以通过以下方式实现

```
//        Singleton5 singleton5A=Singleton5.getInstance();
//        Singleton5 singleton5B=Singleton5.getInstance();
//        System.out.println(singleton5A==singleton5B);
//        Constructor con=Class.forName("singleton.Singleton5").getDeclaredConstructor();
//        con.setAccessible(true);
//        Object obj=con.newInstance();
//        Singleton5 singleton5C=(Singleton5)obj;
//        System.out.println(singleton5A==singleton5C);
```

通过getDeclaredConstructor()方法获取构造器后setAccessible(true);

调用即可

但是用这种方式测试枚举单例时会报错：

Exception in thread "main" java.lang.NoSuchMethodException: singleton.Singleton6.<init>()
	at java.lang.Class.getConstructor0(Class.java:3082)
	at java.lang.Class.getDeclaredConstructor(Class.java:2178)



这是因为并没有找到无参的构造器

通过Constructor[] cons=Class.forName("singleton.Singleton6").getDeclaredConstructors();

获取枚举单例的构造器发现：

![image-20200402172116896](image-20200402172116896.png)

只有一个(String,int)类型的构造器

查看Enum源码可以找到这个构造器：

![image-20200402172431030](image-20200402172431030.png)

直接指定这个构造器

```
Constructor con=Class.forName("singleton.Singleton6").getDeclaredConstructor(String.class,int.class);
```

仍然报错java.lang.IllegalArgumentException: Cannot reflectively create enum objects

翻译过来很明显就是不能用反射的方式创建一个枚举对象

在Constructor类的newInstance方法中抛出了这个异常

![image-20200402172919454](image-20200402172919454.png)

同时可以避免序列化问题