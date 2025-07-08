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

import com.entity.ShequyishengEntity;
import com.entity.view.ShequyishengView;

import com.service.ShequyishengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;


@RestController
@RequestMapping("/shequyisheng")
public class ShequyishengController {
    @Autowired
    private ShequyishengService shequyishengService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		ShequyishengEntity u = shequyishengService.selectOne(new EntityWrapper<ShequyishengEntity>().eq("yishenggonghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"shequyisheng",  "社区医生" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ShequyishengEntity shequyisheng){
    	//ValidatorUtils.validateEntity(shequyisheng);
    	ShequyishengEntity u = shequyishengService.selectOne(new EntityWrapper<ShequyishengEntity>().eq("yishenggonghao", shequyisheng.getYishenggonghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		shequyisheng.setId(uId);
        shequyishengService.insert(shequyisheng);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        ShequyishengEntity u = shequyishengService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	ShequyishengEntity u = shequyishengService.selectOne(new EntityWrapper<ShequyishengEntity>().eq("yishenggonghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        shequyishengService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShequyishengEntity shequyisheng,
		HttpServletRequest request){
        EntityWrapper<ShequyishengEntity> ew = new EntityWrapper<ShequyishengEntity>();

		PageUtils page = shequyishengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shequyisheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShequyishengEntity shequyisheng, 
		HttpServletRequest request){
        EntityWrapper<ShequyishengEntity> ew = new EntityWrapper<ShequyishengEntity>();

		PageUtils page = shequyishengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shequyisheng), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShequyishengEntity shequyisheng){
       	EntityWrapper<ShequyishengEntity> ew = new EntityWrapper<ShequyishengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shequyisheng, "shequyisheng")); 
        return R.ok().put("data", shequyishengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShequyishengEntity shequyisheng){
        EntityWrapper< ShequyishengEntity> ew = new EntityWrapper< ShequyishengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shequyisheng, "shequyisheng")); 
		ShequyishengView shequyishengView =  shequyishengService.selectView(ew);
		return R.ok("查询社区医生成功").put("data", shequyishengView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShequyishengEntity shequyisheng = shequyishengService.selectById(id);
        return R.ok().put("data", shequyisheng);
    }


    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShequyishengEntity shequyisheng, HttpServletRequest request){
    	shequyisheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shequyisheng);
    	ShequyishengEntity u = shequyishengService.selectOne(new EntityWrapper<ShequyishengEntity>().eq("yishenggonghao", shequyisheng.getYishenggonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		shequyisheng.setId(new Date().getTime());
        shequyishengService.insert(shequyisheng);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShequyishengEntity shequyisheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shequyisheng);
        shequyishengService.updateById(shequyisheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shequyishengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    


}
