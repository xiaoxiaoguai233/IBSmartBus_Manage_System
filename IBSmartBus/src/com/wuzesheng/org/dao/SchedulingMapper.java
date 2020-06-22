package com.wuzesheng.org.dao;

import java.util.List;

import com.wuzesheng.org.domain.Scheduling;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月17日 上午9:38:23
 */

public interface SchedulingMapper {

	
	/*
	 * 查询User所有数据
	 */
	public List<Scheduling> FindAl();
	
	/*
	 * 增加User数据
	 */
	public void Schedulingsave(Scheduling scheduling);
	
	/**
	 * 删除数据
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 更新数据
	 * @param Line
	 */
	public void update(Scheduling scheduling);
	
	/**
	 * 根据id 查询对象
	 * @param id
	 * @return
	 */
	public Scheduling findById(Integer id);
}
