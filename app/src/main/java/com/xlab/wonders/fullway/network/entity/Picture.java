package com.xlab.wonders.fullway.network.entity;

/**
 * Created by lixuanwu on 15/9/18.
 */
public class Picture {

    private Long id;

    /**
     * 图片名称
     */
    private String name;

    /**
     * 图片链接
     */
    private String url;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 图片高度
     */
    private Integer height;
    /**
     * 图片宽度
     */
    private Integer width;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
