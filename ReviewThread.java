package xiaodong;

/**
 * Author : dong
 * Time:2019/7/29
 */
public class ReviewThread {
    /**
     * 进程：操作系统中的一个程序的执行周期
     * 创建---->就绪-----.>运行------>结束
     * 线程：
     * 区别：没有进程就没有线程，进程一旦终止，其内的线程也将不复存在。多进程与多线程区别：本质区别在于，每个进程拥有自己的一整套变量，而线程则共享数据。共享变量使得线程之间的通信比进程之间通信更有效、更方便。
     * 1.java中的多线程实现方式：
     *     1)
     *     2)
     *     3)
     * 2.多线程常用的操作方法：
     *    a.sleep()：线程休眠：运行态--->阻塞态，不会释放锁，立即交出CPU
     *    b.yield()： 线程让步，运行态---->就绪态，不会释放对象锁，交出CPU时间不确定，由系统调度
     *       只会让拥有相同时间优先级的线程有获取CPU的机会。
     *    c.join()：   当前线程等待另一线程执行完毕后再恢复执行，运行态--->阻塞态，会释放对象锁
     *
     *    d.多线程的等待与唤醒机制
     *        wait()/notify():与synchronized关键字配合使用
     *        要使用wait()/notify()，必须在同步方法或同步代码快中使用
     *    e.wait()：运行态----->阻塞态
     *    f.notify()：阻塞态---->就绪态
     *    g.线程：
     *        java中的线程只有两类：用户线程和守护线程
     *       创建的线程默认都是用户线程，包括主线程
     *       守护线程：后台线程，只有当当前的JVM进程中最后一个用户线程终止，守护线程会对着JVM一同停止（GC线程就是典型的守护线程）
     *        GCDeamn将用户线程置为守护线程，将他置为true
     *
     *
     *
     * Object及其子类的每个对象都有两个队列
     * 同步队列：获取对象锁失败的线程进入同步队列，假如只有一个线程获取锁成功，则其他的进入同步队列。
     * 等待队列：已经获取到锁，调用wait()进入阻塞状态的线程进入等待队列（等待notify()）；等待队列中的线程被notify()（唤醒此队列）之后又会进入同步队
     *
     *
     * 3.同步(保护对象是谁？锁是谁？)
     * jvm  ：内存模型(JMM)：并发程序
     *   描述（类成员变量，静态变量）如何存储
     *
     * 工作内存：变量在线程中的操作（读写）必须在工作内存中进行
     *                   工作内存中保存了所有变量的副本
     *
     * 主内存：所有变量必须在主内存中存储
     *
     * 原子性：一组操作要么同时发生，要么一个都不发生
     * 保证原子性：
     *       a.基本数据类型的读写操作都属于原子性操作。（int i = 20  ；i = 10；i++不是原子性操作）
     *       b.
     * 可见性：某一线程对于变量的修改对于其他线程而言是立即可见的
     * 保证可见性的关键字（Synchronized(Lock)..final..volatile）普通线程不具备可见性
     *
     * 有序性：在单线程场景下，所有代码执行顺序就是我们代码的书写顺序，在多线程场景下，所有代码都是乱序的。
     * 线程安全指的是以上三个特性同时满足
     *
     * 如何解决同步？
     * 1.使用Synchronized关键字解决同步问题
     *     a.同步代码快
     *       synchronized(对象----任意类对象或者类.class对象(反射对象只有一个)) == synchronized(对象)
     *     b.同步方法
     *       synchronized修饰成员方法  锁的是当前对象this
     *                             修饰类方法(static)  锁的是当前类的反射对象（类.class）
     *      当一个锁锁一个对象时，读读互斥
     *      当多个锁锁多个对象时，是异步的
     * 2.synchronized的底层实现；对象Monitor机制
     *    加锁：monitorenter  +1
     *    减锁：monitorexit    -1
     *    任意时刻只有当Monitor值为0表示为无锁状态
     *    任意Object及其子类对象内部在JVM中都附加Monitor,获取一个对象的锁，实际上就是获取该对象的Monitor（计数器）
     *    当一个线程尝试获取对象的Monitor时，
     *          a.若此时的Monitor值为0，该对象未被任何线程获取，当前线程获取Monitor，将持有线程置为当前线程，Monitor+1；
     *          b.若此时的Monitor值不为0，此时该Monitor已被线程持有
     *             1)若当前线程恰好是持有线程，Monitor值再次被 +1 ，当前线程继续进入同步块（锁的可重入）
     *             2)若持有线程不是当前线程，当前线程进入同步队列等待Monitor值减少为0
     * javap  -v
     *   3.JDK1.6之后，synchronized的优化
     *       CAS：Compare  and  Swap  无锁保证安全：无锁操作是使用CAS(compare and swap)又叫做比较交换来鉴别线程是否出现冲突，出现冲突就重试当前操作直到没有冲突为止。
     *       CAS(O,V,N)
     *             V：主内存存放的实际变量值
     *             O：当前线程认为的变量值
     *             N：希望将变量替换的值
     *             cas(o,v,n)    o == v  认为此时没有线程修改主内存的值，成功将N值替换回主内存
     *                                 o != v  此时已有线程修改变量的值，替换失败，返回主内存最新值，再次重试
     *         CAS中ABA问题：添加版本号
     *             num = 0；
     *             线程1   cas(0,0,1)    1 --> 主内存   版本1
     *             线程2   cas(1,1,0)     0 -->主内存   版本2
     *             线程3   cas(0,0,5)     5 -->主内存  版本3
     *          synchtonized优化：
     *             偏向锁    -->   轻量级锁  --->  重量级锁（JDK1.6之前，synchronized就是重量级锁）
     *             重量级锁(悲观锁)：获取Monitor失败的线程进入同步队列，状态置为阻塞态
     *             偏向锁(乐观锁)：认为只有一个线程在来回进入同步块，直接将加锁和解锁的过程省略，每次进入同步块之前只是判断一下同步块线程是否是当前线程。
     *
     *             轻量级锁：不同时刻有不同的线程进入同步块，每次线程在进入同步块时都需要加锁与解锁，不同时刻的线程都能进去。
     *             重量级锁：同一时刻有不同的线程进入代码块，只有一个线程能正确进入
     *             总结：随着竞争的不断升级，锁也会不断升级，锁不会降级。
     *             自适应自旋(重量级锁的优化)：获取锁失败的线程不会立即阻塞，而是在CPU空跑一段无用代码，若在此时间段成功获取锁，则下次再获取锁失败时，空跑时间适当延长；否则下次空跑时间缩短
     *             总结:Java虚拟机中synchronized关键字的实现，按照代价由高到低可以分为重量级锁、轻量锁和偏向锁三种。
     *            1. 重量级锁会阻塞、唤醒请求加锁的线程。它针对的是多个线程同时竞争同一把锁的情况。JVM采用了自适应自旋，来避免线程在面对非常小的synchronized代码块时，仍会被阻塞、唤醒的情况。
     *             2. 轻量级锁采用CAS操作，将锁对象的标记字段替换为一个指针，指向当前线程栈上的一块空间，存储着锁对象原本的标记字段。它针对的是多个线程在不同时间段申请同一把锁的情况。
     *             3. 偏向锁只会在第一次请求时采用CAS操作，在锁对象的标记字段中记录下当前线程的址。在之后的运行过程中，持有该偏向锁的线程的加锁操作将直接返回。它针对的是锁仅会被同一线程持有的情况。
     *
     *
     *               锁的粗化：将多次的加减锁过程粗化为一次大的加减锁过程，减少无用的加减锁过程，提高
     * 效率。
     *                public class Test{
     *                    private static StringBuffer sb = new StringBuffer();
     *                    public static void main(String[] args) {
     *                           sb.append("a");
     *                           sb.append("b");
     *                           sb.append("c");
     *                     }
     *                 }
     *               锁的消除：当变量为线程私有变量时，将原先方法上的synchronized消除掉
     *               public class Test{
     *                    public static void main(String[] args) {
     *                          StringBuffer sb = new StringBuffer();
     *                          sb.append("a").append("b").append("c");
     *                    }
     *                }
     *                产生死锁的四个条件：
     *                1.互斥：资源X在任意一个时刻只能被一个线程持有
     *                2.占有且等待：线程1占有资源X的同时等待资源Y，并不释放X
     *                3.不可抢占：资源X一旦被线程一占有，其他线程不能抢占X
     *                4.循环等待：线程1持有X，等待Y；线程2持有Y，等待X；
     *                如何解决死锁？
     *
     *  4.JDK1.5 Lock体系
     *       1.使用格式
     *          try {
     *               //同步代码块
     *               //显示加锁
     *               lock.lock();
     *          }catch(){
     *          }finally{
     *               //显示解锁
     *               lock.unlock();
     *          }
     *      2.常用方法
     *         lock()：加锁，语义与synchronized完全一致
     *         unlock()：解锁
     *         void lockInterruptibly() throws InterruptedException;：相应响应中断加锁。（）
     *         boolean  tryLock();非阻塞式获取锁，获取锁成功返回true，进入同步块；获取锁失败返回false，线程继续执行其他代码。(破坏占有且等待条件)
     *         boolean  tryLock(long time,TimeUnit  unit)  throws InterruptedException;支持超时
     *       3.synchronized与ReentrantLock的关系与区别
     *          共同点：
     *          a.都属于独占锁的实现，任意一个时刻只有一个线程能获取到资源。
     *          b.都支持可重入锁。
     *          不同点：
     *          a.synchronized是一个关键字，JVM层面实现；ReentrantLock是java语言层面实现的“管程”
     *          b.ReentrantLock具备一些synchronized不具备的功能。
     *              1）响应中断，非阻塞式获取锁，支持超时获取锁，支持公平锁（ReentrantLock）
     *               公平锁：等待时间最长的线程最先获取到锁。
     *
     *
     * Lock接口的独有方法测试（破坏死锁条件）
     * ReentrantLock可重入特性测试
     */
}
