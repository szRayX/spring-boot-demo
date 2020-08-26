package com.ray.frame.base;

import java.util.List;

/**
 * BaseBatchDeleteParam
 *
 * @author xuel
 * @create 2020/8/25 13:57
 * @since 0.0.1
 */
public class BaseBatchDeleteParam extends BaseParam {
    private List<Long> ids;

    public BaseBatchDeleteParam() {
    }

    public List<Long> getIds() {
        return this.ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
