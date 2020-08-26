package com.ray.frame.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * BaseGetParam
 *
 * @author xuel
 * @create 2020/8/25 13:56
 * @since 0.0.1
 */
@Setter
@Getter
@ToString
public class BaseGetParam extends BaseParam {
    private Long id;

    public BaseGetParam() {
    }
}
