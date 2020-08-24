package com.ray.biz.sys.rest.admin;

import com.ray.biz.sys.dao.custom.UserMapperCustom;
import com.ray.biz.sys.pojo.generator.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 作者 xuel
 * @version 创建时间： 2020年08月24日 17:27:19
 * 用户Controller实现
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserMapperCustom userMapperCustom;

    /**
     * 查找用户明细
     *
     * @param id
     * @return result
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public User findById(@PathVariable("id") Long id) {
        return userMapperCustom.getById(id);
    }
}