package com.dao;

import com.entity.JiankangpingceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiankangpingceVO;
import com.entity.view.JiankangpingceView;


public interface JiankangpingceDao extends BaseMapper<JiankangpingceEntity> {
	
	List<JiankangpingceVO> selectListVO(@Param("ew") Wrapper<JiankangpingceEntity> wrapper);
	
	JiankangpingceVO selectVO(@Param("ew") Wrapper<JiankangpingceEntity> wrapper);
	
	List<JiankangpingceView> selectListView(@Param("ew") Wrapper<JiankangpingceEntity> wrapper);

	List<JiankangpingceView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangpingceEntity> wrapper);

	
	JiankangpingceView selectView(@Param("ew") Wrapper<JiankangpingceEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiankangpingceEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiankangpingceEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiankangpingceEntity> wrapper);



}
