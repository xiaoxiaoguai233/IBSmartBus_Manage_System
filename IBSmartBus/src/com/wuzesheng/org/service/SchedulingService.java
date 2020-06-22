package com.wuzesheng.org.service;

import java.util.List;

import com.wuzesheng.org.domain.Scheduling;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月17日 上午9:46:00
 */

public interface SchedulingService {

	/*
	 * 查询所有数据
	 */
	public List<Scheduling> FindAll() ;
	
	/*
	 * 查询该ID数据
	 */
	public Scheduling findById(Integer id);
	
	/*
	 * 添加用户/修改
	 */
	public void Schedulingsave(Scheduling scheduling);
	
	/*
	 * 删除用户
	 */
	public void SchedulingDelete(Integer id);
}
