package xiaodong;

/**
 * Author : dong
 * Time:2019/8/4
 */
public class Main1 {
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
     *              1）响应中断，非阻塞式获取锁，支持超时获取锁，支持公平锁（ReentrantLock）,支持多个等待队列。
     *               公平锁：等待时间最长的线程最先获取到锁。
     *         4.等待与唤醒机制（线程间的通信方式之一）
     *           1.   wait/notify：synchronized
     *            调用notify后：将等待队列中的线程唤醒置于同步队列之中的末尾排队获取锁。
     *            notify线程直到将自己的同步代码快执行完毕后才会释放锁。
     *            任意一个对象（Monitor）有一个同步对队列和一个等待队列（生产。消费者wait都进入一个等待队列）
     *           问题： 只有一个等待队列时，唤醒所有线程一定会造成不该唤醒的线程又被唤醒然后阻塞，造成性能开销。
     *            notifyAll() ---->所有线程唤醒（包含了消费者）
     *            2.ReentrantLock
     *            await/signal：Lock
     *            Condition:等待队列模型
     *            任意一个Lock对象有一个同步队列和多个等待队列（Lock.condition()）
     * 作业：使用Lock+Condition重写生产者消费者模型
     *        5.Lock体系下的另一个子类：ReentrantReadWriteLock（可重入锁）
     *              复习：
     *                    独占锁：任意时刻只有一个线程能够获取到锁
     *                    共享锁：任意时刻多个线程可以获取到锁
     *                    读写锁：共享单车     应用：（线程安全缓存实现）
     *                         读锁：共享锁，读线程与读线程异步，同时获取到锁
     *                         写锁：写线程与写线程互斥，只有一个写者可以获取到锁
     *                         读写互斥   写写互斥
     *                    缓存：Map实现：
     *                     public class ThreadSafeCache {
     *                        private Map<String,String> map = new HashMap<>();
     *                        private ReentrantReadWriteLock reentrantReadWriteLock
     *                                = new ReentrantReadWriteLock();
     *
     *                        public String getValue(String key) {
     *                                 reentrantReadWriteLock.readLock();
     *                                 return map.get(key);
     *                        }
     *
     *                        public void setValue(String key,String value) {
     *                                reentrantReadWriteLock.writeLock();
     *                                 map.put(key,value);
     *                       }
     *
     *               }
     *
     * 5.线程池：
     *    为什么采用线程池？
     *    1. 降低资源消耗:通过重复利用已创建的线程降低线程创建和销毁带来的消耗。
     *    2. 提高响应速度:当任务到达时，任务可以不需要等待线程创建就能立即执行。
     *    3. 提高线程的可管理性:使用线程池可以统一进行线程分配、调度和监控。
     *     ExecutorService：普通调度池核心接口
     *              ---submit(Runnable || Callable  :   Future<v>)
     *              ---execute(Runnable) : void
     *     ScheduledExecutorService：定时调度池（执行定时任务）
     *     ThreadPoolExecutor：线程池核心实现类
     *      Executors：线程池工具类
     *     1.线程池的工作流程：
     *                     核心线程池corePoolSize
     *                     阻塞队列BlockingQueue
     *                     最大线程池maximumPoolSize
     *                     拒绝策略rejectHandler
     *             a.若核心池未满，则创建新的线程执行任务而后将此线程入线程池，若核心池满且有空闲线程，调度空闲线程执行任务
     *             b.将任务置入阻塞队列，排队等待空闲线程调度（juc）
     *                             ----ArrayBlockingQueue：基于数组的有界阻塞队列
     *                             ----LinkedBlockingQueue：基于链表的无界阻塞队列
     *                             ----SynchrousQueue：不存储元素的无界阻塞队列
     *             c.当阻塞队列满时，若此时最大线程池未满，创建新的线程执行任务而后置入最大线程池中
     *             d.若最大线程池已满，调用相应拒绝策略处理任务（默认为抛出异常且不处理任务）
     *      2.手工创建线程池  new  ThreadPoolExecutor（）
     *          public ThreadPoolExecutor(int corePoolSize,
     *                                                      int maximumPoolSize,
     *                                                      long keepAliveTime,
     *                                                      TimeUnit unit,
     *                                                      BlockingQueue<Runnable> workQueue,
     *                                                      RejectedExecutionHandler handler)
     *         FutureTask  保证多线程下任务只被执行一次
     *         Future  get() 会阻塞当前线程直到取得Callable的返回值
     *       3.JDK内置四大线程池
     *          1.固定大小线程池：LinkedBlockingQueue    实际return  new  ThreadPoolExecutor(nThreads,nThreads,...)；
     *             应用场景：当服务器负载较重时，限制线程的数量，可以采用固定大小的线程池
     *          2.单线程池：newSingleThreadExecutor   实际是return new  ThreadPoolexecutor(1,1,....);
     *             应用场景：某些同步处理的场合（任务需要按序处理）
     *          3.缓存线程池：newCachedThreadPool  实际 return new ThreadPoolExecutor（）；
     *             synchrousQueue：，核心池为0，不存储元素
     *             入队和出队必须同时调用。
     *             提交任务速度>执任务的速度：不断创建新的线程，有可能将内存写满
     *             提交任务速度<执任务的速度：缓存线程池中只有几个固定的线程来处理任务。
     *             应用场景：使适用于负载较轻的服务器，适用于很多短期的小任务。
     *          4.定时调度池：newScheduledYhreadPool
     *             应用场景：需要执行定时任务的场合。
     *       总结：工作流程   ThreadPoolExecutor参数会配置（自定义线程池） 四大内置线程池的使用场景
     *
     * 6.juc   四大并发工具类
     *        1.juc.CountDownLatch    闭锁
     *           应用场景：一个线程等待一组线程执行完毕后执行
     *                             await()：等待其他线程执行完毕
     *                             countDown()：被等待线程执行完毕后将计数器的值  --1（判断一组线程执行完毕）
     *                             当CountDownLatch值减少为0时无法恢复
     *        2.juc.CyclicBarrier   循环栅栏
     *            一组线程同时到达临界点后再同时恢复执行（先到达临界点的线程会阻塞，直到所有线程都到达临界点）
     *            public CyclicBarrier(int parties , Runnable  barrierAction)当多个线程同时到达临界点是，随机挑选一个线程执行barrierAction后再同时恢复执行
     *            计数器的值可以恢复    reset()
     *            应用：多线程向磁盘写数据
     *        3.juc.Exchanger  线程交换器
     *            用于两个线程之间的数据交换，当Exchanger只有一个线程时，该线程会阻塞直到有别的线程调用exchanger进入缓冲区，当前线程与新线程交换数据后同时恢复执行。
     *         4.juc.Semaphore  信号量
     *             acquire()：尝试占用一个信号量，失败的线程会阻塞直到有新的信号量。
     *             release()：释放一个信号量
     *             acquire(int  n)：尝试占用n信号量，失败的线程会阻塞直到有新的信号量。
     *             release(int  n)：释放n个信号量
     *
     * 7.JVM
     *    1.JVM运行时区域划分
     *        线程私有：
     *                        程序计数器
     *                        虚拟机栈
     *                        本地方法栈
     *                        HotSpotJVM中本地方法栈与虚拟机栈合二为一。
     *        线程共享：
     *                        堆（GC堆）：存放所有对象实例以及数组对象。
     *                        方法区：存放已加载的类信息、常量、静态变量。
     *                        运行时常量池（方法区的一部分）：存放字面量与符号引用。
     *                        字面量：10  “abc”  10.1   final修饰的变量
     *                        符号引用：类和结构的完全限定名、字段的名称和描述符、方法的名称和描述符。
     *    2.GC相关：
     *      a. 如何判断对象是否存活
     *       引用计数法：无法解决引用循环问题（我中有你，你中有我），导致无用对象仍然判断存回而无法回收
     *                          循环引用：会产生内存泄漏
     *       可达性分析算法（java）：可以作为GC Roots：1. 虚拟机栈(栈帧中的本地变量表)中引用的对象
     *                                                                                  2. 方法区中类静态属性引用的对象
     *                                                                                  3. 方法区中常量引用的对象
     *                                                                                  4. 本地方法栈中JNI(Native方法)引用的对象
     *     （面试*****）JDK1.2之后关于引用的扩充
     *     强引用：程序中普遍存在的，类似于直接new称为强引用
     *                   生命周期：对象被任意一个强引用指向，即便抛出OOM异常，也无法回收被强引用指向的对象。
     *     软引用：描述有用但不是必须要的引用（缓存），JDK1.2之后用SoftReference类实现软引用。
     *                   生命周期：若对象只被软引用指向，当前内存够用时不回收，当即将抛出OOM异常时，一次性回收所有仅被软引用指向的对象。
     *     弱引用：在JDK1.2之后提供了WeakReference类来实现弱引用。
     *                   生命周期：被弱引用关联的对象只能生存到下一次垃圾回收发生之前。当垃圾回收器开始进行工作时，无论当前内容是否够用，都会回收掉只被弱引用关联的对象。
     *     虚引用：虚引用也被称为幽灵引用或者幻影引用。一个对象是否有虚引用的存在，完全不会对其生存时间构成影响，也无法通过虚引用来取得一个对象实例。为一个对象设置虚引用的唯一目的就是能在这个对象被收集器回收时收到一个(来自JVM)系统通知。在JDK1.2之后，提供了PhantomReference类来实现虚引用。
     *     b.对象的自我拯救finalize
     *          a.若对象所在的类覆写了finzalize()JDK1.9不用了
     *               该对象的finalize()未被JVM调用，JVM会调用此对象的finalize()
     *               该对象的finalize() 被JVM调用过时，此对象被标记为不在存活，可以GC
     *     c.垃圾回收算法
     *                将堆空间分为新生代和老年代，对象默认产生在新生代
     *                新生代对象朝生夕死，新生代对象存活率很低（<=2%）
     *
     *                java采用分代回收算法：新生代采用复制算法，老年代使用标记--整理算法
     *         为何老年代不采用复制算法？（新生代算法快老年代10倍以上。）
     *               老年代对象的存活率非常高，若采用复制算法，复制效率远高于新生代，不适合。
     *    3.JDK内置工具的使用
     *        jps   jmap   jstack
     *    4.JMM
     *       volatile关键字禁止指令重排序有两层意思：
     *             1）当程序执行到volatile变量的读操作或者写操作时，在其前面的操作的更改肯定全部已经 行，且结果已经对后面的操作可见；在其后面的操作肯定还没有进行；
     *             2）在进行指令优化时，不能将在对volatile变量访问的语句放在其后面执行，也不能把volatile变量后面的语句放到其前面执行。
     *
     *
     *
     *
     *
     * 
     */
}
