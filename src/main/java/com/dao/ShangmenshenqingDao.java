package com.dao;

import com.entity.ShangmenshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShangmenshenqingVO;
import com.entity.view.ShangmenshenqingView;


public interface ShangmenshenqingDao extends BaseMapper<ShangmenshenqingEntity> {
	
	List<ShangmenshenqingVO> selectListVO(@Param("ew") Wrapper<ShangmenshenqingEntity> wrapper);
	
	ShangmenshenqingVO selectVO(@Param("ew") Wrapper<ShangmenshenqingEntity> wrapper);
	
	List<ShangmenshenqingView> selectListView(@Param("ew") Wrapper<ShangmenshenqingEntity> wrapper);

	List<ShangmenshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<ShangmenshenqingEntity> wrapper);

	
	ShangmenshenqingView selectView(@Param("ew") Wrapper<ShangmenshenqingEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShangmenshenqingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShangmenshenqingEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShangmenshenqingEntity> wrapper);



}
