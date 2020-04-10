package com.yanghui.learn.dubbo.service;

import com.yanghui.learn.dubbo.provider.api.UserProvider;
import com.yanghui.learn.dubbo.provider.dto.UserDTO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author YangHui
 */
@Service
public class UserService {

    @Reference(version = "1.0.0", registry = "r2")//, url = "dubbo://127.0.0.1:12345"  , registry = "r2"
    private UserProvider userProvider;

    public UserDTO getUserById(Long id){
        return userProvider.getUserById(id);
    }


}
