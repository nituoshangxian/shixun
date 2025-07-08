package com.entity.view;

import com.entity.JiankangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

@TableName("jiankangxinxi")
public class JiankangxinxiView  extends JiankangxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiankangxinxiView(){
	}
 
 	public JiankangxinxiView(JiankangxinxiEntity jiankangxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, jiankangxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
