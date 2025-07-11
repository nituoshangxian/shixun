package com.dao;

import com.entity.YishengzixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YishengzixunVO;
import com.entity.view.YishengzixunView;


public interface YishengzixunDao extends BaseMapper<YishengzixunEntity> {
	
	List<YishengzixunVO> selectListVO(@Param("ew") Wrapper<YishengzixunEntity> wrapper);
	
	YishengzixunVO selectVO(@Param("ew") Wrapper<YishengzixunEntity> wrapper);
	
	List<YishengzixunView> selectListView(@Param("ew") Wrapper<YishengzixunEntity> wrapper);

	List<YishengzixunView> selectListView(Pagination page,@Param("ew") Wrapper<YishengzixunEntity> wrapper);

	
	YishengzixunView selectView(@Param("ew") Wrapper<YishengzixunEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YishengzixunEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YishengzixunEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YishengzixunEntity> wrapper);



}
