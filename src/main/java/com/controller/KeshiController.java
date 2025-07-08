package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
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

import com.entity.KeshiEntity;
import com.entity.view.KeshiView;

import com.service.KeshiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

@RestController
@RequestMapping("/keshi")
public class KeshiController {
    @Autowired
    private KeshiService keshiService;
    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KeshiEntity keshi,
		HttpServletRequest request){
        EntityWrapper<KeshiEntity> ew = new EntityWrapper<KeshiEntity>();

		PageUtils page = keshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, keshi), params), params));

        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KeshiEntity keshi){
       	EntityWrapper<KeshiEntity> ew = new EntityWrapper<KeshiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( keshi, "keshi")); 
        return R.ok().put("data", keshiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KeshiEntity keshi){
        EntityWrapper< KeshiEntity> ew = new EntityWrapper< KeshiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( keshi, "keshi")); 
		KeshiView keshiView =  keshiService.selectView(ew);
		return R.ok("查询科室成功").put("data", keshiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KeshiEntity keshi = keshiService.selectById(id);
        return R.ok().put("data", keshi);
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KeshiEntity keshi, HttpServletRequest request){
        if(keshiService.selectCount(new EntityWrapper<KeshiEntity>().eq("keshi", keshi.getKeshi()))>0) {
            return R.error("科室已存在");
        }
    	//ValidatorUtils.validateEntity(keshi);
        keshiService.insert(keshi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KeshiEntity keshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(keshi);
        if(keshiService.selectCount(new EntityWrapper<KeshiEntity>().ne("id", keshi.getId()).eq("keshi", keshi.getKeshi()))>0) {
            return R.error("科室已存在");
        }
        keshiService.updateById(keshi);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        keshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
