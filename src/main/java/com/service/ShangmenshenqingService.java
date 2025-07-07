package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangmenshenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShangmenshenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangmenshenqingView;


/**
 * 上门申请
 *
 * @author 
 * @email 
 * @date 2024-04-18 20:18:19
 */
public interface ShangmenshenqingService extends IService<ShangmenshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShangmenshenqingVO> selectListVO(Wrapper<ShangmenshenqingEntity> wrapper);
   	
   	ShangmenshenqingVO selectVO(@Param("ew") Wrapper<ShangmenshenqingEntity> wrapper);
   	
   	List<ShangmenshenqingView> selectListView(Wrapper<ShangmenshenqingEntity> wrapper);
   	
   	ShangmenshenqingView selectView(@Param("ew") Wrapper<ShangmenshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangmenshenqingEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ShangmenshenqingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ShangmenshenqingEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ShangmenshenqingEntity> wrapper);



}

