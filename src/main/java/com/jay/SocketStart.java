package com.jay;

import com.jay.socket.netty.WebSocketServer;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName SocketStart
 * @Description TODO
 * @Date 2019/3/12
 * @Author lufangjie
 * @Version 1.0
 **/
@ComponentScan(value = "com.jay.socket.spring")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SocketStart implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SocketStart.class, args);
    }

//    @Autowired
//    private WebSocketServer server;
//
//    @Bean
//    public WebSocketServer server() {
//        return new WebSocketServer();
//    }

    @Override
    public void run(String... args) throws Exception {
//        ChannelFuture future = server.run();
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> server.destroy()));
//        future.channel().closeFuture().syncUninterruptibly();
    }
}
