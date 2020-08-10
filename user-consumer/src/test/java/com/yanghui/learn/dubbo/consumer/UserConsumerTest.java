package com.yanghui.learn.dubbo.consumer;

import com.alibaba.fastjson.JSON;
import com.yanghui.learn.dubbo.ConsumerApplication;
import com.yanghui.learn.dubbo.provider.api.UserProvider;
import com.yanghui.learn.dubbo.provider.dto.UserDTO;
import com.yanghui.learn.dubbo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author YangHui
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ConsumerApplication.class)
@Slf4j
public class UserConsumerTest {

    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        UserDTO user = userService.getUserById(1L);
        log.info("-------获取到user:{}",user.toString());
    }

    @Reference(version = "1.0.0", registry = "r2",check = false, async = true, timeout = 6*60*1000)
    private UserProvider userProvider;

    @Test
    public void test2(){
        UserDTO dto = userProvider.getUserById(3l);
        log.info("--user：{}", JSON.toJSONString(dto));
        CompletableFuture<UserDTO> future = RpcContext.getContext().getCompletableFuture();
        try {
            UserDTO userDTO = future.get();
            log.info("--user：{}", JSON.toJSONString(userDTO));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Future<UserDTO> future2 = RpcContext.getContext().getFuture();
    }

}
