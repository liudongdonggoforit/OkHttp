package com.ldd.okhttp.utils;

import com.ldd.okhttp.okhttputils.OkHttpUtils;
import com.ldd.okhttp.okhttputils.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Mr.liu
 * On 2016/7/4
 * At 11:12
 * OkHttp
 */
public class RemoteApiIml implements RemoteApi {
    @Override
    public User getData(String url,String user,String password) {
        OkHttpUtils.get()
                .url("")
                .addParams("","")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {

                    }
                });
        return null;
    }
}
