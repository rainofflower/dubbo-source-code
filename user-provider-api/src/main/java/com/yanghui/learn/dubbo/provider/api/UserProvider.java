package com.yanghui.learn.dubbo.provider.api;

import com.yanghui.learn.dubbo.provider.dto.UserDTO;

/**
 * @author YangHui
 */
public interface UserProvider {

    UserDTO getUserById(Long id);
}
