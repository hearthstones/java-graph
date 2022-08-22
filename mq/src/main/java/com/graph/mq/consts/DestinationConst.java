package com.graph.mq.consts;

/**
 * 目的地常量类
 *
 * @author luchao
 * @since 2022/5/18
 */
public class DestinationConst {

    private DestinationConst() {}

    public static final String TEMPLATE_TOPIC = "template-topic";

    /**
     * 交易Topic，Tag - { order, pay, statistics }
     */
    public static final String TOPIC_TRADE = "topic-trade";

    public static final String TAG_ORDER = "order";

    public static final String TAG_PAY = "pay";

    public static final String TAG_LOGISTICS = "logistics";

}
