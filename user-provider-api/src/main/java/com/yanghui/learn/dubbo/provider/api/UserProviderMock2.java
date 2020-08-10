package com.yanghui.learn.dubbo.provider.api;

import com.yanghui.learn.dubbo.provider.dto.UserDTO;

 /**
  * mock测试
  * 通过jar包依赖进去的Mock类，如果类的权限定名和服务内某一个类一模一样，会自动被排除
 * @author YangHui
 */
public class UserProviderMock2 implements UserProvider {

    @Override
    public UserDTO getUserById(Long id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("MOCK-2");
        return userDTO;
    }
}
