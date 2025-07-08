package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YishengzixunEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YishengzixunVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YishengzixunView;


/**
 * 医生咨询
 *
 * @author 
 * @email 
 * @date 2024-04-18 20:18:19
 */
public interface YishengzixunService extends IService<YishengzixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YishengzixunVO> selectListVO(Wrapper<YishengzixunEntity> wrapper);
   	
   	YishengzixunVO selectVO(@Param("ew") Wrapper<YishengzixunEntity> wrapper);
   	
   	List<YishengzixunView> selectListView(Wrapper<YishengzixunEntity> wrapper);
   	
   	YishengzixunView selectView(@Param("ew") Wrapper<YishengzixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YishengzixunEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YishengzixunEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YishengzixunEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YishengzixunEntity> wrapper);



}

