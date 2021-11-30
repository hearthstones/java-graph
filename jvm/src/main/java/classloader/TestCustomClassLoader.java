package classloader;

import java.lang.reflect.Method;

/**
 * 测试自定义加载器
 *
 * @author luchao
 * @date 2021/11/30
 */
public class TestCustomClassLoader {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new CustomClassLoader();
        // 加载类。路径 - /resource/Hello.xlass
        Class<?> clazz = classLoader.loadClass("Hello");
        // 查看类的方法
        for (Method method: clazz.getDeclaredMethods()) {
            System.out.println(clazz.getSimpleName() + "." + method.getName());
        }
        // 反射调用方法
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Method helloMethod = clazz.getMethod("hello");
        helloMethod.invoke(instance);
    }

}
