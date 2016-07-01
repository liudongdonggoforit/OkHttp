package com.ldd.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ldd.okhttp.okhttputils.OkHttpUtils;
import com.ldd.okhttp.okhttputils.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpUtils.post()
                .url("http://service.mantoto.com/Json/UserVerify.aspx")
                .addParams("username","13552662536")
                .addParams("password","123456")
                .addParams("softtype","1")
                .build().execute(new Callback() {
            @Override
            public Object parseNetworkResponse(Response response, int id) throws Exception {
                Log.i(TAG,"response paseNetworkResponse = " +response);
                return response;
            }

            @Override
            public void onError(Call call, Exception e, int id) {
                Log.i(TAG,"Exception = " + e.getMessage());
            }

            @Override
            public void onResponse(Object response, int id) {
                Log.i(TAG,"Response = " +response);
            }
        });
    }
}
