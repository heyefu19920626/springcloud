package com.heyefu.sprigcloud;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description:
 * <p>
 * 配置服务启动类.
 *
 * @author heyefu
 * Create in: 2019-12-07
 * Time: 12:56
 **/
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
@EnableEurekaClient
public class ConfigServerApplication {

    public static void main(String[] args) {
        System.out.println("Config Server");
        int port = 8030;
        if (!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用，无法启动", port);
            System.exit(1);
        }

        new SpringApplicationBuilder(ConfigServerApplication.class).properties("server.port=" + port).run(args);
    }
}
