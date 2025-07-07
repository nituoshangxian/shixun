package com.entity.vo;

import com.entity.TijianbaogaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

public class TijianbaogaoVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 联系方式
	 */
	
	private String lianxifangshi;
		
	/**
	 * 脏器功能
	 */
	
	private String zangqigongneng;
		
	/**
	 * 查体
	 */
	
	private String chati;
		
	/**
	 * 健康问题
	 */
	
	private String jiankangwenti;
		
	/**
	 * 中医体质
	 */
	
	private String zhongyitizhi;
		
	/**
	 * 辅助检查
	 */
	
	private String fuzhujiancha;
		
	/**
	 * 健康评价
	 */
	
	private String jiankangpingjia;
		
	/**
	 * 健康指导
	 */
	
	private String jiankangzhidao;
		
	/**
	 * 体检日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date tijianriqi;
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
				
	
	/**
	 * 设置：联系方式
	 */
	 
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
				
	
	/**
	 * 设置：脏器功能
	 */
	 
	public void setZangqigongneng(String zangqigongneng) {
		this.zangqigongneng = zangqigongneng;
	}
	
	/**
	 * 获取：脏器功能
	 */
	public String getZangqigongneng() {
		return zangqigongneng;
	}
				
	
	/**
	 * 设置：查体
	 */
	 
	public void setChati(String chati) {
		this.chati = chati;
	}
	
	/**
	 * 获取：查体
	 */
	public String getChati() {
		return chati;
	}
				
	
	/**
	 * 设置：健康问题
	 */
	 
	public void setJiankangwenti(String jiankangwenti) {
		this.jiankangwenti = jiankangwenti;
	}
	
	/**
	 * 获取：健康问题
	 */
	public String getJiankangwenti() {
		return jiankangwenti;
	}
				
	
	/**
	 * 设置：中医体质
	 */
	 
	public void setZhongyitizhi(String zhongyitizhi) {
		this.zhongyitizhi = zhongyitizhi;
	}
	
	/**
	 * 获取：中医体质
	 */
	public String getZhongyitizhi() {
		return zhongyitizhi;
	}
				
	
	/**
	 * 设置：辅助检查
	 */
	 
	public void setFuzhujiancha(String fuzhujiancha) {
		this.fuzhujiancha = fuzhujiancha;
	}
	
	/**
	 * 获取：辅助检查
	 */
	public String getFuzhujiancha() {
		return fuzhujiancha;
	}
				
	
	/**
	 * 设置：健康评价
	 */
	 
	public void setJiankangpingjia(String jiankangpingjia) {
		this.jiankangpingjia = jiankangpingjia;
	}
	
	/**
	 * 获取：健康评价
	 */
	public String getJiankangpingjia() {
		return jiankangpingjia;
	}
				
	
	/**
	 * 设置：健康指导
	 */
	 
	public void setJiankangzhidao(String jiankangzhidao) {
		this.jiankangzhidao = jiankangzhidao;
	}
	
	/**
	 * 获取：健康指导
	 */
	public String getJiankangzhidao() {
		return jiankangzhidao;
	}
				
	
	/**
	 * 设置：体检日期
	 */
	 
	public void setTijianriqi(Date tijianriqi) {
		this.tijianriqi = tijianriqi;
	}
	
	/**
	 * 获取：体检日期
	 */
	public Date getTijianriqi() {
		return tijianriqi;
	}
			
}
