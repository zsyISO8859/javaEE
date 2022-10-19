package atguigu.day2.枚举.test;

import atguigu.day2.枚举.jdk5之前的枚举.Season;
import atguigu.day2.枚举.jdk5之后的枚举.Season1;

/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/8/29 10:32
 */


public class Test {
    public static void main(String[] args) {
        //传统模式jdk1.5之前
        System.out.println(Season.SUMMER.getDesc());
        System.out.println(Season.SUMMER.getName());
        System.out.println(Season.SUMMER);

        System.out.println("-----------------------------------------------");
        //jdk1.5之后
        System.out.println(Season1.SUMMER);
        Season1[] values = Season1.values();
        for (Season1 value : values) {
            System.out.println(value);
        }
        System.out.println(Season1.valueOf(Season1.SPRING.toString()));
    }
}
