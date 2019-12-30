package com.bawei.zhangjiafu1707b20191230.mvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.zhangjiafu1707b20191230.R;
import com.bawei.zhangjiafu1707b20191230.mvp.base.BaseActivity;
import com.bawei.zhangjiafu1707b20191230.mvp.presenter.Presenter;

public class MainActivity extends BaseActivity<Presenter> {

    private EditText name00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name00 = findViewById(R.id.name00);
    }

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initData() {
    presenter.success("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=1&page=1&count=5");
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int layoutid() {
        return R.layout.activity_main;
    }


    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void success(String name) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        name00.setText(name);
    }

    @Override
    public void error(Throwable throwable) {

    }
}
