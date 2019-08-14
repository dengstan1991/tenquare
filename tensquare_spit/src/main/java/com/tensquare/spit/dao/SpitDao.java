package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 数据层--吐槽
 */
public interface SpitDao extends MongoRepository<Spit,String> {

}
