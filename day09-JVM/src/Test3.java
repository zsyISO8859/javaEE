import org.junit.Test;

/**
 * @author : zhousy
 * @date : 2022/10/11 15:42
 * @version : 1.0
 */

/**
 * StringTable调优：
 *  StringTables底层是Hash表，Hash表是数组+链表存储，所以hash表的长度过小就会导致散列函数的位置重复，就会导致将字符串放入串池中（s.intern()）速度慢。
 *  -XX:StringTableSize=1099  调整StringTable大小
 * 为什么要字符串入串池：
 *  因为串池可以去除重复字符串 例子：推特用s.intern()将用户地址信息去重复存储 将30G的地址内存优化为几百M。
 *  所以如果程序有大量重复字符串 就可以考虑入串池可以减少字符串个数且降低堆内存的使用。
 */
public class Test3 {
    @Test
    public void test() {
        int j = 0;
        try {
            for (int i = 0; i < 10000; i++, j++) {
                String.valueOf(i).intern();
            }
        } finally {
            System.out.println(j);
        }
    }
}
