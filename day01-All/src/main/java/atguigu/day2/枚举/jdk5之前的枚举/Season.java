package atguigu.day2.枚举.jdk5之前的枚举;

/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/8/29 10:24
 */


public class Season {
    private final String name;
    private final String desc;

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public static final Season SPRING = new Season("SPRING","美");
    public static final Season SUMMER = new Season("SUMMER","热");

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
