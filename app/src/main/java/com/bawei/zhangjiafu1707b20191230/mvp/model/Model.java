package com.bawei.zhangjiafu1707b20191230.mvp.model;

import com.bawei.zhangjiafu1707b20191230.mvp.contract.Contract;
import com.bawei.zhangjiafu1707b20191230.utlis.OkHttpUtlis;

/**
 * @author: 张家辅
 * @date: 2019/12/30
 */
public class Model implements Contract.IModel {

    @Override
    public void success(String name, final CallBack callBack) {
        OkHttpUtlis.getInstance().doGet(name, new OkHttpUtlis.CallBack() {
            @Override
            public void success(String name) {
                callBack.success(name);
            }

            @Override
            public void error(Throwable throwable) {
            callBack.error(throwable);
            }
        });
    }

    @Override
    public void error(Throwable throwable) {

    }
}
