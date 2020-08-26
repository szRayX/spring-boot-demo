package com.ray.biz.sys.pojo.generator;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author 作者 xuel
 * @version 创建时间： 2020年08月24日 17:27:19
 * 用户pojo自动生成
 */
@Getter
@Setter
public class User {

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 归属单位
     */
    private Long companyId;

    /**
     * 归属部门
     */
    private Long officeId;

    /**
     * 是否是公司负责人（0不是，1是）
     */
    private Boolean isCompanyManager;

    /**
     * 是否是部门负责人（0不是，1是）
     */
    private Boolean isOfficeManager;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 工号
     */
    private String jobNumber;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别（0女，1男）
     */
    private Boolean gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 民族,code=103
     */
    private String nation;

    /**
     * 文化程度，code=104
     */
    private String education;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 电话
     */
    private String phone;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 学校/单位/社区
     */
    private String unit;

    /**
     * 住址
     */
    private String address;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 是否启用(0禁用，1启用)
     */
    private Boolean useable;

    /**
     * 数据来源（code=002）
     */
    private String sourceType;

    /**
     * 人员类型（code=017
     */
    private String userType;

    /**
     * 代理人
     */
    private Long agentUser;

    /**
     * 是否是超级管理员（0：不是，1：是）
     */
    private Boolean isAdmin;

    /**
     * 删除标示
     */
    private Boolean delFlag;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
}
