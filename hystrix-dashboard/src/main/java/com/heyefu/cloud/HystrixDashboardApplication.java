package com.heyefu.cloud;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-09
 * Time: 14:39
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {

    public static void main(String[] args) {
        System.out.println("Hystrix Dashboard Service");
        int port = 8020;
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(HystrixDashboardApplication.class).properties("server.port=" + port).run(args);

    }
}
