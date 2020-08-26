package com.ray.biz.sys.service;

import com.ray.biz.sys.param.UserFindParam;
import com.ray.biz.sys.param.UserSaveParam;
import com.ray.biz.sys.pojo.generator.User;
import com.ray.frame.base.APIResult;
import com.ray.frame.base.BaseBatchDeleteParam;
import com.ray.frame.base.BaseGetParam;
import com.ray.frame.base.BaseResult;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author 作者 xuel
 * @version 创建时间： 2020年08月24日 17:27:19
 * 用户Service接口
 */
@CacheConfig(cacheNames = "user")
public interface IUserService {

    /**
     * 获取用户列表
     *
     * @param param 查询请求
     * @return 查询应答
     */
    APIResult<List<User>> find(UserFindParam param);

    /**
     * 查找用户明细
     *
     * @param param
     * @return
     */
    @Cacheable
    APIResult<User> get(BaseGetParam param);

    /**
     * 保存用户
     *
     * @param param
     * @return
     */
    @CachePut
    BaseResult save(UserSaveParam param);

    /**
     * 删除用户
     *
     * @param param
     * @return
     */
    @CacheEvict()
    APIResult<List<User>> deleteByIds(BaseBatchDeleteParam param);
}
