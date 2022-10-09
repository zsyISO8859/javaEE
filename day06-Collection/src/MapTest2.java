/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/9/16 10:08
 */

import java.util.*;

/**
 * Map的遍历方式3种:
 *      map.keySet();   类型Set的key
 *      map.values();   类型collection的value
 *      map.entrySet(); 类型Set<Map.Entry<String, String>>的Entry
 */
public class MapTest2 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");

        //1 遍历key
        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //2 遍历values
        Collection<String> values = map.values();
        Iterator<String> iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        //3 遍历entry
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator2 = entries.iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, String> next = iterator2.next();
            System.out.println("key=" + next.getKey() + " ,value=" + next.getValue());
        }
    }
}
