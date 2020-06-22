package com.wuzesheng.org.service;

import java.util.List;

import com.wuzesheng.org.domain.User;



/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月12日 下午3:05:26
 */

public interface UserService {
	
	/*
	 *  登录 接口
	 */
	public User loginUser(String UserName,String PassWord);
	
	
	/*
	 * 查询所有数据
	 */
	public List<User> FindAll();
	
	/*
	 * 查询该ID数据
	 */
	public User findById(Integer id);
	
	/*
	 * 添加用户/修改
	 */
	public void Usersave(User user);
	
	/*
	 * 删除用户
	 */
	public void UserDelete(Integer id);
}
