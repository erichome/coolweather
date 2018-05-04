package com.example.eric.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Http工具类
 * Created by eric on 2018/5/4.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String url,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }
}
