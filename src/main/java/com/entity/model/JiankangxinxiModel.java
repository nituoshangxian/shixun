package com.entity.model;

import com.entity.JiankangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 
public class JiankangxinxiModel  implements Serializable {
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
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 年龄
	 */
	
	private Integer nianling;
		
	/**
	 * 身高(cm)
	 */
	
	private Integer shengao;
		
	/**
	 * 体重(kg)
	 */
	
	private Double tizhong;
		
	/**
	 * 视力
	 */
	
	private Double shili;
		
	/**
	 * 心率(b/min)
	 */
	
	private Integer xinlv;
		
	/**
	 * 血压(mmHg)
	 */
	
	private Integer xueya;
		
	/**
	 * 血糖(mmol/L)
	 */
	
	private Double xuetang;
		
	/**
	 * 血脂(mmol/L)
	 */
	
	private Double xuezhi;
		
	/**
	 * 更新时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date gengxinshijian;
				
	
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
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：年龄
	 */
	 
	public void setNianling(Integer nianling) {
		this.nianling = nianling;
	}
	
	/**
	 * 获取：年龄
	 */
	public Integer getNianling() {
		return nianling;
	}
				
	
	/**
	 * 设置：身高(cm)
	 */
	 
	public void setShengao(Integer shengao) {
		this.shengao = shengao;
	}
	
	/**
	 * 获取：身高(cm)
	 */
	public Integer getShengao() {
		return shengao;
	}
				
	
	/**
	 * 设置：体重(kg)
	 */
	 
	public void setTizhong(Double tizhong) {
		this.tizhong = tizhong;
	}
	
	/**
	 * 获取：体重(kg)
	 */
	public Double getTizhong() {
		return tizhong;
	}
				
	
	/**
	 * 设置：视力
	 */
	 
	public void setShili(Double shili) {
		this.shili = shili;
	}
	
	/**
	 * 获取：视力
	 */
	public Double getShili() {
		return shili;
	}
				
	
	/**
	 * 设置：心率(b/min)
	 */
	 
	public void setXinlv(Integer xinlv) {
		this.xinlv = xinlv;
	}
	
	/**
	 * 获取：心率(b/min)
	 */
	public Integer getXinlv() {
		return xinlv;
	}
				
	
	/**
	 * 设置：血压(mmHg)
	 */
	 
	public void setXueya(Integer xueya) {
		this.xueya = xueya;
	}
	
	/**
	 * 获取：血压(mmHg)
	 */
	public Integer getXueya() {
		return xueya;
	}
				
	
	/**
	 * 设置：血糖(mmol/L)
	 */
	 
	public void setXuetang(Double xuetang) {
		this.xuetang = xuetang;
	}
	
	/**
	 * 获取：血糖(mmol/L)
	 */
	public Double getXuetang() {
		return xuetang;
	}
				
	
	/**
	 * 设置：血脂(mmol/L)
	 */
	 
	public void setXuezhi(Double xuezhi) {
		this.xuezhi = xuezhi;
	}
	
	/**
	 * 获取：血脂(mmol/L)
	 */
	public Double getXuezhi() {
		return xuezhi;
	}
				
	
	/**
	 * 设置：更新时间
	 */
	 
	public void setGengxinshijian(Date gengxinshijian) {
		this.gengxinshijian = gengxinshijian;
	}
	
	/**
	 * 获取：更新时间
	 */
	public Date getGengxinshijian() {
		return gengxinshijian;
	}
			
}
