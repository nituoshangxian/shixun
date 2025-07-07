package com.entity.view;

import com.entity.YishengzixunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

@TableName("yishengzixun")
public class YishengzixunView  extends YishengzixunEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YishengzixunView(){
	}
 
 	public YishengzixunView(YishengzixunEntity yishengzixunEntity){
 	try {
			BeanUtils.copyProperties(this, yishengzixunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
