package com.entity.view;

import com.entity.TijianbaogaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 


@TableName("tijianbaogao")
public class TijianbaogaoView  extends TijianbaogaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TijianbaogaoView(){
	}
 
 	public TijianbaogaoView(TijianbaogaoEntity tijianbaogaoEntity){
 	try {
			BeanUtils.copyProperties(this, tijianbaogaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
