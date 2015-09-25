package com.xlab.wonders.fullway.modol;

import android.util.Log;

import com.xlab.wonders.fullway.network.api.QueryAllCourse;
import com.xlab.wonders.fullway.network.entity.CourseResult;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by lixuanwu on 15/9/18.
 */
public class CourseModel {
    private OnCallback onCallback;

    public void setOnCallback(OnCallback onCallback) {
        this.onCallback = onCallback;
    }

    public interface OnCallback<T> {
        void onSuccess(T o);

        void onFail(T o);
    }

    public void get() {

        RestAdapter restAdapter = new RestAdapter.Builder().
                setEndpoint("http://172.16.77.162:8080")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        Callback<CourseResult> callback = new Callback<CourseResult>() {
            @Override
            public void success(CourseResult course, Response response) {
                if (onCallback != null) {
                    onCallback.onSuccess(course);
                }
                Log.d("tag", course.toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("tag", error.toString());
            }
        };

        QueryAllCourse service = restAdapter.create(QueryAllCourse.class);

        service.queryAllCourse(callback);
    }


}
