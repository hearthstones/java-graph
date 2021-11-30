package classloader;

import sun.misc.Launcher;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

/**
 * 查看当前 ClassLoader 加载的 jar
 *
 * @author luchao
 * @date 2021/11/29
 */
public class JvmClassLoaderPrintPath {

    public static void main(String[] args) {
        ClassLoader appClassLoader = JvmClassLoaderPrintPath.class.getClassLoader();
        ClassLoader extClassLoader = appClassLoader.getParent();
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();

        // 1.启动类加载器 - BootstrapClassLoader
        // 由C++实现 => extClassLoader.getParent() == null
        System.out.println("启动类加载器：" + bootstrapClassLoader);
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {
            System.out.println("==> " + url);
        }
        System.out.println("");

        // 2.扩展类加载器 - ExtClassLoader
        System.out.println("扩展类加载器：" + extClassLoader);
        printUrlsOfClassLoader(extClassLoader);

        // 3.应用类加载器 - AppClassLoader
        System.out.println("应用类加载器：" + appClassLoader);
        printUrlsOfClassLoader(appClassLoader);
    }


    private static void printUrlsOfClassLoader(ClassLoader classLoader) {
        try {
            // 通过反射获取加载path：URLClassLoader -> URLClassPath ucp -> ArrayList<URL> path
            Field fieldUcp = URLClassLoader.class.getDeclaredField("ucp");
            fieldUcp.setAccessible(true);
            Object ucp = fieldUcp.get(classLoader);
            Field fieldPath = ucp.getClass().getDeclaredField("path");
            fieldPath.setAccessible(true);
            Object path = fieldPath.get(ucp);
            List<URL> paths = (List<URL>) path;
            paths.forEach(p -> System.out.println("==> " + p.toString()));
            System.out.println("");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
