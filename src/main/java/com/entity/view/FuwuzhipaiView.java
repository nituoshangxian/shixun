package com.entity.view;

import com.entity.FuwuzhipaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

@TableName("fuwuzhipai")
public class FuwuzhipaiView  extends FuwuzhipaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FuwuzhipaiView(){
	}
 
 	public FuwuzhipaiView(FuwuzhipaiEntity fuwuzhipaiEntity){
 	try {
			BeanUtils.copyProperties(this, fuwuzhipaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
