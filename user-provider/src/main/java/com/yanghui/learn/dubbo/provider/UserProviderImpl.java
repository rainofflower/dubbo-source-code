package com.yanghui.learn.dubbo.provider;

import com.yanghui.learn.dubbo.provider.api.UserProvider;
import com.yanghui.learn.dubbo.provider.dto.UserDTO;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author YangHui
 */
@Service(version = "1.0.0")
public class UserProviderImpl implements UserProvider {

    @Override
    public UserDTO getUserById(Long id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setName("TEST");
        userDTO.setAge(20);
        return userDTO;
    }
}
