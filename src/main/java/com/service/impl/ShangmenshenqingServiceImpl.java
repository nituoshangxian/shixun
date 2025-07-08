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


import com.dao.ShangmenshenqingDao;
import com.entity.ShangmenshenqingEntity;
import com.service.ShangmenshenqingService;
import com.entity.vo.ShangmenshenqingVO;
import com.entity.view.ShangmenshenqingView;

@Service("shangmenshenqingService")
public class ShangmenshenqingServiceImpl extends ServiceImpl<ShangmenshenqingDao, ShangmenshenqingEntity> implements ShangmenshenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangmenshenqingEntity> page = this.selectPage(
                new Query<ShangmenshenqingEntity>(params).getPage(),
                new EntityWrapper<ShangmenshenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangmenshenqingEntity> wrapper) {
		  Page<ShangmenshenqingView> page =new Query<ShangmenshenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShangmenshenqingVO> selectListVO(Wrapper<ShangmenshenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShangmenshenqingVO selectVO(Wrapper<ShangmenshenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShangmenshenqingView> selectListView(Wrapper<ShangmenshenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShangmenshenqingView selectView(Wrapper<ShangmenshenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ShangmenshenqingEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ShangmenshenqingEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ShangmenshenqingEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
