package com.tensquare.article.pojo;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/*
文章评论
 */
public class Comment  implements Serializable {
    @Id
    private String _id;
    private String articleid;
    private String content;
    private String userid;
    private String parentid;
    private Date publishdate;

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public String get_id() {
        return _id;
    }

    public String getArticleid() {
        return articleid;
    }

    public String getContent() {
        return content;
    }

    public String getUserid() {
        return userid;
    }

    public String getParentid() {
        return parentid;
    }

    public Date getPublishdate() {
        return publishdate;
    }
}
