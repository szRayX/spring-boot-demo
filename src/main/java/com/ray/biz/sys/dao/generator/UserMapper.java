package com.ray.biz.sys.dao.generator;

import com.ray.biz.sys.pojo.generator.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 作者 xuel
 * @version 创建时间： 2020年08月24日 17:27:19
 * 用户Mapper自动生成
 */
public interface UserMapper {

    User getById(@Param("id") Long id);

    List<User> getListByIds(@Param("list") List<Long> ids);

    int insert(@Param("record") User record);

    int insertBatch(@Param("list") List<User> list);

    int update(@Param("record") User record);

    int updateSelective(@Param("record") User record);

    int delete(@Param("id") Long id);

    int deleteBatch(@Param("list") List<Long> ids);

    Long existById(@Param("id") Long id);
}
