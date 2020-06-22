package com.wuzesheng.org.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuzesheng.org.domain.Bus;
import com.wuzesheng.org.service.BusService;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月16日 上午12:03:11
 */

@Controller
@RequestMapping("/bus") 
public class BusController {
	

	//注入service对象
	@Resource
	private BusService busService;
	
	
	/*
	 * 查询所有数据，给页面返回Json格式数据
	 */
	@RequestMapping("/list")
	@ResponseBody	 //用于转换对象
	public List<Bus> list(){
		//查询数据
		List<Bus> list = busService.FindAll();		
		return list;
	}
	

	//设计Map聚合存储需要给页面的对象数据
	private Map<String,Object> result = new HashMap<String,Object>();
	
	
	/**
	 * 保存数据
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String,Object> save(Bus bus){
		System.out.println("用户保存数据操作");
		System.out.println(bus);
		bus.setStatus("启运");
		try {
			busService.Bussave(bus);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	
	/**
	 * 删除数据
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> delete(Integer busCode){
		System.out.println("删除车辆");
		System.out.println(busCode.toString());
		try {
			busService.BusDelete(busCode);
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
	public Bus findById(Integer busCode,Model model){
		System.out.println(busCode);
		Bus bus = busService.findById(busCode);
		System.out.println(bus);
		model.addAttribute("findById",bus);
		return bus; 
	}
	
	
	
	
}
