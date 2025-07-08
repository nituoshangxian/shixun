package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiankangpingceEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiankangpingceVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiankangpingceView;


/**
 * 健康评测
 *
 * @author 
 * @email 
 * @date 2024-04-18 20:18:19
 */
public interface JiankangpingceService extends IService<JiankangpingceEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiankangpingceVO> selectListVO(Wrapper<JiankangpingceEntity> wrapper);
   	
   	JiankangpingceVO selectVO(@Param("ew") Wrapper<JiankangpingceEntity> wrapper);
   	
   	List<JiankangpingceView> selectListView(Wrapper<JiankangpingceEntity> wrapper);
   	
   	JiankangpingceView selectView(@Param("ew") Wrapper<JiankangpingceEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiankangpingceEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<JiankangpingceEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<JiankangpingceEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<JiankangpingceEntity> wrapper);



}

