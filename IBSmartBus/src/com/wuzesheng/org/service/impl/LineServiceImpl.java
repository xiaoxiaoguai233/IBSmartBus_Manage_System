package com.wuzesheng.org.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wuzesheng.org.dao.LineMapper;
import com.wuzesheng.org.domain.Line;
import com.wuzesheng.org.service.LineService;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月16日 下午1:47:01
 */
@Service("LineService")
@Transactional
public class LineServiceImpl implements LineService {
	
	//注入service对象
	@Resource
	private LineService lineService;	
	
	
	//注入 Mapper 接口对象
	@Resource
	private LineMapper linemapper;
	public void setUsermapper(LineMapper lineMapper) {
		this.linemapper = lineMapper;
	}
		
		
		
	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.LineService#FindAll()
	 */
	public List<Line> FindAll() {
		// TODO Auto-generated method stub
		return linemapper.FindAl();
	}

	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.LineService#findById(java.lang.Integer)
	 */
	public Line findById(Integer id) {
		// TODO Auto-generated method stub
		return linemapper.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.LineService#Stationsave(com.wuzesheng.org.domain.Line)
	 */
	public void Linesave(Line line) {
		// TODO Auto-generated method stub
		if(line.getLineCode() != null){
			//修改
			System.out.println("线路修改");
			linemapper.update(line);
		}else{
			//增加
			System.out.println("线路添加");
			List<Line> list = lineService.FindAll();
			int n = list.size();
			int arr[] = new int[n];
			for(int i = 0 ; i < list.size(); i++)
				arr[i] = list.get(i).getLineCode();
			Arrays.sort(arr);
			line.setLineCode(arr[n-1] + 1);
			System.out.println("车辆添加："+ line);
			linemapper.Linesave(line);
		}
	}

	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.LineService#StationDelete(java.lang.Integer)
	 */
	public void LineDelete(Integer id) {
		// TODO Auto-generated method stub
		linemapper.delete(id);
	}

}
