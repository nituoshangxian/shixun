package com.dao;

import com.entity.FuwuzhipaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FuwuzhipaiVO;
import com.entity.view.FuwuzhipaiView;


public interface FuwuzhipaiDao extends BaseMapper<FuwuzhipaiEntity> {
	
	List<FuwuzhipaiVO> selectListVO(@Param("ew") Wrapper<FuwuzhipaiEntity> wrapper);
	
	FuwuzhipaiVO selectVO(@Param("ew") Wrapper<FuwuzhipaiEntity> wrapper);
	
	List<FuwuzhipaiView> selectListView(@Param("ew") Wrapper<FuwuzhipaiEntity> wrapper);

	List<FuwuzhipaiView> selectListView(Pagination page,@Param("ew") Wrapper<FuwuzhipaiEntity> wrapper);

	
	FuwuzhipaiView selectView(@Param("ew") Wrapper<FuwuzhipaiEntity> wrapper);
	

}
