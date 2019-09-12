package com.ming.dto;

import java.io.Serializable;

/**
 * 公共属性的类
 * Created by Donghua.Chen on 2018/4/29.
 */
public class BaseDto implements Serializable{


    /**
	 * 
	 */
	private static final long serialVersionUID = -533494128960734744L;
	/** 用户名 */
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
