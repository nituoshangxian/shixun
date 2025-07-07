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


import com.dao.YishengzixunDao;
import com.entity.YishengzixunEntity;
import com.service.YishengzixunService;
import com.entity.vo.YishengzixunVO;
import com.entity.view.YishengzixunView;

@Service("yishengzixunService")
public class YishengzixunServiceImpl extends ServiceImpl<YishengzixunDao, YishengzixunEntity> implements YishengzixunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YishengzixunEntity> page = this.selectPage(
                new Query<YishengzixunEntity>(params).getPage(),
                new EntityWrapper<YishengzixunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YishengzixunEntity> wrapper) {
		  Page<YishengzixunView> page =new Query<YishengzixunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YishengzixunVO> selectListVO(Wrapper<YishengzixunEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YishengzixunVO selectVO(Wrapper<YishengzixunEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YishengzixunView> selectListView(Wrapper<YishengzixunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YishengzixunView selectView(Wrapper<YishengzixunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YishengzixunEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YishengzixunEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YishengzixunEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
