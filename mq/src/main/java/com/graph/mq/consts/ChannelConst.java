package com.graph.mq.consts;

/**
 * MQ Channel配置常量类
 *
 * @author luchao
 * @date 2022/5/16
 */
public class ChannelConst {

    private ChannelConst() {}

    /**
     * 普通消息
     */
    public static final String NORMAL_OUTPUT = "normalOutputChannel";

    public static final String NORMAL_INPUT = "normalInputChannel";

    /**
     * 事务消息
     */
    public static final String TX_INPUT = "txInputChannel";

}
