package com.tensquare.search.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * 搜索实体类文章
 */
@Document(indexName = "tensquare",type = "article")
public class Article  implements Serializable {
    @Id
    private String id;

    @Field(index=true,analyzer ="ik_max_word",searchAnalyzer = "ik_max_word")
    private String title;//标题

    @Field(index=true,analyzer ="ik_max_word",searchAnalyzer = "ik_max_word")
    private String content;//正文

    private String state;//审核状态

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getState() {
        return state;
    }
}
