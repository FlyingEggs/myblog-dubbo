package com.ming.controller.admin;

import com.ming.service.user.UserService;
import com.ming.utils.APIResponse;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Donghua.Chen on 2018/4/20.
 */
@Api("用户管理类")
@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Reference
    private UserService userService;

    @GetMapping("/docker")
    @ResponseBody
    public APIResponse<String> dockerTest(){
        return APIResponse.success((Object) "hello docker");
    }
    
}
