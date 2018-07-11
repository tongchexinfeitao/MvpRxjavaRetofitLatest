package com.ali.mvpdemo.mvp.home.model;

import com.ali.mvpdemo.mvp.home.model.bean.LoginBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by mumu on 2018/6/12.
 */

public class LoginModelOk {
    public void login(final String account, String password, final ILoginModelCallback iLoginModelCallback) {

        //构建一个OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        //通过表单的形式，构建一个RequestBody，通过添加key-value的形式，上传参数
        RequestBody requestBody = new FormBody.Builder()
                .add("source", "android")
                .add("mobile", account)
                .add("password", password)
                .build();

        //通过我们构造的requestBody对象，去构造一个Request
        Request request = new Request.Builder()
                .url("https://www.zhaoapi.cn/user/login")
                .post(requestBody)
                .build();

        //使用okHttpClient对象执行newCall，传入一个Request，去构造一个call请求
        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //失败
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //联功网请求成
                String json = response.body().string();
                LoginBean loginBean = new Gson().fromJson(json, LoginBean.class);
                String code = loginBean.getCode();
                String msg = loginBean.getMsg();
                if ("0".equalsIgnoreCase(code)) {
                    //登陆成功
                            if(iLoginModelCallback!=null){
                                iLoginModelCallback.onLoginSuccess(loginBean);
                            }
                } else {
                    //登陆失败
                    if(iLoginModelCallback!=null){
                        iLoginModelCallback.onLoginFaild(msg);
                    }
                }
            }

        });
    }



    public interface ILoginModelCallback {
        void onLoginSuccess(LoginBean loginBean);

        void onLoginFaild(String error);
    }

}
