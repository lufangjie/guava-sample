package com.jay.socket.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName WebSocketServer
 * @Description 启动socket服务端
 * @Date 2019/3/12
 * @Author lufangjie
 * @Version 1.0
 **/
@Slf4j
@Component
public class WebSocketServer {

    @Value(value = "${socket.port}")
    public String port;

    private Channel channel;

    private EventLoopGroup bossGroup = new NioEventLoopGroup();
    private EventLoopGroup workGroup = new NioEventLoopGroup();

    public ChannelFuture run() {
        ChannelFuture future;
        ServerBootstrap boot = new ServerBootstrap();
        boot.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast("http-codes", new HttpServerCodec());
                        pipeline.addLast("http-aggregator", new HttpObjectAggregator(64 * 1024));
                        pipeline.addLast("http-chunked", new ChunkedWriteHandler());
                        pipeline.addLast("socket-handler", new WebSocketServerHandler(port));
                    }
                });
        future = boot.bind(Integer.parseInt(port)).syncUninterruptibly();
        channel = future.channel();
        return future;
    }

    public void destroy() {
        if(channel != null) {
            channel.close();
        }
        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
    }

}
