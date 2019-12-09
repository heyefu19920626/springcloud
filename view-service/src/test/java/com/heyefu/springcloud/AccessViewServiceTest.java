package com.heyefu.springcloud;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.http.HttpUtil;

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
}
