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
        OkHttpUtils.post().url("http://dev.mantoto.com//Json/PromotionProductGet.aspx")
                .addParams("livingitemid","326")
                .build().execute(new Callback() {
            @Override
            public Object parseNetworkResponse(Response response, int id) throws Exception {
                Log.i(TAG,"response paseNetworkResponse = " +response);
                return null;
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
