package com.graph.nio.client.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.http.HttpResponse;


/**
 * NettyClientHandler
 *
 * @author luchao
 * @date 2021/12/24
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("NettyClientHandler read Message:" + msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("NettyClientHandler Active");
    }
}
