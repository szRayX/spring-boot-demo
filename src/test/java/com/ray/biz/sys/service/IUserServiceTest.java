package com.ray.biz.sys.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ray.Application;
import com.ray.biz.sys.param.UserSaveParam;
import com.ray.biz.sys.pojo.generator.User;
import com.ray.frame.base.APIResult;
import com.ray.frame.base.BaseGetParam;
import com.ray.frame.base.BaseResult;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class IUserServiceTest {

    @Resource
    private IUserService userService;

    @Test
    public void get() {
        Long userId = 1L;
        BaseGetParam param = new BaseGetParam();
        param.setId(userId);
        APIResult<User> result1 = userService.get(param);
        User u1 = result1.getResult();
        Assert.assertEquals(u1.getUserId(), userId);
        APIResult<User> result2 = userService.get(param);
        User u2 = result2.getResult();
        Assert.assertEquals(u2.getUserId(), userId);
    }

    @Test
    public void save() throws JsonProcessingException {
        Long userId = 1L;
        BaseGetParam param = new BaseGetParam();
        param.setId(userId);
        APIResult<User> result1 = userService.get(param);
        User u1 = result1.getResult();
        Assert.assertEquals(u1.getUserId(), userId);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(u1);
        System.out.println("u1===>" + json);

        UserSaveParam saveParam;
        saveParam = mapper.readValue(json, UserSaveParam.class);
            saveParam.setAge(18);
        if (ObjectUtils.isNotEmpty(saveParam)) {
            saveParam.setUserId(userId);
            userService.save(saveParam);
        }

        APIResult<User> result2 = userService.get(param);
        User u2 = result2.getResult();
        Assert.assertEquals(u2.getUserId(), userId);
        json = mapper.writeValueAsString(u2);
        System.out.println("u2===>" + json);
    }
}