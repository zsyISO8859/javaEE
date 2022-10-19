package day3;

/**
 * @author : zhousy
 * @date : 2022/10/18 16:09
 * @version : 1.0
 */


public class Demo1 {
    private String a = "s1";

    {
        b = 10;
    }

    int b = 10;

    public static void main(String[] args) {
        int a = 0;
        do {

            int b = a++;
        } while (a > 10);
    }
}
