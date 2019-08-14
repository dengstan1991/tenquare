package com.tensquare.qa.pojo;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_pl")
public class pl  implements Serializable {

    @Id
    private String problemid;

    @Id
    private String labelid;

    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }

    public void setLabelid(String labelid) {
        this.labelid = labelid;
    }

    public String getProblemid() {
        return problemid;
    }

    public String getLabelid() {
        return labelid;
    }
}
