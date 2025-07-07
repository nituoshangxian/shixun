package com.controller;


import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.StoreupEntity;
import com.entity.view.StoreupView;

import com.service.StoreupService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

@RestController
@RequestMapping("/storeup")
public class StoreupController {
    @Autowired
    private StoreupService storeupService;

    //收藏

    //分页列表
    //管理员可查看全部收藏，用户只能查看自己的收藏
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,StoreupEntity storeup,
		HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            storeup.setUserid((Long)request.getSession().getAttribute("userId"));
        }
        EntityWrapper<StoreupEntity> ew = new EntityWrapper<StoreupEntity>();

		PageUtils page = storeupService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, storeup), params), params));

        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( StoreupEntity storeup){
       	EntityWrapper<StoreupEntity> ew = new EntityWrapper<StoreupEntity>();
      	ew.allEq(MPUtil.allEQMapPre( storeup, "storeup")); 
        return R.ok().put("data", storeupService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(StoreupEntity storeup){
        EntityWrapper< StoreupEntity> ew = new EntityWrapper< StoreupEntity>();
 		ew.allEq(MPUtil.allEQMapPre( storeup, "storeup")); 
		StoreupView storeupView =  storeupService.selectView(ew);
		return R.ok("查询收藏表成功").put("data", storeupView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        StoreupEntity storeup = storeupService.selectById(id);
        return R.ok().put("data", storeup);
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody StoreupEntity storeup, HttpServletRequest request){
    	storeup.setUserid((Long)request.getSession().getAttribute("userId"));
        storeupService.insert(storeup);
        return R.ok();
    }

     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        StoreupEntity storeup = storeupService.selectOne(new EntityWrapper<StoreupEntity>().eq("", username));
        return R.ok().put("data", storeup);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody StoreupEntity storeup, HttpServletRequest request){
        //ValidatorUtils.validateEntity(storeup);
        storeupService.updateById(storeup);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        storeupService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
