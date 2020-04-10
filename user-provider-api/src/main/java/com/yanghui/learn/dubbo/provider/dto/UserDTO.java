package com.yanghui.learn.dubbo.provider.dto;

import lombok.Data;

import java.io.Serializable;


/**
 * @author YangHui
 */
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -2605513872155736202L;

    private Long id;

    private String name;

    private Integer age;
}
