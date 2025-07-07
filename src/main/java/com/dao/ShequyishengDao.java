package com.dao;

import com.entity.ShequyishengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShequyishengVO;
import com.entity.view.ShequyishengView;

public interface ShequyishengDao extends BaseMapper<ShequyishengEntity> {
	
	List<ShequyishengVO> selectListVO(@Param("ew") Wrapper<ShequyishengEntity> wrapper);
	
	ShequyishengVO selectVO(@Param("ew") Wrapper<ShequyishengEntity> wrapper);
	
	List<ShequyishengView> selectListView(@Param("ew") Wrapper<ShequyishengEntity> wrapper);

	List<ShequyishengView> selectListView(Pagination page,@Param("ew") Wrapper<ShequyishengEntity> wrapper);

	
	ShequyishengView selectView(@Param("ew") Wrapper<ShequyishengEntity> wrapper);
	

}
