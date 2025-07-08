package com.entity.view;

import com.entity.NewstypeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

@TableName("newstype")
public class NewstypeView  extends NewstypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public NewstypeView(){
	}
 
 	public NewstypeView(NewstypeEntity newstypeEntity){
 	try {
			BeanUtils.copyProperties(this, newstypeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
