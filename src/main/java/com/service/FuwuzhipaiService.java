package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FuwuzhipaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FuwuzhipaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FuwuzhipaiView;


/**
 * 服务指派
 *
 * @author 
 * @email 
 * @date 2024-04-18 20:18:19
 */
public interface FuwuzhipaiService extends IService<FuwuzhipaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FuwuzhipaiVO> selectListVO(Wrapper<FuwuzhipaiEntity> wrapper);
   	
   	FuwuzhipaiVO selectVO(@Param("ew") Wrapper<FuwuzhipaiEntity> wrapper);
   	
   	List<FuwuzhipaiView> selectListView(Wrapper<FuwuzhipaiEntity> wrapper);
   	
   	FuwuzhipaiView selectView(@Param("ew") Wrapper<FuwuzhipaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FuwuzhipaiEntity> wrapper);

   	

}

