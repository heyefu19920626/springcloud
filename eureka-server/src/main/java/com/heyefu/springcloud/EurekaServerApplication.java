package com.heyefu.springcloud;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 * @author heyefu
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int port = 8761;

        if (!NetUtil.isUsableLocalPort(port)) {
            System.out.println("端口被占用");
        }

        new SpringApplicationBuilder(EurekaServerApplication.class).properties("server.port=" + port).run();
    }
}
