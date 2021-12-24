package com.summary.nio.client.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * NettyHttpClient
 *
 * @author luchao
 * @date 2021/12/24
 */
public class NettyHttpClient {

    private final static String HOST = "localhost";
    private final static Integer PORT = 8801;

    public static void main(String[] args) {
        NettyHttpClient nettyHttpClient = new NettyHttpClient();
        nettyHttpClient.connect(HOST, PORT);
    }

    /**
     * netty client 连接 server
     *
     * @param host server地址
     * @param port server端口号
     */
    public void connect(String host, Integer port) {
        // 创建客户端
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap client = new Bootstrap();
        client.option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_KEEPALIVE, true);
        client.group(group)
                .channel(NioSocketChannel.class)
                // 绑定初始化器
                .handler(new NettyClientInitializer());
        // start the client
        try {
            ChannelFuture future = client.connect(host, port).sync();
            future.channel().writeAndFlush("Hello Netty Server, I am a Netty Client!");
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
