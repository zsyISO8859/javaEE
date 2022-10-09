package domain;

/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/9/13 10:04
 */


public class User implements Comparable {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof User) {
            User user = (User) o;
            if ((user.getName()+user.getAge()).equals(this.name+this.age)) return 0;
            else return (user.getName()+user.getAge()).compareTo(this.name+this.age);
        } else {
            throw new RuntimeException();
        }
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
