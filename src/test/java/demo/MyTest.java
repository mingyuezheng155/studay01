package demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

public class MyTest {


    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        //初始化自定义比较器
        MyComparator myComparator = new MyComparator();
        //初始化定义一个map集合
      TreeMap<String, String> map = new TreeMap<String, String>(myComparator);
        // TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("b", "b");
        map.put("c", "c");
        map.put("f", "f");
        map.put("g", "g");
        Iterator iterator = map.keySet().iterator();
//
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            list.add(map.get(key));

        }

        //add
        System.out.println(list);

    }

    static class MyComparator implements Comparator {


        @Override
        public int compare(Object o1, Object o2) {
            String param1 = (String) o1;
            String param2 = (String) o2;
            return -param1.compareTo(param2);
        }
    }
}
