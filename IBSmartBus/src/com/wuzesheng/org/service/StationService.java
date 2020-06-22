package com.wuzesheng.org.service;

import java.util.List;

import com.wuzesheng.org.domain.Station;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月16日 下午12:03:48
 */

public interface StationService {

	/*
	 * 查询所有数据
	 */
	public List<Station> FindAll() ;
	
	/*
	 * 查询该ID数据
	 */
	public Station findById(Integer id);
	
	/*
	 * 添加用户/修改
	 */
	public void Stationsave(Station station);
	
	/*
	 * 删除用户
	 */
	public void StationDelete(Integer id);
}
