package com.summary.nio.server.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * Netty服务端初始化器
 * <p>
 *   指定 handler
 * </p>
 *
 * @author luchao
 * @date 2021/12/18
 */
public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) {
        // ChannelPipeline
        socketChannel.pipeline()
                // http编解码
                .addLast(new HttpServerCodec())
                // http消息聚合器
                .addLast("httpAggregator",new HttpObjectAggregator(512 * 1024))
                // 指定Handler
                .addLast(new NettyServerHandler());
    }
}
