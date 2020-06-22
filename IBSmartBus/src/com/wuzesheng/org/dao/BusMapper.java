package com.wuzesheng.org.dao;

import java.util.List;

import com.wuzesheng.org.domain.Bus;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月15日 下午11:05:45
 */

public interface BusMapper {
	
	/**
	 * 查询所有数据
	 */
	public List<Bus> findAl();

	/**
	 * 保存数据
	 * @param Bus
	 */
	public void save(Bus bus);

	/**
	 * 根据id 查询对象
	 * @param id
	 * @return
	 */
	public Bus findById(Integer id);
	
	/**
	 * 修改对象数据
	 * @param bus
	 */
	public void update(Bus bus);

	/**
	 * 删除数据
	 * @param id
	 */
	public void delete(Integer id);
}
