package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * 业务逻辑
 */
@Service
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部标签
     */
    public List<Label> findAll(){
        return labelDao.findAll();
    }
    /*
    根据id查询
     */
    public Label findById(String id){
        return labelDao.findById(id).get();
    }
    /**
     * 增加
     */
    public void add(Label label){
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }
    /**
     * 修改
     */
    public void update(Label label){
        labelDao.save(label);
    }
    /**
     * 删除
     */
    public void deleteById(String id){
        labelDao.deleteById(id);
    }
}
