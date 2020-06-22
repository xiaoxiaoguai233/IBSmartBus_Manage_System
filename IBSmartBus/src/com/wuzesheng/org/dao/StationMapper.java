package com.wuzesheng.org.dao;

import java.util.List;

import com.wuzesheng.org.domain.Station;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月16日 上午11:49:53
 */

public interface StationMapper {
	
	/*
	 * 查询User所有数据
	 */
	public List<Station> FindAl();
	
	/*
	 * 增加User数据
	 */
	public void Stationsave(Station station);
	
	/**
	 * 删除数据
	 * @param stationCode
	 */
	public void delete(Integer id);

	/**
	 * 更新数据
	 * @param station
	 */
	public void update(Station station);
	
	/**
	 * 根据id 查询对象
	 * @param stationCode
	 * @return
	 */
	public Station findById(Integer id);
}
