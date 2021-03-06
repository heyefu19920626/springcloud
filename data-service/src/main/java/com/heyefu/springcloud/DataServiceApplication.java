package com.heyefu.springcloud;

import brave.sampler.Sampler;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Hello world!
 *
 * @author heyefu
 */
@SpringBootApplication
@EnableEurekaClient
public class DataServiceApplication {
    public static void main(String[] args) {
        System.out.println("Data Service");

        int port;
        int defaultPort = 8001;

        Future<Integer> future = ThreadUtil.execAsync(() -> {
            int p;
            System.out.println("请于5秒钟内输入端口号, 推荐  8001 、 8002  或者  8003，超过5秒将默认使用 " + defaultPort);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String strPort = scanner.nextLine();
                if (!NumberUtil.isInteger(strPort)) {
                    System.out.println("只能是数字");
                } else {
                    p = Convert.toInt(strPort);
                    scanner.close();
                    break;
                }
            }
            return p;
        });

        try {
            port = future.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            port = defaultPort;
        }

        if (!NetUtil.isUsableLocalPort(port)) {
            System.out.printf("端口%d被占用,无法启动", port);
            System.exit(1);
        }

        new SpringApplicationBuilder(DataServiceApplication.class).properties("server.port=" + port).run(args);
    }

    /**
     * Description:
     * <p>
     * 配置抽样策略,ALWAYS_SAMPLE表示持续抽样
     *
     * @return brave.sampler.Sampler
     * @author heyefu 9:43 2019/12/6
     **/
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
