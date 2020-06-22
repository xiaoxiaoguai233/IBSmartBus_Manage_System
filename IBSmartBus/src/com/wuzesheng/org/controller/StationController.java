package com.wuzesheng.org.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuzesheng.org.domain.Station;
import com.wuzesheng.org.service.StationService;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月16日 下午12:10:53
 */

@Controller
@RequestMapping("/station")
public class StationController {
	
	
		//注入service对象
		@Resource
		private StationService stationService;

		
		/*
		 * 查询所有数据，给页面返回Json格式数据
		 */
		@RequestMapping("/list")
		@ResponseBody	 //用于转换对象
		public List<Station> list(){
			//查询数据
			List<Station> list = stationService.FindAll();		
			return list;
		}

		//设计Map聚合存储需要给页面的对象数据
		private Map<String,Object> result = new HashMap<String,Object>();
		
		/**
		 * 保存数据
		 */
		@RequestMapping("/save")
		@ResponseBody
		public Map<String,Object> save(Station station){
			System.out.println("用户保存数据操作");
			System.out.println(station);
			try {
				stationService.Stationsave(station);
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
		public Map<String,Object> delete(Integer id){
			System.out.println("删除用户");
			System.out.println(id.toString());
			try {
				stationService.StationDelete(id);
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
		public Station findById(Integer id,Model model){
			System.out.println(id);
			Station station = stationService.findById(id);
			System.out.println(station);
			model.addAttribute("findById",station);
			return station; 
		}
}
