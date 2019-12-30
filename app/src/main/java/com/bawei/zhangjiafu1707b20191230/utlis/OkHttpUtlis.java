package com.bawei.zhangjiafu1707b20191230.utlis;

import android.os.Handler;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author: 张家辅
 * @date: 2019/12/30
 */
public class OkHttpUtlis {
    private static OkHttpUtlis okHttpUtlis;
    private final OkHttpClient okHttpClient;
    Handler handler=new Handler();

    public OkHttpUtlis() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .readTimeout(3, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpUtlis getInstance() {
        if(okHttpUtlis==null){
            synchronized (OkHttpUtlis.class){
                okHttpUtlis=new OkHttpUtlis();
            }
        }
        return okHttpUtlis;
    }
    public void doGet(String URL, final CallBack callBack){
        Request request = new Request.Builder()
                .get()
                .url(URL)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.error(e);
                    }
                });
            }

            @Override
            public void onResponse(final Call call, final Response response) throws IOException {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            callBack.success(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

    }
    public interface CallBack{
        void success(String name);
        void error(Throwable throwable);
    }
}
