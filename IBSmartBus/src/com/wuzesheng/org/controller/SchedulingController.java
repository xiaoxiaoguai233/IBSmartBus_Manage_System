package com.wuzesheng.org.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuzesheng.org.domain.Scheduling;
import com.wuzesheng.org.service.SchedulingService;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月17日 上午9:51:38
 */

@Controller
@RequestMapping("/scheduling")
public class SchedulingController {

	
	//注入service对象
	@Resource
	private SchedulingService schedulingService;

	
	/*
	 * 查询所有数据，给页面返回Json格式数据
	 */
	@RequestMapping("/list")
	@ResponseBody	 //用于转换对象
	public List<Scheduling> list(){ 
		//查询数据
		List<Scheduling> list = schedulingService.FindAll();		
		return list;
	}

	//设计Map聚合存储需要给页面的对象数据
	private Map<String,Object> result = new HashMap<String,Object>();
	
	/**
	 * 保存数据
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String,Object> save(Scheduling scheduling){
		System.out.println("排班保存数据操作");
		System.out.println(scheduling);
		try {
			schedulingService.Schedulingsave(scheduling);
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
	public Map<String,Object> delete(Integer schedulingCode){
		System.out.println("删除用户");
		System.out.println(schedulingCode.toString());
		try {
			schedulingService.SchedulingDelete(schedulingCode);
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
	public Scheduling findById(Integer schedulingCode,Model model){
		System.out.println(schedulingCode);
		Scheduling scheduling = schedulingService.findById(schedulingCode);
		System.out.println(scheduling);
		model.addAttribute("findById",scheduling);
		return scheduling;
	}
}
