package math;

/**
 * 四则运算
 *
 * @author luchao
 * @date 2021/11/26
 */
public class Math {

    public static void main(String[] args) {
        float num1 = 2F;
        double num2 = 3.0;
        int num3 = 3;
        long num4 = 4L;
        // 加
        System.out.println("加法运算：" + (num1 + num2));
        // 减
        System.out.println("减法运算：" + (num4 - num3));
        // 乘
        System.out.println("乘法运算：" + num2 * num3);
        // 除
        System.out.println("除法运算：" + num3 / num1);
        // for循环
        int res = 0;
        for (int i = 0; i < num3; i++) {
            res += num3;
        }
        System.out.println("for累加：" + res);
        // if操作
        if (res > num4) {
            System.out.println("进入if分支");
        }
    }
}
