package com.wuzesheng.org.service;

import java.util.List;

import com.wuzesheng.org.domain.Line;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月16日 下午1:45:53
 */

public interface LineService {
	
	/*
	 * 查询所有数据
	 */
	public List<Line> FindAll() ;
	
	/*
	 * 查询该ID数据
	 */
	public Line findById(Integer id);
	
	/*
	 * 添加用户/修改
	 */
	public void Linesave(Line line);
	
	/*
	 * 删除用户
	 */
	public void LineDelete(Integer id);
}
