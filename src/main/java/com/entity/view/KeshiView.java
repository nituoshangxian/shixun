package com.entity.view;

import com.entity.KeshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

@TableName("keshi")
public class KeshiView  extends KeshiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KeshiView(){
	}
 
 	public KeshiView(KeshiEntity keshiEntity){
 	try {
			BeanUtils.copyProperties(this, keshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
