package com.controller;

import java.util.Arrays;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

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

import com.entity.view.FuwuzhipaiView;

import com.service.FuwuzhipaiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/
@RestController
@RequestMapping("/fuwuzhipai")
public class FuwuzhipaiController {
    @Autowired
    private FuwuzhipaiService fuwuzhipaiService;




    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FuwuzhipaiEntity fuwuzhipai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			fuwuzhipai.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("shequyisheng")) {
			fuwuzhipai.setYishenggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FuwuzhipaiEntity> ew = new EntityWrapper<FuwuzhipaiEntity>();

		PageUtils page = fuwuzhipaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuzhipai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FuwuzhipaiEntity fuwuzhipai, 
		HttpServletRequest request){
        EntityWrapper<FuwuzhipaiEntity> ew = new EntityWrapper<FuwuzhipaiEntity>();

		PageUtils page = fuwuzhipaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuzhipai), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FuwuzhipaiEntity fuwuzhipai){
       	EntityWrapper<FuwuzhipaiEntity> ew = new EntityWrapper<FuwuzhipaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fuwuzhipai, "fuwuzhipai")); 
        return R.ok().put("data", fuwuzhipaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FuwuzhipaiEntity fuwuzhipai){
        EntityWrapper< FuwuzhipaiEntity> ew = new EntityWrapper< FuwuzhipaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fuwuzhipai, "fuwuzhipai")); 
		FuwuzhipaiView fuwuzhipaiView =  fuwuzhipaiService.selectView(ew);
		return R.ok("查询服务指派成功").put("data", fuwuzhipaiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FuwuzhipaiEntity fuwuzhipai = fuwuzhipaiService.selectById(id);
        return R.ok().put("data", fuwuzhipai);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FuwuzhipaiEntity fuwuzhipai = fuwuzhipaiService.selectById(id);
        return R.ok().put("data", fuwuzhipai);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FuwuzhipaiEntity fuwuzhipai, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fuwuzhipai);
        fuwuzhipaiService.insert(fuwuzhipai);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FuwuzhipaiEntity fuwuzhipai, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fuwuzhipai);
        fuwuzhipaiService.insert(fuwuzhipai);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FuwuzhipaiEntity fuwuzhipai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwuzhipai);
        fuwuzhipaiService.updateById(fuwuzhipai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fuwuzhipaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
