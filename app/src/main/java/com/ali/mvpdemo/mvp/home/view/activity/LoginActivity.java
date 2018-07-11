package com.ali.mvpdemo.mvp.home.view.activity;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.ali.mvpdemo.R;
import com.ali.mvpdemo.base.BaseActivity;
import com.ali.mvpdemo.mvp.home.model.bean.LoginBean;
import com.ali.mvpdemo.mvp.home.presenter.LoginPresenterOk;
import com.ali.mvpdemo.mvp.home.view.iview.ILoginView;

public class LoginActivity extends BaseActivity<LoginPresenterOk> implements View.OnClickListener, ILoginView {


    @Override
    protected LoginPresenterOk providePresenter() {
        return new LoginPresenterOk(this);
    }

    @Override
    protected void initListener() {
        findViewById(R.id.login).setOnClickListener(this);
    }


    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }


    //登陆
    @Override
    public void onClick(View v) {
        presenter.login("15501186523", "123456");
    }

    @Override
    public void onLoginSuccess(final LoginBean loginBean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, "登陆成功 ：" + loginBean.getData().getMobile(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onLoginFaild(final String error) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, "登陆失败 : " + error, Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public Context cotext() {
        return this;
    }
}
