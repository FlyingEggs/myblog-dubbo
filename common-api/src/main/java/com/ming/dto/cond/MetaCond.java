package com.ming.dto.cond;

import java.io.Serializable;

/**
 * meta查询条件
 * Created by Donghua.Chen on 2018/4/30.
 */
public class MetaCond implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -466498992652646810L;
	/**
     * meta Name
     */
    private String name;
    /**
     * 类型
     */
    private String type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
