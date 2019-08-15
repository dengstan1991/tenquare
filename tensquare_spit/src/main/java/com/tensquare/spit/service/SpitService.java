package com.tensquare.spit.service;


import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.Date;
import java.util.List;

@Service
public class SpitService {
    @Autowired
    private SpitDao spitDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private MongoTemplate mongoTemplate;
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
//        spit.set_id(idWorker.nextId()+"");
        spit.set_id(idWorker.nextId()+"");
        //发布时间
        spit.setPublishtime(new Date());
        spit.setVisits(0);
        spit.setShare(0);
        spit.setThumbup(0);
        spit.setComment(0);
        spit.setShare(1);
        if(spit.getParentid()!=null&&!"".equals(spit.getParentid())){
            Query query=new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update=new Update();
            update.inc("comment",1);
            mongoTemplate.updateFirst(query,update,"spit");

        }
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
    /**
     * 根据上级ID查询吐槽列表
     */
    public Page<Spit> findByParentid(String parentid,int page,int size){
        PageRequest pageRequest=PageRequest.of(page-1,size);
        return spitDao.findByParentid(parentid,pageRequest);
    }
    /*
    点赞,只需将点赞数加1，没必要查询所有子墩更新操作，但是效率低下
     */
//    public void updateThumbup(String id){
//        Spit spit=spitDao.findById(id).get();
//        spit.setThumbup(spit.getThumbup()+1);
//        spitDao.save(spit);
//    }
    public void updateThumbup(String id){
        Query query=new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update=new Update();
        update.inc("thumbup",1);
        mongoTemplate.updateFirst(query,update,"spit");
    }
}
