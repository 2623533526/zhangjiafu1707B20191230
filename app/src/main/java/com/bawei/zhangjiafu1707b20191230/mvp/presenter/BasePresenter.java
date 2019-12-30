package com.bawei.zhangjiafu1707b20191230.mvp.presenter;

import com.bawei.zhangjiafu1707b20191230.mvp.model.IBaseModel;
import com.bawei.zhangjiafu1707b20191230.mvp.view.IBaseView;

import java.lang.ref.WeakReference;

/**
 * @author: 张家辅
 * @date: 2019/12/30
 */
public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> {
    public M model;
    private WeakReference<V> weakReference;

    public BasePresenter() {
        model=initModel();
    }
    public void attach(V v){
        weakReference=new WeakReference<V>(v);
    }
    public void detach(){
        weakReference.clear();
    }
    public V getView(){
        return weakReference.get();
    }

    protected abstract M initModel();
}
