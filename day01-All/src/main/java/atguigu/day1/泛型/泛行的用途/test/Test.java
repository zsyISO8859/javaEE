package atguigu.day1.泛型.泛行的用途.test;

import atguigu.day1.泛型.泛行的用途.dao.UserDao;
import atguigu.day1.泛型.泛行的用途.domain.User;

/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/8/26 11:23
 */

//此处测试泛行的实际应用
// 通过提前定义好CommonDao约定好单表操作的方法
// 后续的类继承CommonDao就可以得到它的单表操作方法
// 同时可以固定该dao操作的参数类型
public class Test {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        userDao.update(1, new User());
    }
}
