package dong;

/**
 * Autor : dong
 * Time:2018/11/26
 */
//单例模式(饿汗式)
class Singletons {
    private static final Singletons SING = new Singletons();
    //无参构造器
    //构造方法私有化，外部无法产生新的实例化对象，只能通过static方法取得实例化对象
   private Singletons() {

    }
    //对于静态的私有的对象，通过他的getter方法来得到它的对象。
    public static Singletons getSingletons(){
       return SING;
    }

    public void print() {
        System.out.println("hello word");
    }
}
//懒汉式单例模式
class Singleton1{
    private static Singleton1 instance ;
    private Singleton1() { // private声明构造
    }
    public static Singleton1 getInstance() {
        if (instance==null) { // 表示此时还没有实例化
            instance = new Singleton1() ;
        }
        return instance ;
    }
    public void print() {
        System.out.println("Hello World");
    }
}
public class singleton {
    public static void main(String[] args) {
        Singletons sing = null;//声明对象
        sing = sing.getSingletons();
        sing.print();

        System.out.println();

        Singleton1 singleton = null;

        singleton = singleton.getInstance();
        singleton.print();
    }
}
