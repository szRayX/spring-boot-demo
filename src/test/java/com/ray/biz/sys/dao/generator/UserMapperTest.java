package com.ray.biz.sys.dao.generator;

import com.ray.Application;
import com.ray.biz.sys.dao.custom.UserMapperCustom;
import com.ray.biz.sys.pojo.generator.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMapperTest {

    @Resource
    private UserMapperCustom userMapperCustom;

    @Test
    public void getById() {
        Long userId = 1L;
        User user = userMapperCustom.getById(userId);
        Assert.assertEquals(user.getUserId(), userId);
    }
}