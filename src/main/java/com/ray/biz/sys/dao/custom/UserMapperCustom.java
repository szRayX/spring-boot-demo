package com.ray.biz.sys.dao.custom;

import com.ray.biz.sys.dao.generator.UserMapper;
import com.ray.biz.sys.param.UserFindParam;
import com.ray.biz.sys.pojo.generator.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 作者 xuel
 * @version 创建时间： 2020年08月24日 17:27:19
 * 用户Mapper自定义
 */
public interface UserMapperCustom extends UserMapper {

    /**
     * 获取用户列表
     *
     * @param param 请求对象
     * @return 实体对象列表集合
     */
    List<User> find(@Param("param") UserFindParam param);

    /**
     * 获取用户列表总数
     *
     * @param param 请求对象
     * @return 实体对象列表集合总数
     */
    long findCount(@Param("param") UserFindParam param);
}
