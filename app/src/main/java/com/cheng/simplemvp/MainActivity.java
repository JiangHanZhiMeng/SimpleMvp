package com.cheng.simplemvp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cheng.simplemvp.utils.AutoLog;

public class MainActivity extends BaseActivity<MainModel, MainView, MainPresenter> implements MainView {
    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoLog.v("绑定布局");

        tvData = findViewById(R.id.tv_data);
        Button btnFirst = findViewById(R.id.btn_first);

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        init();
    }

    @Override
    public MainPresenter createPresenter() {
        AutoLog.v("实例控制");
        return new MainPresenter();
    }

    @Override
    public MainModel createModel() {
        AutoLog.v("实例模型");
        return new MainModelImpl();
    }

    @Override
    public MainView createView() {
        AutoLog.v("实例视图");
        return this;
    }

    private void init() {
        AutoLog.v("初始化");
        if (presenter != null) {
            presenter.getData();
        }
    }

    @Override
    public void setData(String str) {
        AutoLog.v("填充数据");
        tvData.setText(str);
    }

    @Override
    public void showToast(String info) {

    }

    @Override
    public void showProgress() {

    }
}
