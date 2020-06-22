package com.wuzesheng.org.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wuzesheng.org.domain.Customer;
import com.wuzesheng.org.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//注入service对象
	@Resource
	private CustomerService customerService;
	
	/**
	 * 查询所有数据，给页面返回json格式数据
	 * easyui的datagrid组件，需要展示数提供json数据： [ {id:1,name:xxx},{id:1,name:xxx} ]
	 */
	@RequestMapping("/list")
	@ResponseBody  // 用于转换对象为json
	public List<Customer> list(){
		//查询数据
		List<Customer> list = customerService.findAll();
		return list;
	}
	
	//设计Map聚合存储需要给页面的对象数据
	private Map<String,Object> result = new HashMap<String,Object>();
	
	/**
	 * 分页查询
	 */
	@RequestMapping("/listByPage")
	@ResponseBody
	public Map<String,Object> listByPage(Integer page,Integer rows){
		//设置分页参数
		PageHelper.startPage(page, rows);
		//查询所有数据
		List<Customer> list = customerService.findAll();
		
		//使用PageInfo封装查询结果
		PageInfo<Customer> pageInfo = new PageInfo<Customer>(list);
		
		//从PageInfo对象取出查询结果
		//总记录数
		long total = pageInfo.getTotal();
		//当前页数据列表
		List<Customer> custList = pageInfo.getList();
		
		result.put("total", total);
		result.put("rows", custList);
		
		return result;
	}
	
	/**
	 * 保存数据
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String,Object> save(Customer customer){
		try {
			customerService.save(customer);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	/**
	 * 根据id 查询对象
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public Customer findById(Integer id){
		Customer cust = customerService.findById(id);
		return cust;
	}
	
	/**
	 * 删除数据
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> delete(Integer[] id){
		try {
			customerService.delete(id);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
}
