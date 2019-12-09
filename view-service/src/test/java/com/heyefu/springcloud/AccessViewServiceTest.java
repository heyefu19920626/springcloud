package com.heyefu.springcloud;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.http.HttpUtil;
import org.junit.Test;

/**
 * Description:
 * <p>
 * 不停访问视图微服务，便于断路器的监控.
 *
 * @author heyefu
 * Create in: 2019-12-09
 * Time: 14:43
 **/
public class AccessViewServiceTest {
    public static void main(String[] args) {
        while (true) {
            ThreadUtil.sleep(1000);
            try {
                String html = HttpUtil.get("http://127.0.0.1:8013/productsFeign");
                System.out.println("html length:" + html.length());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Test
    public void testTurbine() {
        while(true) {
            ThreadUtil.sleep(1000);
            access(8014);
            access(8013);
        }
    }

    public static void access(int port) {
        try {
            String html= HttpUtil.get(String.format("http://127.0.0.1:%d/productsFeign",port));
            System.out.printf("%d 地址的视图服务访问成功，返回大小是 %d%n" ,port, html.length());
        }
        catch(Exception e) {
            System.err.printf("%d 地址的视图服务无法访问%n",port);
        }
    }
}
