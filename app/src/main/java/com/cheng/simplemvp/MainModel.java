package com.cheng.simplemvp;

import com.cheng.simplemvplibrary.Model;

import java.util.List;

import io.reactivex.Observable;

/**
 * 主页（模型）
 */
public interface MainModel extends Model {
    /**
     * 从网络获取数据
     *
     * @return
     */
    Observable<List<UserBean>> getDataFromNet();

    /**
     * 从字符串中获得数据
     *
     * @return
     */
    String getDataFromString();

    /**
     * 停止请求
     */
    void stopRequest();
}
