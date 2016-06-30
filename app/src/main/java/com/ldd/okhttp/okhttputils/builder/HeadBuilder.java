package com.ldd.okhttp.okhttputils.builder;

import com.ldd.okhttp.okhttputils.OkHttpUtils;
import com.ldd.okhttp.okhttputils.request.OtherRequest;
import com.ldd.okhttp.okhttputils.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
