package com.wuzesheng.org.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wuzesheng.org.dao.StationMapper;
import com.wuzesheng.org.domain.Station;
import com.wuzesheng.org.service.StationService;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月16日 下午12:05:59
 */

@Service("StationService")
@Transactional
public class StationServiceImpl implements StationService {

	//注入service对象
	@Resource
	private StationService stationService;	
	
	//注入 Mapper 接口对象
	@Resource
	private StationMapper stationmapper;
	public void setUsermapper(StationMapper stationmapper) {
		this.stationmapper = stationmapper;
	}
	
	
	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.StationService#FindAll()
	 */
	public List<Station> FindAll() {
		// TODO Auto-generated method stub
		return stationmapper.FindAl();
	}

	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.StationService#findById(java.lang.Integer)
	 */
	public Station findById(Integer id) {
		return stationmapper.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.StationService#Stationsave(com.wuzesheng.org.domain.Station)
	 */
	public void Stationsave(Station station) {
		// TODO Auto-generated method stub
		if(station.getStationCode() != null){
			//修改
			System.out.println("站点修改");
			stationmapper.update(station);
		}else{
			//增加
			System.out.println("站点添加");
			List<Station> list = stationService.FindAll();
			int n = list.size();
			int arr[] = new int[n];
			for(int i = 0 ; i < list.size(); i++)
				arr[i] = list.get(i).getStationCode();
			Arrays.sort(arr);
			station.setStationCode(arr[n-1] + 1);
			System.out.println("车辆添加："+ station);
			stationmapper.Stationsave(station);
		}
	}

	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.StationService#StationDelete(java.lang.Integer)
	 */
	public void StationDelete(Integer id) {
		// TODO Auto-generated method stub
		stationmapper.delete(id);
	}

}
