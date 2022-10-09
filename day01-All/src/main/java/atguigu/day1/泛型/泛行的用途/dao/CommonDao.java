package atguigu.day1.泛型.泛行的用途.dao;

import java.util.List;

/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/8/26 11:18
 */


public class CommonDao<T> {
    //新增
    public int create() {
        return 1;
    }

    //获取
    public List<T> getAll() {
        return null;
    }

    //更新
    public int update(Integer id, T data) {
        return 2;
    }

    //删除
    public int delete(T data) {
        return 3;
    }
}
