package com.ray.biz.sys.service.impl;

import com.ray.biz.sys.dao.custom.UserMapperCustom;
import com.ray.biz.sys.param.UserFindParam;
import com.ray.biz.sys.param.UserSaveParam;
import com.ray.biz.sys.pojo.generator.User;
import com.ray.biz.sys.service.IUserService;
import com.ray.frame.base.APIResult;
import com.ray.frame.base.BaseBatchDeleteParam;
import com.ray.frame.base.BaseGetParam;
import com.ray.frame.base.BaseResult;
import com.ray.frame.consts.ResultPacketCode;
import com.ray.frame.util.SFIDGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 作者 xuel
 * @version 创建时间： 2018年06月23日 16:29:56
 * 用户Service实现
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapperCustom userMapperCustom;

    @Override
    public APIResult<List<User>> find(UserFindParam param) {
        APIResult<List<User>> result = new APIResult<>();
        List<User> entityList = new ArrayList<>();
        long count = userMapperCustom.findCount(param);
//		Pager pager = new Pager(param.getPageIndex(), count);
//		result.setPager(pager);
        if (count > 0) {
            entityList = userMapperCustom.find(param);
        }
        result.setResult(entityList);
        result.setCode(ResultPacketCode.APIResultCode.Success.getCode());

        return result;
    }

    @Override
    public APIResult<User> get(BaseGetParam param) {
        APIResult<User> result = new APIResult<>();
        User entity = userMapperCustom.getById(param.getId());
        if (entity == null) {
            result.setCode(ResultPacketCode.APIResultCode.Fail.getCode());
            result.setMessage("记录不存在");
            return result;
        }
        result.setCode(ResultPacketCode.APIResultCode.Success.getCode());
        result.setResult(entity);
        return result;
    }

    @Override
    public BaseResult save(UserSaveParam param) {
        BaseResult result = new BaseResult();
        User user = new User();
        BeanUtils.copyProperties(param, user);

        int effectCount;
        if (user.getUserId() != null) {
            effectCount = userMapperCustom.update(user);
            if (effectCount < 1) {
                result.setCode(ResultPacketCode.APIResultCode.Fail.getCode());
                result.setMessage("更新信息失败");
                return result;
            }
        } else {
            //自动生成ID
            user.setUserId(SFIDGenerator.nextId());
            user.setCreateDate(new Date());
            effectCount = userMapperCustom.insert(user);
            if (effectCount < 1) {
                result.setCode(ResultPacketCode.APIResultCode.Fail.getCode());
                result.setMessage("插入信息失败");
                return result;
            }
        }
        result.setCode(ResultPacketCode.APIResultCode.Success.getCode());
        return result;
    }

    @Override
    public APIResult<List<User>> deleteByIds(BaseBatchDeleteParam param) {
        APIResult<List<User>> result = new APIResult<>();
        //影响行数
        int effectCount = userMapperCustom.deleteBatch(param.getIds());
        if (effectCount != param.getIds().size()) {
            result.setCode(ResultPacketCode.APIResultCode.Fail.getCode());
            result.setMessage("删除失败");
            return result;
        }
        result.setCode(ResultPacketCode.APIResultCode.Success.getCode());
        return result;
    }
}
