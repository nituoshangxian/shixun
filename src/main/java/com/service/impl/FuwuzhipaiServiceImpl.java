package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.FuwuzhipaiDao;
import com.entity.FuwuzhipaiEntity;
import com.service.FuwuzhipaiService;
import com.entity.vo.FuwuzhipaiVO;
import com.entity.view.FuwuzhipaiView;

@Service("fuwuzhipaiService")
public class FuwuzhipaiServiceImpl extends ServiceImpl<FuwuzhipaiDao, FuwuzhipaiEntity> implements FuwuzhipaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FuwuzhipaiEntity> page = this.selectPage(
                new Query<FuwuzhipaiEntity>(params).getPage(),
                new EntityWrapper<FuwuzhipaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FuwuzhipaiEntity> wrapper) {
		  Page<FuwuzhipaiView> page =new Query<FuwuzhipaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FuwuzhipaiVO> selectListVO(Wrapper<FuwuzhipaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FuwuzhipaiVO selectVO(Wrapper<FuwuzhipaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FuwuzhipaiView> selectListView(Wrapper<FuwuzhipaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FuwuzhipaiView selectView(Wrapper<FuwuzhipaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
