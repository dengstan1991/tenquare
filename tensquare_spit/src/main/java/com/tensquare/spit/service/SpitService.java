package com.tensquare.spit.service;


import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service
public class SpitService {
    @Autowired
    private SpitDao spitDao;
    @Autowired
    private IdWorker idWorker;

    /*
    查询全部记录
     */
    public List<Spit> findAll(){
        return spitDao.findAll();
    }
    /*
    根据id查询
     */
    public Spit findById(String id){
        Spit spit=spitDao.findById(id).get();
                return spit;
    }
    /*
    add
     */
    public void add(Spit spit){
        spit.set_id(idWorker.nextId()+"");
        spitDao.save(spit);
    }
    /*
    update
     */
    public void update(Spit spit){
        spitDao.save(spit);
    }
    /*
    delete
     */
    public void deleteById(String id){
        spitDao.deleteById(id);
    }
}
