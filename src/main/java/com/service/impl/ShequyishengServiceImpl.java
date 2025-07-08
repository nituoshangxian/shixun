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


import com.dao.ShequyishengDao;
import com.entity.ShequyishengEntity;
import com.service.ShequyishengService;
import com.entity.vo.ShequyishengVO;
import com.entity.view.ShequyishengView;

@Service("shequyishengService")
public class ShequyishengServiceImpl extends ServiceImpl<ShequyishengDao, ShequyishengEntity> implements ShequyishengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShequyishengEntity> page = this.selectPage(
                new Query<ShequyishengEntity>(params).getPage(),
                new EntityWrapper<ShequyishengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShequyishengEntity> wrapper) {
		  Page<ShequyishengView> page =new Query<ShequyishengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShequyishengVO> selectListVO(Wrapper<ShequyishengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShequyishengVO selectVO(Wrapper<ShequyishengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShequyishengView> selectListView(Wrapper<ShequyishengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShequyishengView selectView(Wrapper<ShequyishengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
