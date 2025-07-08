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


import com.dao.JiankangpingceDao;
import com.entity.JiankangpingceEntity;
import com.service.JiankangpingceService;
import com.entity.vo.JiankangpingceVO;
import com.entity.view.JiankangpingceView;

@Service("jiankangpingceService")
public class JiankangpingceServiceImpl extends ServiceImpl<JiankangpingceDao, JiankangpingceEntity> implements JiankangpingceService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiankangpingceEntity> page = this.selectPage(
                new Query<JiankangpingceEntity>(params).getPage(),
                new EntityWrapper<JiankangpingceEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiankangpingceEntity> wrapper) {
		  Page<JiankangpingceView> page =new Query<JiankangpingceView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiankangpingceVO> selectListVO(Wrapper<JiankangpingceEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiankangpingceVO selectVO(Wrapper<JiankangpingceEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiankangpingceView> selectListView(Wrapper<JiankangpingceEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiankangpingceView selectView(Wrapper<JiankangpingceEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<JiankangpingceEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<JiankangpingceEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<JiankangpingceEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
