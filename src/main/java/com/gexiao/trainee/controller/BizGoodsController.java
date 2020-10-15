package com.gexiao.trainee.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.gexiao.trainee.entity.BizGoods;
import com.gexiao.trainee.service.IBizGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author gexiao
 * @since 2020-10-15
 */
@Slf4j
@RestController
@RequestMapping("/biz-goods")
public class BizGoodsController {
    @Autowired
    private IBizGoodsService goodsService;
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public Object add(@RequestBody BizGoods goods) {
        log.info("新增商品：goods = {}", JSON.toJSONString(goods));
        return goodsService.save(goods);
    }
    @PutMapping("update")
    @Transactional(rollbackFor = Exception.class)
    public Object update(@RequestBody BizGoods goods){
        log.info("修改商品：goods = {}", JSON.toJSONString(goods));
        return goodsService.update(goods,new LambdaUpdateWrapper<BizGoods>().eq(BizGoods::getId,goods.getId()));
    }
}
