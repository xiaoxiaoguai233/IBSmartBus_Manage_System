package com.wuzesheng.org.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuzesheng.org.domain.User;



/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月12日 上午1:13:08
 */

public interface UserMapper {
	
	/*
	 *  登录 接口
	 */
	public User loginUser(@Param("UserName") String UserName,@Param("PassWord") String PassWord);
	
	/*
	 * 查询User所有数据
	 */
	public List<User> FindAl();
	
	/*
	 * 增加User数据
	 */
	public void Usersave(User user);
	
	/**
	 * 删除数据
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 更新数据
	 * @param user
	 */
	public void update(User user);
	
	/**
	 * 根据id 查询对象
	 * @param id
	 * @return
	 */
	public User findById(Integer id);
}
