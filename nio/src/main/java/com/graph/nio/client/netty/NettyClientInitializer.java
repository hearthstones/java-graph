package com.graph.nio.client.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;

/**
 * Netty客户端初始化器
 *
 * @author luchao
 * @date 2021/12/24
 */
public class NettyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) {
        socketChannel.pipeline()
                // request编码
                .addLast(new HttpRequestEncoder())
                // response解码
                .addLast(new HttpResponseDecoder())
                // 指定handler
                .addLast(new NettyClientHandler());

    }
}
