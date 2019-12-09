package com.heyefu.cloud;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Description:
 * <p>
 * 断路器聚合监控。
 *
 * @author heyefu
 * Create in: 2019-12-09
 * Time: 15:16
 **/
@SpringBootApplication
@EnableTurbine
public class HystrixTurbineApplication {
    public static void main(String[] args) {
        System.out.println("Turbine Service");
        int port = 8021;
        if (!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port);
            System.exit(1);
        }
        new SpringApplicationBuilder(HystrixTurbineApplication.class).properties("server.port=" + port).run(args);
    }
}
