package com.wuzesheng.org.dao;

import java.util.List;

import com.wuzesheng.org.domain.Line;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月16日 下午1:39:14
 */

public interface LineMapper {

	
	/*
	 * 查询User所有数据
	 */
	public List<Line> FindAl();
	
	/*
	 * 增加User数据
	 */
	public void Linesave(Line line);
	
	/**
	 * 删除数据
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 更新数据
	 * @param Line
	 */
	public void update(Line line);
	
	/**
	 * 根据id 查询对象
	 * @param id
	 * @return
	 */
	public Line findById(Integer id);
}
