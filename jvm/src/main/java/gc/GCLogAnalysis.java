package gc;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * GC日志生成与解读
 *
 * @author luchao
 * @date 2021/12/14
 */
public class GCLogAnalysis {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        // 当前时间戳
        long startMillis = System.currentTimeMillis();
        // 持续运行毫秒数（1s）
        long timeoutMillis = TimeUnit.SECONDS.toMillis(1);
        // 结束时间戳
        long endMillis = startMillis + timeoutMillis;
        LongAdder counter = new LongAdder();
        System.out.println("正在执行...");
        // 缓存一部分对象，进入老年代
        int cacheSize = 2000;
        Object[] cachedGarbage = new Object[cacheSize];
        // 在此时间范围内,持续循环
        while (System.currentTimeMillis() < endMillis) {
            // 生成垃圾对象
            Object garbage = generateGarbage(100 * 1024);
            counter.increment();
            int randomIndex = RANDOM.nextInt(2 * cacheSize);
            if (randomIndex < cacheSize) {
                cachedGarbage[randomIndex] = garbage;
            }
        }
        System.out.println("执行结束!共生成对象次数:" + counter.longValue());
    }

    /**
     * 生成对象
     *
     * @param max max
     * @return 对象
     */
    private static Object generateGarbage(int max) {
        int randomSize = RANDOM.nextInt(max);
        int type = randomSize % 4;
        Object result;
        switch (type) {
            case 0:
                result = new int[randomSize];
                break;
            case 1:
                result = new byte[randomSize];
                break;
            case 2:
                result = new double[randomSize];
                break;
            default:
                StringBuilder builder = new StringBuilder();
                String randomString = "randomString-Anything";
                while (builder.length() < randomSize) {
                    builder.append(randomString).append(max).append(randomSize);
                }
                result = builder.toString();
                break;
        }
        return result;
    }
}