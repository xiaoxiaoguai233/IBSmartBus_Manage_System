package com.wuzesheng.org.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wuzesheng.org.dao.LineMapper;
import com.wuzesheng.org.dao.SchedulingMapper;
import com.wuzesheng.org.domain.Line;
import com.wuzesheng.org.domain.Scheduling;
import com.wuzesheng.org.service.LineService;
import com.wuzesheng.org.service.SchedulingService;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月17日 上午9:47:16
 */

@Service("SchedulingService")
@Transactional
public class SchedulingServiceImpl implements SchedulingService {
	
	//注入service对象
	@Resource
	private SchedulingService schedulingService;	
	
	//注入 Mapper 接口对象
	@Resource
	private SchedulingMapper schedulingmapper;
	public void setUsermapper(SchedulingMapper schedulingMapper) {
		this.schedulingmapper = schedulingMapper;
	}
	
	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.SchedulingService#FindAll()
	 */
	public List<Scheduling> FindAll() {
		// TODO Auto-generated method stub
		return schedulingmapper.FindAl();
	}

	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.SchedulingService#findById(java.lang.Integer)
	 */
	public Scheduling findById(Integer id) {
		// TODO Auto-generated method stub
		return schedulingmapper.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.SchedulingService#Schedulingsave(com.wuzesheng.org.domain.Scheduling)
	 */
	public void Schedulingsave(Scheduling scheduling) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(scheduling.getSchedulingCode() != null){
			//修改
			System.out.println("排班修改");
			schedulingmapper.update(scheduling);
		}else{
			//增加
			System.out.println("排班添加");
			schedulingmapper.Schedulingsave(scheduling);
		}
	}

	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.SchedulingService#SchedulingDelete(java.lang.Integer)
	 */
	public void SchedulingDelete(Integer id) {
		// TODO Auto-generated method stub
		schedulingmapper.delete(id);
	}

}
