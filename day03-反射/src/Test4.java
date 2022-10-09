/**
 * @author : zhousy
 * @date : 2022/9/26 12:45
 * @version : 1.0
 */

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用动态代理体现java语言具有动态特性
 * 动态代理是反射的一种运用
 * 动态代理与静态代理对比：
 *      动态代理只需要提供 被代理对象就可以造出代理类。
 *      静态代理需要提供 被代理类、代理类才能造出代理对象。
 *      动态代理在编译时无需知道要造的对象是哪个，由运行时决定造哪个对象。
 */
public class Test4 {
    @Test
    public void test(){
        Man man = new Man();
        Human proxyObject = (Human) ProxyFactory.getProxyObject(man);
        proxyObject.eat();

    }
}

interface Human {
    void eat();
}

class Man implements Human {

    @Override
    public void eat() {
        System.out.println("男人吃饭...");
    }
}

class ProxyFactory {
    public static Object getProxyObject(Object object) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader()
                , object.getClass().getInterfaces()
                , myInvocationHandler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object object;
    MyInvocationHandler(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(object, args);
    }
}
