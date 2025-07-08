package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 健康评测
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-18 20:18:19
 */
@TableName("jiankangpingce")
public class JiankangpingceEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiankangpingceEntity() {
		
	}
	
	public JiankangpingceEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	/**
	 * 年龄
	 */
					
	private Integer nianling;
	
	/**
	 * 健康评测
	 */
					
	private String jiankangpingce;
	
	/**
	 * 健康等级
	 */
					
	private String jiankangdengji;
	
	/**
	 * 评测依据
	 */
					
	private String pingceyiju;
	
	/**
	 * 潜在风险
	 */
					
	private String qianzaifengxian;
	
	/**
	 * 健康指导
	 */
					
	private String jiankangzhidao;
	
	/**
	 * 评估时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date pinggushijian;
	
	/**
	 * 跨表用户id
	 */
					
	private Long crossuserid;
	
	/**
	 * 跨表主键id
	 */
					
	private Long crossrefid;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
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
	 * 设置：健康评测
	 */
	public void setJiankangpingce(String jiankangpingce) {
		this.jiankangpingce = jiankangpingce;
	}
	/**
	 * 获取：健康评测
	 */
	public String getJiankangpingce() {
		return jiankangpingce;
	}
	/**
	 * 设置：健康等级
	 */
	public void setJiankangdengji(String jiankangdengji) {
		this.jiankangdengji = jiankangdengji;
	}
	/**
	 * 获取：健康等级
	 */
	public String getJiankangdengji() {
		return jiankangdengji;
	}
	/**
	 * 设置：评测依据
	 */
	public void setPingceyiju(String pingceyiju) {
		this.pingceyiju = pingceyiju;
	}
	/**
	 * 获取：评测依据
	 */
	public String getPingceyiju() {
		return pingceyiju;
	}
	/**
	 * 设置：潜在风险
	 */
	public void setQianzaifengxian(String qianzaifengxian) {
		this.qianzaifengxian = qianzaifengxian;
	}
	/**
	 * 获取：潜在风险
	 */
	public String getQianzaifengxian() {
		return qianzaifengxian;
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
	 * 设置：评估时间
	 */
	public void setPinggushijian(Date pinggushijian) {
		this.pinggushijian = pinggushijian;
	}
	/**
	 * 获取：评估时间
	 */
	public Date getPinggushijian() {
		return pinggushijian;
	}
	/**
	 * 设置：跨表用户id
	 */
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
	/**
	 * 设置：跨表主键id
	 */
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}

}
