package com.yanghui.learn.dubbo.provider.api;

import com.yanghui.learn.dubbo.provider.dto.UserDTO;

 /**
  * mock测试
  * 优先调用本jar包里的Mock类
 * @author YangHui
 */
public class UserProviderMock implements UserProvider {

    @Override
    public UserDTO getUserById(Long id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("MOCK");
        return userDTO;
    }
}
