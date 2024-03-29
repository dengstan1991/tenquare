package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {
    @Autowired
    private SpitService spitService;
    @Autowired
    private RedisTemplate redisTemplate;

    /*
    find all
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",spitService.findAll());
    }

    /*
    find by id
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findOne(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",spitService.findById(id));
    }
    /**
     * add
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Spit spit){
        spitService.add(spit);
        return new Result(true,StatusCode.OK,"增加成功");
    }
    /**
     * update
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public Result update(@RequestBody Spit spit,@PathVariable String id){
        spit.set_id(id);
        spitService.update(spit);
        return new Result(true,StatusCode.OK,"修改成功");
    }
    /**
     * delete
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        spitService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
    /**
     * 根据上级id查询吐槽分页数据
     */
    @RequestMapping(value = "/comment/{parentId}/{page}/{size}",method = RequestMethod.GET)
    public Result findByParentid(@PathVariable String parentId,@PathVariable int page,@PathVariable int size){
        Page<Spit> pagelist=spitService.findByParentid(parentId,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Spit>(pagelist.getTotalElements(),pagelist.getContent()));
    }
    /*
    点赞,但是需要过滤重复点赞
     */
    @RequestMapping(value = "/thumbup/{id}",method = RequestMethod.PUT)
//    public Result updateThumbup(@PathVariable String id){
//        spitService.updateThumbup(id);
//        return new Result(true,StatusCode.OK,"点赞成功");
//    }
    public Result updateThumbup(@PathVariable String id){
        //判断是否点过赞
        String userid="2023";
        if(redisTemplate.opsForValue().get("thumbup_"+userid+"_"+id)!=null){
            return new Result(false,StatusCode.REPERROR,"你已经点过赞了");
        }
        spitService.updateThumbup(id);
        redisTemplate.opsForValue().set("thumbup_"+userid+"_"+id,"1");
        return new Result(true,StatusCode.OK,"点赞成功");
    }
}
