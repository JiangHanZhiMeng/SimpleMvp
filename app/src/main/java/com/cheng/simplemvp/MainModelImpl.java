package com.cheng.simplemvp;

import android.util.Log;

import com.cheng.simplemvp.utils.AutoLog;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.internal.schedulers.IoScheduler;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * 首页（模型）
 */
public class MainModelImpl implements MainModel {

    interface GitHubService {
        @GET("user.json")
        Observable<List<UserBean>> getUser();
    }

    @Override
    public Observable<List<UserBean>> getDataFromNet() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.icandemy.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(new IoScheduler()))
                .build();
        GitHubService gitHubService = retrofit.create(GitHubService.class);

        return gitHubService.getUser();
    }

    @Override
    public String getDataFromString() {
        return "string data";
    }

    @Override
    public void stopRequest() {
        AutoLog.i("model-stopped", "MainModelImpl stop request...");
    }
}
