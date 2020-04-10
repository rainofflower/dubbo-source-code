package com.yanghui.learn.dubbo.consumer;

import com.yanghui.learn.dubbo.ConsumerApplication;
import com.yanghui.learn.dubbo.provider.dto.UserDTO;
import com.yanghui.learn.dubbo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
