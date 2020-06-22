package com.wuzesheng.org.service;

import java.util.List;

import com.wuzesheng.org.domain.Bus;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月15日 下午11:52:22
 */

public interface BusService {
	
	/*
	 * 查询所有数据
	 */
	public List<Bus> FindAll();
	
	/*
	 * 查询该ID数据
	 */
	public Bus findById(Integer id);
	
	/*
	 * 添加用户/修改
	 */
	public void Bussave(Bus bus);
	
	/*
	 * 删除用户
	 */
	public void BusDelete(Integer id);
}
