package com.yy.reflection;

import com.google.common.collect.Lists;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

/**
 * @author chenyiqin02
 * @date 2019/06/16
 */
public class Demo {
    public static void main(String[] args) throws Throwable {
        // 正常实例化
        ReflectionDemo reflectionDemo = new ReflectionDemo();
        reflectionDemo.setCount(1);
        System.out.println(reflectionDemo.getCount());

        // 反射进行操作
        Class clazz = Class.forName("com.yy.reflection.ReflectionDemo");
        Object object = clazz.newInstance();
        Method setCountMethod = clazz.getMethod("setCount", int.class);
        setCountMethod.invoke(object, 1);
        Method getCountMethod = clazz.getMethod("getCount");
        System.out.println(getCountMethod.invoke(object));

        // 获取class
        clazz = Class.forName("com.yy.reflection.ReflectionDemo");
        clazz = ReflectionDemo.class;
        clazz = new ReflectionDemo().getClass();

        // 实例化
        object = clazz.newInstance();
        Constructor constructor = clazz.getConstructor(int.class);
        object = constructor.newInstance(1);

        // 构造器
        constructor = clazz.getConstructor(int.class);
        Constructor[] constructors = clazz.getConstructors();

        // 变量
        Field[] fileds = clazz.getDeclaredFields();
        for (Field field : fileds) {
            System.out.println("getDeclaredFields: " + field.getName());
        }
        fileds = clazz.getFields();
        for (Field field : fileds) {
            System.out.println("getFields: " + field.getName());
        }
        Field field = clazz.getField("pubVar");
        field.setInt(object, 2);


        field.get(object);
        field = clazz.getDeclaredField("count");
        field.setAccessible(true);
        field.setInt(object, 2);

        // 方法
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("getDeclaredMethods: " + method.getName());
        }
        methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println("getMethods: " + method.getName());
        }
        setCountMethod = clazz.getMethod("setCount", int.class);
        Method privatemethod = clazz.getDeclaredMethod("privateMethod");
        privatemethod.setAccessible(true);
        for (int i = 0; i < 20; i++) {
            privatemethod.invoke(object);
        }

        List<ReflectionDemo> lists = Lists.newArrayList();
        Map<Integer, List<ReflectionDemo>> maps = lists.stream().collect(Collectors.groupingBy(ReflectionDemo::getCount));
        System.out.println(maps == null);

        // 性能
        Long now = System.nanoTime();
        ReflectionDemoFather father = new ReflectionDemoFather();
        father.pubVarFather = 1;
//        ReflectionDemo temp = new ReflectionDemo();
//        for (int i = 0; i < 20; i++) {
//            temp.setCount(father.getClass().getField("pubVarFather").getInt(father));
//            System.out.println("time cost:" + (System.nanoTime() - now));
//        }
//        System.out.println("time cost:" + (System.nanoTime() - now));


//        List<Object> arr = Lists.newArrayList();
//        now = System.nanoTime();
//        ReflectionDemo temp = new ReflectionDemo();
//        Method setCount = temp.getClass().getDeclaredMethod("getCount");
//        for (int i = 0; i < 100; i++) {
//            now = System.nanoTime();
//            arr.add(new ReflectionDemo());
//            System.out.println("normal time cost:" + (System.nanoTime() - now));
//        }
//        System.out.println("normal time cost:" + (System.nanoTime() - now));
//
//        now = System.nanoTime();
//        for (int i = 0; i < 100; i++) {
//            now = System.nanoTime();
//            arr.add(ReflectionDemo.class.newInstance());
//            System.out.println("reflection time cost:" + (System.nanoTime() - now));
//        }
//        System.out.println("reflection time cost:" + (System.nanoTime() - now));
        ReflectionDemo temp = new ReflectionDemo();
        now = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            temp.setCount((int) (Math.random() % i));
        }
        System.out.println("normal time cost:" + (System.currentTimeMillis() - now));

        ReflectionDemo temp2 = new ReflectionDemo();
        Method setCount = temp2.getClass().getDeclaredMethod("setCount", int.class);
        setCount.setAccessible(true);
        now = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            setCount.invoke(temp2, (int) (Math.random() % i));
        }
        System.out.println("reflection time cost:" + (System.currentTimeMillis() - now));

        ReflectionDemo temp3 = new ReflectionDemo();
        MethodType methodType = MethodType.methodType(void.class, int.class);
        MethodHandle methodHandle = MethodHandles.lookup().findVirtual(temp3.getClass(), "setCount", methodType);
        now = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            methodHandle.invoke(temp3, (int) (Math.random() % i));
        }
        System.out.println("methodHandle time cost:" + (System.currentTimeMillis() - now));

        ReflectionDemo temp4 = new ReflectionDemo();
        MethodHandle methodHandle2 = MethodHandles.lookup().findVirtual(temp4.getClass(), "setCount", methodType);
        now = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            methodHandle2.invokeExact(temp4, (int) (Math.random() % i));
        }
        System.out.println("methodHandle time cost:" + (System.currentTimeMillis() - now));
    }


    static class ThreadDemo implements Callable<String> {
        Integer num;

        ThreadDemo(int num) {
            this.num = num;
        }

        @Override
        public String call() throws Exception {
            System.out.println("thread start:" + num);
            Thread.sleep(10000);
            return num.toString();
        }
    }
}

class ReflectionDemo extends ReflectionDemoFather {
    public int pubVar;
    private int count;

    public ReflectionDemo() {
    }

    public ReflectionDemo(int count) {
        this.count = count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    private void privateMethod() {
        System.out.println("privateMethod");
    }

    void defaultMethod() {

    }

    protected void prodectedMethod() {
    }
}

class ReflectionDemoFather {
    public int pubVarFather;
    private int countOfFather;

    private void privateMethodFather() {
        System.out.println("privateMethodFather");
    }

    public void publicMethod() {
        System.out.println("publicMethod");
    }

    protected void faProMethod() {
    }
}
