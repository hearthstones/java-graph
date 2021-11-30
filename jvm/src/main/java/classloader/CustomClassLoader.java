package classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义类加载器 - 加载加密的类
 *
 * @author luchao
 * @date 2021/11/29
 */
public class CustomClassLoader extends ClassLoader {

    /**
     * 文件后缀
     */
    private static final String SUFFIX = ".xlass";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 获取输入流
        // 文件要放在 resource 文件夹下。包名："." -> "/"。
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(name.replace(".", "/") + SUFFIX);
        try {
            // 读取数据
            assert is != null;
            byte[] bytes = new byte[is.available()];
            int read = is.read(bytes);
            // 解密
            byte[] decodeBytes = decode(bytes);
            // 定义类：字节码 => 类
            return defineClass(name, decodeBytes, 0, decodeBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 解密
     * <p>
     *  加密方式：xxx.class 中所有字节 c 加密 (255 - c = x) => xxx.xlass
     *  解密方式：xxx.xlass 中所有字节 x 解密 (255 - x = c) => xxx.class
     * </p>
     *
     * @param encodeBytes 加密 byte 数组
     * @return 解密后 byte 数组
     */
    private byte[] decode(byte[] encodeBytes) {
        int length = encodeBytes.length;
        byte[] decodeBytes = new byte[length];
        for (int i = 0; i < length; i++) {
            decodeBytes[i] = (byte) (255 - encodeBytes[i]);
        }
        return decodeBytes;
    }
}
