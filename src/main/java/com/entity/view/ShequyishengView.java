package com.entity.view;

import com.entity.ShequyishengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

@TableName("shequyisheng")
public class ShequyishengView  extends ShequyishengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShequyishengView(){
	}
 
 	public ShequyishengView(ShequyishengEntity shequyishengEntity){
 	try {
			BeanUtils.copyProperties(this, shequyishengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
