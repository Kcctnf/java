package xiaodong;

/**
 * Author : dong
 * Time:2019/7/26
 */

/**
 *
 *
 * 1.字符串拼接时，只有纯常量的拼接不会转为StringBuilder
 * 直接在常量池中寻找是否存在已有值。否则，都变为StringBuilder
 * 2.异常体系中，若finally中有return语句，则直接返回finally中的return语句
 *   若finallly中没有return语句，try和catch中有return语句，则try和catch先暂存代码中的值
 *    然后执行finall代码块，最后返回存值
 * 复习：
 *   类集：
 *   (一)LinkedList  ‘’ ArrayList   Vector关系与区别
 *       a.都是List接口下的常用子类，其中ArrayList和Vector基于数组实现  LiskedList是基于双向链表实现
 *       b.ArrayList采用懒加载策略，在第一次添加(add())元素是进行初始化内部数组
 *         初始化内部数组为10,ArrayList在产生对象是扩容为原来的1.5倍，采用异步处理，线程不安全
 *         性能较高
 *         使用场景：大部分场合使用t
 *       c.Vector在产生对象时初始化大小为10的内部数组，Vector扩容为原来数组的2倍
 *         Vector采用synchronized修饰（加锁了）常用的增删改查方法，线程安全，性能较低（读读互斥）
 *       d.在任意位置的插入与删除会考虑使用LinkedList，它是Queue接口的子类
 *
 *
 *
 *   (二)请问了解jcl fail—fast策略？fail—safe
 *
 *       什么是fail-fast策略？
 *       优先考虑出现异常的场景，当异常产生时，将错误扔出去，程序终止，快速报错是指当有其他线          程对一个容器进行了结构性修改，所谓结构性修改是对原容器的size造成影响的操作，add，remove
 *
 *       为何产生fail-fast?
 *       modCount != expectedModCount
 *       modCount存在于AbstrsctList中记录List集合被修改的次数
 *       expectedModCount存在于内部迭代器实现，存储当前集合被修改的次数
 *       所谓结构性
 *
 *       fail-fast意义？
 *       保证多线程场景下不产生"脏读"
 *
 *       fail-safe？
 *       不抛出ConcurrentModificationExceotion的集合称为fail-safe集合
 *       juc包下线程安全的集合类()
 *   (三)Set接口与Map接口的关系
 *       Set是Map的小马甲，实际上内部就是一个Map集合，Set保存单个元素存储在Map的Key
 *       Set不容许数据重复
 *        HashSet判断两个对象是否重复：equals与hashCode
 *        元素要想保存到TreeSet中，要么元素本身所在类实现Comparable，要么通过外部传入一个比较器（外部排序）
 *   (四)hashCode与equals的关系
 *        hashCode：取得任意一个对象的哈希码
 *        equals：比较两个对象是否相等
 *         a.hashCode返回值相等的两个对象，equals是否相等—equals是不一定相等的(x与f(x)的关系)
 *         b.equals返回值相等的两个对象，hashCode是否相等——hashCode一定相等
 *   (五)java实现大小比较的方式（内部排序，外部排序）----两个对象间
 *        1. 内部排序(自己与别人比)：Comparable----实现了Comparable接口的子类，表示本类具备天然的可比较特性
 *          返回一个int  compareTo(Object  o)
 *           >0     本身大于目标对象
 *           =0     本身等于目标对象
 *           <0     本身小于目标对象
 *        2. 外部排序：Comparator（推荐使用外部比较器）
 *            类本身不具备可比较特性，专门有一个类比较该类的大小（比较器）
 *            策略模式（对原先类没有影响，根据不同的 方法来比较）
 *          总结：当一个类本身可比较，但是还给它实现了外部比较，它会优先考虑使用外部排序
 *   (六)HashMap TreeMap  HashTable的关系与区别
 *         a.这三个类都是我们Map接口下的常用子类，HashTable基于哈希表实现，TreeMap基于红黑树实现，HashMap基于哈希表 + 红黑树（JDK1.8之后，JDK1.8基于哈希表）
 *         b.关于null
 *            HashMap  允许key,value都为null
 *            HashTable   key与value都不允许为null
 *            TreeMap   只允许value为null
 *         c.线程安全性
 *            HashMap与TreeMap采用异步处理，线程不安全，性能较高
 *            HashTable使用Synchronize同步方法，线程安全，性能较低（锁的是整张哈希表，读读互斥）
 *          哈希表（k,v）：数组
 *             哈希表（散列表）： 根据相应的哈希算法计算key，返回值即为v存储的数组下标
 *             哈希算法：  % 16  会出现哈希冲突 ：eg:1 % 16与17 % 16
 *             解决方法：(1)  开放定址法：寻找下一个为Null的数组下标。而后将冲突元素储存
 *                               (2)  在散列法：再次使用一个不同的哈希算法再次计算一次
 *                               (3)  链地址法（拉链法）：将所有冲突元素按照链表存储。链在第一个数的后边
 *   (七)HashMap的源码解析（负载因子  树化策略 内部Hash实现  resize策略。。。）
 *         a.内部属性：
 *            负载因子：final  float loadFactory(默认为0.75f)
 *                 负载因子过大会导致哈希冲突明显增加，但是节省内存。
 *                 负载因子过小会导致哈希表频繁扩容，内存利用率低。
 *            实际容量：int   threshold = loadFactory * tab.length;
 *            树化阈值：int   TREEIFY_THRESHOLOD = 8
 *            解除树化阈值：int    UNTREEIFY_THRESHOLD = 6
 *            HashMap也采用懒加载策略，第一次put时初始化哈希表。
 *            树化逻辑：索引下标对应的链表长度达到阈值8并且当前哈希表长度达到64才会树化，否则只是调用resize()方法进行哈希表扩容。
 *            resize();扩容为原来的2倍
 *
 *            为何JDK1.8引入红黑树？
 *                  当链表长度过长时，会将哈希表查找的时间复杂度退化为O(n)
 *                  树化保证即使在哈希冲突严重时，也能保证时间复杂度在O(log(n))
 *                  当红黑树节点个数在扩容或删除元素时减少为6以下，在下次resize过程中会将红黑树退化为链表，节省空间。
 *
 *            1.HashMap内部的hash
 *            2.put的内部逻辑
 *               a.哈希索引下标计算：i = (n - 1) & hash-->保证求出的索引下标都在哈希表的长度范围之内
 *               b.n :  哈希表的长度   n 必须为2^n，保证哈希表中的所有索引下标都会被访问到。若n=15，则以下位置永远不可能会存储元素
 *
 *
 *   (八)ConcurrentMap是如何实现线程安全的
 *         HashTable  锁的是整个哈希表（锁的个数只有一个，精度很粗，读读互斥）
 *   (九)ConcurrentMapJDK1.7与JDK1.8的区别
 *         ConcurrentHashMap    JDK1.7与JDK1.8区别
 *  JDK1.7    Segement  +  哈希表
 *          Segement初始化为16之后，不再扩容
 *          扩容发生在Segement对应的小哈希表
 *       concurrentHashMap  锁的是Segement，由HashTable一把锁变成16把锁，锁的精度更细（支持的并发线程一拿到segenment1的锁不影响线程2访问Segement2）
 *       Segement是ReentrantLock的子类，使用Lock来保证线程安全性
 * JDK1.8
 *         ConcurrentHashMap   哈希表 + 红黑树
 *         Segement没有具体的作用，只保留结构
 *         ConcurrentHashMap锁的是哈希桶，锁的精度更加细，锁的个数会随着哈希表的扩容而增加
 *         CAS(乐观锁，鉴别线程是否出现冲突，直到不冲突为止)：synchronized代码块来保证线程安全
 *
 *
 *
 *
 *
 *
 *
 */
public class Review {
}
