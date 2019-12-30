package com.bawei.zhangjiafu1707b20191230.mvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.zhangjiafu1707b20191230.mvp.presenter.BasePresenter;
import com.bawei.zhangjiafu1707b20191230.mvp.contract.Contract;

/**
 * @author: 张家辅
 * @date: 2019/12/30
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Contract.IView {
    public P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutid());
        presenter=initPresenter();
        presenter.attach(this);
        initView();
        initData();
    }

    protected abstract P initPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int layoutid();
}
