package com.bawei.zhangjiafu1707b20191230.mvp.contract;

import com.bawei.zhangjiafu1707b20191230.mvp.model.IBaseModel;
import com.bawei.zhangjiafu1707b20191230.mvp.view.IBaseView;

/**
 * @author: 张家辅
 * @date: 2019/12/30
 */
public interface Contract {
    public interface IView extends IBaseView {
        void success(String name);
        void error(Throwable throwable);
    }
    public interface IModel extends IBaseModel {
        void success(String name,CallBack callBack);
        void error(Throwable throwable);
        interface CallBack{
            void success(String name);
            void error(Throwable throwable);
        }

    }
    public interface Presenter{
        void success(String name);
        void error(Throwable throwable);
    }
}
