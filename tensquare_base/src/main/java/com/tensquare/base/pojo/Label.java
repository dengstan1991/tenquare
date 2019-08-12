package com.tensquare.base.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
标签实体类
 */
@Entity
@Table(name="tb_label")
public class Label {
    @Id
    private String id;
    private String labelname;//标签名称
    private String state;//装填
    private Long count;//使用数量
    private Long fans;//关注数
    private String recommend;//是否推荐

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setFans(Long fans) {
        this.fans = fans;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getLabelname() {
        return labelname;
    }

    public String getState() {
        return state;
    }

    public Long getCount() {
        return count;
    }

    public Long getFans() {
        return fans;
    }

    public String getRecommend() {
        return recommend;
    }
}
