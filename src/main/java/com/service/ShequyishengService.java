package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShequyishengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShequyishengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShequyishengView;


/**
 * 社区医生
 */
public interface ShequyishengService extends IService<ShequyishengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShequyishengVO> selectListVO(Wrapper<ShequyishengEntity> wrapper);
   	
   	ShequyishengVO selectVO(@Param("ew") Wrapper<ShequyishengEntity> wrapper);
   	
   	List<ShequyishengView> selectListView(Wrapper<ShequyishengEntity> wrapper);
   	
   	ShequyishengView selectView(@Param("ew") Wrapper<ShequyishengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShequyishengEntity> wrapper);

   	

}

