package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/*
标签数据访问接口
JpaRepository 提供基本的CRUD
JpaSpecificationExecutor 用于复杂的条件查询
 */
public interface LabelDao extends JpaRepository<Label,String>,
        JpaSpecificationExecutor<Label> {
}
