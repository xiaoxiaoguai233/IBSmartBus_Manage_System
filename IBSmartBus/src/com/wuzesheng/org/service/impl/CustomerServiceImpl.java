package com.wuzesheng.org.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wuzesheng.org.dao.CustomerMapper;
import com.wuzesheng.org.domain.Customer;
import com.wuzesheng.org.service.CustomerService;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	//注入Mapper接口对象
	@Resource
	private CustomerMapper customerMapper;
	
	public List<Customer> findAll() {
		return customerMapper.findAl();
	}

	public void save(Customer customer) {
		//判断是添加还是修改
		if(customer.getId()!=null){
			//修改
			customerMapper.update(customer);
		}else{
			//增加
			customerMapper.save(customer);
		}
	}

	public Customer findById(Integer id) {
		return customerMapper.findById(id);
	}

	public void delete(Integer[] id) {
		customerMapper.delete(id);
	}

}
