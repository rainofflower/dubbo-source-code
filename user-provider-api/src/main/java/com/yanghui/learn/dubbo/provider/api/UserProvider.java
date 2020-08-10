package com.yanghui.learn.dubbo.provider.api;

import com.yanghui.learn.dubbo.provider.dto.UserDTO;

import java.util.concurrent.CompletableFuture;

/**
 * @author YangHui
 */
public interface UserProvider {

    UserDTO getUserById(Long id);

    default CompletableFuture<UserDTO> getUserByIdAsync(Long id){
        return CompletableFuture.completedFuture(getUserById(id));
    }
}
