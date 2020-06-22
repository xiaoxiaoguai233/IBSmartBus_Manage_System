package com.wuzesheng.org.service.impl;

import java.util.List;

import javax.annotation.Resource;







import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wuzesheng.org.dao.UserMapper;
import com.wuzesheng.org.domain.User;
import com.wuzesheng.org.service.UserService;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月12日 下午3:07:51
 */
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	//注入 Mapper 接口对象
	@Resource
	private UserMapper usermapper;
	public void setUsermapper(UserMapper usermapper) {
		this.usermapper = usermapper;
	}


	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.UserService#loginUser(java.lang.String, java.lang.String)
	 * 登录
	 */
	public User loginUser(String UserName, String PassWord) {
		
		return usermapper.loginUser(UserName, PassWord);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.wuzesheng.org.service.UserService#FindAll()
	 * 查询所有用户信息
	 */
	public List<User> FindAll() {		
		return usermapper.FindAl();
	}


	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.UserService#Usersave(com.wuzesheng.org.domain.User)
	 * 添加/修改用户
	 */
	public void Usersave(User user) {
		//判断是添加还是修改
		if(user.getID() != null){
			//修改
			System.out.println("用户修改");
			usermapper.update(user);
		}else{
			//增加
			System.out.println("用户添加");
			usermapper.Usersave(user);
		}
		
	}


	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.UserService#UserDelete(java.lang.String[])
	 * 删除用户
	 */
	public void UserDelete(Integer id) {
		usermapper.delete(id);
	}


	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.UserService#findById(java.lang.Integer)
	 * 查询ID数据用户
	 */
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return usermapper.findById(id);
	}
}
