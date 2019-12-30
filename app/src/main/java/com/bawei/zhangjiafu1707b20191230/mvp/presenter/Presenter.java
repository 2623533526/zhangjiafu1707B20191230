package com.bawei.zhangjiafu1707b20191230.mvp.presenter;

import android.media.midi.MidiOutputPort;

import com.bawei.zhangjiafu1707b20191230.mvp.contract.Contract;
import com.bawei.zhangjiafu1707b20191230.mvp.model.Model;

/**
 * @author: 张家辅
 * @date: 2019/12/30
 */
public class Presenter extends BasePresenter<Model, Contract.IView> implements Contract.Presenter{
    @Override
    protected Model initModel() {
        return new Model();
    }

    @Override
    public void success(String name) {
        model.success(name, new Contract.IModel.CallBack() {
            @Override
            public void success(String name) {
                getView().success(name);
            }

            @Override
            public void error(Throwable throwable) {
              getView().error(throwable);
            }
        });
    }

    @Override
    public void error(Throwable throwable) {

    }
}
