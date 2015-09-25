package com.xlab.wonders.fullway.network.entity;

import java.util.List;

/**
 * Created by lixuanwu on 15/9/18.
 */
public class CourseResult extends BaseEntity {

    private List<Course>ret_values;

    public static class Course{

        private long id;
        /**
         * 课程的价格
         */
        private String coursePrice;
        /**
         * 课程的原价
         */
        private String courseOriginPrice;
        /**
         * 课程所属老师
         */
        private Teacher teacher;


        private long teacherId;

        /**
         * 课程名
         */
        private String courseName;
        /**
         * 受众
         */
        private String courseAudience;

        /**
         * 课程状态
         */
        private String courseStatus;
        /**
         * 上课时间
         */
        private String courseTime;
        /**
         * 课程详细
         */
        private String courseDetail;
        /**
         * 课程简介
         */
        private String introduction;
        /**
         * 上课地点
         */
        private String coursePlace;
        /**
         * 背景图片
         */
        private String backgroundPicture;

        /**
         * 课程图片
         */
        private List<Picture> pictures;

        /**
         * 授课方式
         */
        private String courseWay;

        /**
         * 支付方式
         */
        private String payWay;

        /**
         * 支付方式地址
         */
        private String payWayUrl;

        /**
         * 最低开课人数
         */
        private String minNumber;

        /**
         * 当前已报名的人数
         */
        private Integer currentNumber;

        /**
         * 课程类型
         */
        private String courseType;

        /**
         * 课程所需最短时间
         */
        private String shortestTime;

        /**
         * 课程所需最长时间
         */
        private String longestTime;
        /**
         * 报名结束时间
         */
        private String endTime;
        /**
         * 注册时间
         */
        private String registrationTime;
        /**
         * 更新时间
         */
        private String updateTime;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCoursePrice() {
            return coursePrice;
        }

        public void setCoursePrice(String coursePrice) {
            this.coursePrice = coursePrice;
        }

        public String getCourseOriginPrice() {
            return courseOriginPrice;
        }

        public void setCourseOriginPrice(String courseOriginPrice) {
            this.courseOriginPrice = courseOriginPrice;
        }

        public Teacher getTeacher() {
            return teacher;
        }

        public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
        }

        public long getTeacherId() {
            return teacherId;
        }

        public void setTeacherId(long teacherId) {
            this.teacherId = teacherId;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getCourseAudience() {
            return courseAudience;
        }

        public void setCourseAudience(String courseAudience) {
            this.courseAudience = courseAudience;
        }

        public String getCourseStatus() {
            return courseStatus;
        }

        public void setCourseStatus(String courseStatus) {
            this.courseStatus = courseStatus;
        }

        public String getCourseTime() {
            return courseTime;
        }

        public void setCourseTime(String courseTime) {
            this.courseTime = courseTime;
        }

        public String getCourseDetail() {
            return courseDetail;
        }

        public void setCourseDetail(String courseDetail) {
            this.courseDetail = courseDetail;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getCoursePlace() {
            return coursePlace;
        }

        public void setCoursePlace(String coursePlace) {
            this.coursePlace = coursePlace;
        }

        public String getBackgroundPicture() {
            return backgroundPicture;
        }

        public void setBackgroundPicture(String backgroundPicture) {
            this.backgroundPicture = backgroundPicture;
        }

        public List<Picture> getPictures() {
            return pictures;
        }

        public void setPictures(List<Picture> pictures) {
            this.pictures = pictures;
        }

        public String getCourseWay() {
            return courseWay;
        }

        public void setCourseWay(String courseWay) {
            this.courseWay = courseWay;
        }

        public String getPayWay() {
            return payWay;
        }

        public void setPayWay(String payWay) {
            this.payWay = payWay;
        }

        public String getPayWayUrl() {
            return payWayUrl;
        }

        public void setPayWayUrl(String payWayUrl) {
            this.payWayUrl = payWayUrl;
        }

        public String getMinNumber() {
            return minNumber;
        }

        public void setMinNumber(String minNumber) {
            this.minNumber = minNumber;
        }

        public Integer getCurrentNumber() {
            return currentNumber;
        }

        public void setCurrentNumber(Integer currentNumber) {
            this.currentNumber = currentNumber;
        }

        public void setCourseType(String courseType) {
            this.courseType = courseType;
        }

        public String getShortestTime() {
            return shortestTime;
        }

        public void setShortestTime(String shortestTime) {
            this.shortestTime = shortestTime;
        }

        public String getLongestTime() {
            return longestTime;
        }

        public void setLongestTime(String longestTime) {
            this.longestTime = longestTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getRegistrationTime() {
            return registrationTime;
        }

        public void setRegistrationTime(String registrationTime) {
            this.registrationTime = registrationTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getCourseType() {
            return courseType;
        }
    }

    public List<Course> getRet_values() {
        return ret_values;
    }

    public void setRet_values(List<Course> ret_values) {
        this.ret_values = ret_values;
    }
}
