package com.tensquare.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{
    /**
     * 根据标签ID查询最新问题列表
     */
    @Query("select p from Problem  p where id in (select  problemid from pl where labelid=?1) order by  replytime desc ")
    public Page<Problem> findNewListLabelId(String labelId, Pageable pageable);
}
