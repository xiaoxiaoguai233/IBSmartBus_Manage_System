package com.wuzesheng.org.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuzesheng.org.domain.Line;
import com.wuzesheng.org.domain.Line_Station_Ref;
import com.wuzesheng.org.domain.Line_Station_Ref_Output;
import com.wuzesheng.org.domain.Station;
import com.wuzesheng.org.service.LineService;
import com.wuzesheng.org.service.Line_Station_RefService;
import com.wuzesheng.org.service.StationService;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月16日 下午3:05:10
 */

@Controller
@RequestMapping("/line_station_ref")
public class Line_Station_RefController {

	
	//注入service对象
	@Resource
	private Line_Station_RefService line_station_refService;
	private StationService stationService;
	private LineService lineService; 
	
	/*
	 * 查询所有数据，给页面返回Json格式数据
	 */
	@RequestMapping("/list")
	@ResponseBody	 //用于转换对象
	public List<Line_Station_Ref> list(){
		//查询数据
		System.out.println("查询站点-线路数据");
		//Station station = stationService.findById(1);
		List<Line_Station_Ref> list = line_station_refService.FindAll();
				
		return list;
	}
}












