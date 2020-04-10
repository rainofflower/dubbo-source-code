package com.yanghui.learn.dubbo;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author YangHui
 */
@SpringBootApplication
@DubboComponentScan
public class ProviderApplication {

    public static void main(String... a){
        SpringApplication.run(ProviderApplication.class,a);
    }
}
