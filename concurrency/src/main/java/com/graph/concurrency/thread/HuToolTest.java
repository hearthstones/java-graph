package com.graph.concurrency.thread;

import cn.hutool.core.util.ObjectUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * HuToolTest
 *
 * @author luchao
 * @since 2022/8/8
 */
public class HuToolTest {

    public static void main(String[] args) {
        int emptyCount = ObjectUtil.emptyCount(null, 1, 2, null, "");
        int total = 11;
        BigDecimal infoCompletePercent = BigDecimal.valueOf(total - emptyCount)
                .divide(BigDecimal.valueOf(total), 2, RoundingMode.HALF_DOWN)
                .multiply(BigDecimal.valueOf(100))
                .setScale(0, RoundingMode.DOWN);
        System.out.println(Integer.valueOf(infoCompletePercent.toString()));
    }

}
