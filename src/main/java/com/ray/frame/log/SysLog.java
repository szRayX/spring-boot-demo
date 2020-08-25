package com.ray.frame.log;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * SysLog
 *
 * @author xuel
 * @create 2020/8/25 10:35
 * @since 0.0.1
 */
@Setter
@Getter
@ToString
public class SysLog implements Serializable {

    private static final long serialVersionUID = -6309732882044872298L;

    private Integer id;
    private String level;
    private String username;
    private String operation;
    private Integer time;
    private String method;
    private String params;
    private String ip;
    private String content;
    private Date createTime;
}
