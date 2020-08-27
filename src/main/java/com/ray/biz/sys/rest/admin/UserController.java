package com.ray.biz.sys.rest.admin;

import com.ray.biz.sys.dao.custom.UserMapperCustom;
import com.ray.biz.sys.pojo.generator.User;
import com.ray.frame.exception.BaseException;
import com.ray.frame.log.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 作者 xuel
 * @version 创建时间： 2020年08月24日 17:27:19
 * 用户Controller实现
 */
@RestController
@Scope("prototype")
@Api(tags = "user")
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserMapperCustom userMapperCustom;

    /**
     * 查找用户明细
     *
     * @param id 用户ID
     * @return result结果
     */
    @ApiOperation("查找用户明细")
//    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @GetMapping("{id}")
    @ResponseBody
    @Log(value = "method findById")
    public User findById(@PathVariable("id") Long id) throws RuntimeException {
        if (id == 2) {
            throw new BaseException("id = 2.");
        }
        if (id != 1) {
            throw new RuntimeException("id != 1.");
        }
        return userMapperCustom.getById(id);
    }
}
