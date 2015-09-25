package com.xlab.wonders.fullway.network.api;

import com.xlab.wonders.fullway.network.entity.CourseResult;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by lixuanwu on 15/9/18.
 */
public interface QueryAllCourse {


    @GET("/course/studentQueryAllCourse")
    void queryAllCourse(Callback<CourseResult> callback);
}
