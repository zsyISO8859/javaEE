package day1; /**
 * @author : zhousy
 * @date : 2022/10/11 10:07
 * @version : 1.0
 */

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * 演示元空间内存溢出
 * -XX:MaxMetaspaceSize=8m
 */
public class Test2_1 extends ClassLoader {
    public static void main(String[] args) {
        int j = 0;
        try {
            Test2_1 test = new Test2_1();
            for (int i = 0; i < 500000; i++, j++) {
                //用于生成类的二进制字节码
                ClassWriter cw = new ClassWriter(0);
                cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                byte[] bytes = cw.toByteArray();
                test.defineClass("Class" + i, bytes, 0, bytes.length);
            }
        } finally {
            System.out.println(j);
        }


    }

}
