package xiaodong;

/**
 * Author : dong
 * Time:2019/7/30
 */
public class ListReview {
    /**
     * 3.Set接口与Map接口的关系
     * Set实际上内部就是Map，保存的单个元素存储在Map的key。
     * Set不允许数据重复
     * HashSet判断两个对象是否重复:equals与hashCode
     *
     * 元素要想保存到TreeSet中，要么元素本身所在的类实现Comparable，
     * 要么通过外部传入一个比较器(外部排序).
     *
     *
     * 4.hashCode 与 equals的关系
     * hashCode:取得任意一个对象的哈希码
     * equals:比较两个对象是否相等
     *
     * hashCode返回值相等的两个对象，equals不一定相等(x 与 f(x)关系)
     * equals返回值相等的两个对象，hashCode一定相等
     *
     *
     * 5.Java实现大小比较的方式(内部排序 外部排序)-两个对象间
     * 内部排序(自己与别人比)-Comparable
     * 实现了Comparable接口的子类，表示本类具备天然的可比较特性.
     * int compareTo(Object o)
     * >0 本身大于目标对象
     * =0 本身等于目标对象
     * <0 本身小于目标对象
     *
     * 外部排序-Comparator(推荐)
     * 类本身不具备可比较的特性，专门有一个类比较该类的大小(比较器)
     * 策略模式
     *
     * 6.HashMap、TreeMap、Hashtable的关系与区别
     * a.这三个类都是Map接口下的常用子类,Hashtable基于哈希表实现,TreeMap基于红黑树实现,
     * HashMap基于哈希表+红黑树(JDK1.8之后,JDK1.8基于哈希表)
     * b.关于null,
     * HashMap允许key、value为null.
     * Hashtable key与value均不为null.
     * TreeMap只允许value为null
     * c.线程安全性
     * HashMap、TreeMap采用异步处理，线程不安全，性能较高;
     * Hashtable使用synchronized同步方法，线程安全，性能较低(锁的是整个哈希表，读读互斥)
     *
     *
     * 哈希表(K,V):数组
     * 根据相应的哈希算法计算key,返回值即为V存储的数组下标.
     *
     * 7.HashMap源码解析(负载因子 树化策略 内部hash实现 resize策略 ..)
     * 内部属性:
     * 负载因子: final float loadFactor(默认为0.75f)
     * 实际容量: int threshold = loadFactor * tab.length;
     * 树化阈值: int TREEIFY_THRESHOLD = 8;
     * 解除树化阈值: int UNTREEIFY_THRESHOLD = 6;
     *
     * HashMap也采用懒加载策略，第一次put时初始化哈希表。
     * 树化逻辑:索引下标对应的链表长度达到阈值8并且当前哈希表长度达到64才会树化，
     * 否则只是调用resize方法进行哈希表扩容。
     *
     * resize():扩容为原先数组的2倍
     *
     * 负载因子过大会导致哈希冲突明显增加，节省内存.
     * 负载因子过小会导致哈希表频繁扩容，内存利用率低。
     *
     * 为何JDK1.8要引入红黑树?
     * 当链表长度过长时，会将哈希表查找的时间复杂度退化为O(n)
     *
     * 树化保证即便在哈希冲突严重时，查找时间复杂度也为O(logn)
     *
     * 当红黑树节点个数在扩容或删除元素时减少为6以下，在下次resize过程中会将红黑树退化为链表
     * ，节省空间。
     *
     *     public V put(K key, V value) {
     *         return putVal(hash(key), key, value, false, true);
     *     }
     *
     *     HashMap内部hash
     *     static final int hash(Object key) {
     *         int h;
     *         return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
     *     }
     *     为何不直接使用Object提供的hashCode?
     *     将哈希码保留一半，将高低位都参与哈希运算，减少内存开销，减少哈希冲突。
     *     (h = key.hashCode()) ^ (h >>> 16)
     *
     *     put内部逻辑:
     *     1.哈希表索引下标计算:
     *     i = (n - 1) & hash
     *     保证求出的索引下标都在哈希表的长度范围之内。
     *     2.n : 哈希表长度
     *     n必须为2^n,保证哈希表中的所有索引下标都会被访问到。
     *     若n=15，则以下位置永不可能存储元素
     *     0011
     *     0101
     *     1001
     *     1011
     *     1101
     *     1111
     *     15:0000 1111
     *
     *
     *     final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
     *                    boolean evict) {
     *         Node<K,V>[] tab; Node<K,V> p; int n, i;
     *
     *         // 第一次put值时，将哈希表初始化
     *         // resize():1.完成哈希表的初始化 2.完成哈希表的扩容
     *         if ((tab = table) == null || (n = tab.length) == 0)
     *             n = (tab = resize()).length;
     *         // 当目标索引未存储元素时，将当前元素存储到目标索引位置
     *         if ((p = tab[i = (n - 1) & hash]) == null)
     *             tab[i] = newNode(hash, key, value, null);
     *         // 哈希表已经初始化并且算出的数组下标已经有元素了
     *         else {
     *             Node<K,V> e; K k;
     *             // 若索引下标对应的元素key恰好与当前元素key值相等且不为null
     *             // 将value替换为当前元素的value
     *             if (p.hash == hash &&
     *                 ((k = p.key) == key || (key != null && key.equals(k))))
     *                 e = p;
     *             // 此时索引对应的链表已经树化了，采用红黑树方式将当前节点添加到树中
     *             else if (p instanceof TreeNode)
     *                 e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
     *             // 以链表方式将当前节点添加到链表末尾
     *             else {
     *                 for (int binCount = 0; ; ++binCount) {
     *                 	// 找到链表末尾
     *                     if ((e = p.next) == null) {
     *                         p.next = newNode(hash, key, value, null);
     *                         if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
     *                             // 尝试将链表树化
     *                             treeifyBin(tab, hash);
     *                         break;
     *                     }
     *                     if (e.hash == hash &&
     *                         ((k = e.key) == key || (key != null && key.equals(k))))
     *                         break;
     *                     p = e;
     *                 }
     *             }
     *             if (e != null) { // existing mapping for key
     *                 V oldValue = e.value;
     *                 if (!onlyIfAbsent || oldValue == null)
     *                     e.value = value;
     *                 afterNodeAccess(e);
     *                 return oldValue;
     *             }
     *         }
     *         ++modCount;
     *         // 此时添加了新节点
     *         if (++size > threshold)
     *         	// 扩容
     *             resize();
     *         afterNodeInsertion(evict);
     *         return null;
     *     }
     *
     *
     *
     * 8.ConcurrentHashMap是如何高效实现线程安全?
     * 9.ConcurrentHashMap JDK1.7 与 JDK1.8区别
     */
}
