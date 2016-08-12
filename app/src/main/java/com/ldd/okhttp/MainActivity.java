package com.ldd.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ldd.okhttp.okhttputils.OkHttpUtils;
import com.ldd.okhttp.okhttputils.callback.Callback;
import com.ldd.okhttp.okhttputils.callback.StringCallback;
import com.ldd.okhttp.utils.RemoteApi;
import com.ldd.okhttp.utils.RemoteApiIml;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpUtils.get()
                .url("http://web.juhe.cn:8080/environment/water/river?river=%E9%95%BF%E6%B1%9F%E6%B5%81%E5%9F%9F&key=1cc0e9ff477af245eea2645ef5bb8e01")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.i(TAG, "response exception = " + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i(TAG, "response string = " + response);
                    }
                });

        Log.i(TAG,"main thread id is "+Thread.currentThread().getId());
        String url = "https://api.github.com/";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                // 注：该回调是子线程，非主线程
                Log.i(TAG, "callback thread id is " + Thread.currentThread().getId());
                Log.i(TAG, response.body().string() + "callback thread id is ="+response);
            }
        });
                OkHttpUtils.post()
                        .url("http://dev.mantoto.com//Json/UserResetPassword.aspx")
                        .addParams("userid","10417")
                        .addParams("password","123456")
                        .addParams("newpassword","1234567")
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                                Log.i(TAG, "response exception = " + e.getMessage());
                            }

                            @Override
                            public void onResponse(String response, int id) {
                                Log.i(TAG, "response altepassword = " + response);
                            }
                        });

        OkHttpUtils.post()
                .url("http://dev.mantoto.com/Json/UserVerify.aspx")
                .addParams("username","13552662536")
                .addParams("password","123456")
                .addParams("softtype","1")
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i(TAG, "response exception = " + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                Log.i(TAG, "response login = " + response);
            }
        });
    }
}
