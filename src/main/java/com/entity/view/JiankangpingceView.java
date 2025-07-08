package com.entity.view;

import com.entity.JiankangpingceEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

@TableName("jiankangpingce")
public class JiankangpingceView  extends JiankangpingceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiankangpingceView(){
	}
 
 	public JiankangpingceView(JiankangpingceEntity jiankangpingceEntity){
 	try {
			BeanUtils.copyProperties(this, jiankangpingceEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
