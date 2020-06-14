package com.tom.shutdownhook;

import org.assertj.core.internal.cglib.proxy.Enhancer;
import org.assertj.core.internal.cglib.proxy.MethodInterceptor;
import org.assertj.core.internal.cglib.proxy.MethodProxy;
import org.junit.Before;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 导致 OOM 的情况有多种，
 * 包括 Java 或 Native Method Stack 的内存不足或者栈空间溢出（stack over Flow）、
 * Heap 内存溢出(OOM)、
 * Non-heap 内存溢出(OOM)、
 * Direct Memory 溢出。
 *
 * @author TomLuo
 * @date 2020/6/13
 */
public class TestErr {
    /**
     * @Description 直接内存溢出
     * 程序计数器：运行时数据区还有程序计数器的存在，线程私有，一块很小的内存，Java规范中没有没有规定任何OOM情况。
     * <p>
     * 还有一种内存溢出就是直接内存溢出
     * <p>
     * 直接内存并不是虚拟机运行时数据区的一部分，也不是Java虚拟机规范中定义的内存 区域。
     * 但是这部分内存也被频繁地使用，而且也能导致OOM。
     * 在JDK1.4之后，新加入了NIO（new Input/Output）,引入了一种基于通道（channel）和缓冲区（Buffer）的I/O方式，
     * 它可以使用Native函数直接分配内存，然后通过存储在Java堆中的DirectByteBuffer对象作为这块内存的引用进行操作。
     * 这样可以显著提高性能，避免了Java堆和Native堆中来回复制数据。
     * DirectMemory容量可以通过-XX:MaxDirectMemorySize指定，如果不指定则默认与Java堆最大值（-Xmx指定）一样。
     * JVM args: -XX:MaxDirectMemorySize=10M
     */

    private static final int _1MB = 1024 * 1024;

    @Before
    public void setUp() throws Exception {
        /**
         * 最大可用内存，对应-Xmx
         * 可通过-Xmx设置，默认值为物理内存的1/4，设值不能高于计算机物理内存
         */
        System.out.println("最大可用内存：" + Runtime.getRuntime().maxMemory());
        /**
         * 当前JVM空闲内存
         * 因为JVM只有在需要内存时才占用物理内存使用，所以freeMemory()的值一般情况下都很小，
         * 而 JVM实际可用内存并不等于freeMemory()，而应该等于maxMemory()-totalMemory()+freeMemory()。
         */
        System.out.println("当前JVM空闲内存：" + Runtime.getRuntime().freeMemory());
        /**
         * 当前JVM占用的内存总数，其值相当于当前JVM已使用的内存及freeMemory()的总和
         *
         * 其值相当于当前JVM已使用的内存及freeMemory()的总和，会随着JVM使用内存的增加而增加；
         *
         */
        System.out.println("JVM占用的内存总数：" + Runtime.getRuntime().totalMemory());
    }

    /**
     * VM args: -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
     */
    @Test
    public void outOfMemoryError() {
        while (true) {
            new Thread(() -> {
                try {
                    TimeUnit.HOURS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    /**
     * @Description 模拟堆内存溢出
     * VM args: -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
     * 堆（Java Heap）:Java 堆是Java虚拟机所管理的内存中最大的一块，被所有线程共享的内存区域 ，用于存放对象实例，几乎所有的对象实例都在这里分配内存。
     * 这样分析来看，如果在堆中没有内存完成实例分配，并且也无法再扩展时，将会抛出OutOfMemoryError异常。
     * 比如：-Xmx：设置JVM最大堆内存大小，以及-Xms：设置JVM最小（启动时）堆的大小
     * 这两个值设置的都很小，而且一样（防止扩展），那么只要new少许的对象出来，就会出现OutOfMemoryError。
     */
    @Test
    public void giveMemory_oom_javaHeapSpace() {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }

    /**
     * @Description 运行时常量池导致内存溢出
     * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M
     * 仅仅在JDK1.6会发生OutOfMemoryError：PermGen space。
     */
    @Test
    public void giveMemory_oom_methodArea_variables() {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
            System.out.println(i);
        }
    }

    /**
     * @Description 方法区出现内存溢出
     * VM args: -Xmx10m -Xms10m -XX:PermSize=10M -XX:MaxPermSize=10M
     * 方法区（Method Area）：和Java堆一样，方法区是各个线程共享的内存区域，
     * 它用于存储已经被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。
     * 而运行时常量池属于方法区的一部分，用于存放编译期生成的各种字面量和符号引用。
     * 当方法区无法满足内存分配需求时，将抛出OutOfMemoryError异常。
     * java.lang.OutOfMemoryError: GC overhead limit exceeded
     * 在1.8开始已经没有永久代这一说法了，取而代之的是另一块与堆不相连的本地内存—元空间（-XX:MaxMetaspaceSize）。
     * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=10M; support was removed in 8.0
     * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=10M; support was removed in 8.0
     */
    @Test
    public void giveMemory_oom_methodArea() {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            enhancer.create();
        }
    }

    @Test
    public void giveMemory_oom_stackOverFlowError() {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack length:" + oom.stackLength);
            throw e;
        }
    }

    @Test
    public void giveMemory_oom_directMemoryOverflow() throws IllegalAccessException {
        Field unsafefield = Unsafe.class.getDeclaredFields()[0];
        unsafefield.setAccessible(true);
        // 返回指定对象上由此Field表示的字段的值。
        // 如果该对象具有原始类型，则该值将自动包装在对象中。
        Unsafe unsafe = (Unsafe) unsafefield.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }

    static class OOMObject {
    }

    /**
     * Java虚拟机栈和本地方法栈：Java虚拟机栈是线程私有的，生命周期与线程相同，描述着Java方法执行的内存模型：
     * 每个方法在执行的同时会创建一个栈帧用于存储局部变量表、操作数栈、动态链接、方法出口等信息。
     * 每一个方法从调用到执行完成的过程，就对应着一个栈帧在虚拟机栈中入栈到出栈。
     * 如果线程请求的栈深度大于虚拟机所允许的深度，将抛出StackOverflowError异常。
     * 如果虚拟机栈可以动态扩展，如果扩展时无法申请到足够内存就会抛出OutOfMemoryError异常。
     * 本地方法栈和虚拟机方法栈作用相似，只是本地方法栈调用的是本地方法（由其他语言实现的JVM底层方法）。
     * <p>
     * 那么有个问题，当栈空间无法继续分配时，到底是内存太小，还是已经使用的栈空间太大，其本质上描述的都是一件事。
     * <p>
     *  通过设置-Xss：栈容量。
     *
     * @Description StackOverflowError
     * JVM args: -Xss2M
     */
    class JavaVMStackSOF {
        private int stackLength = -1;

        public void stackLeak() {
            stackLength++;
            stackLeak();
        }
    }


}