package com.wuzesheng.org.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wuzesheng.org.dao.BusMapper;
import com.wuzesheng.org.domain.Bus;
import com.wuzesheng.org.service.BusService;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月15日 下午11:53:15
 */
@Service("BusService")
@Transactional
public class BusServiceImpl implements BusService {

	
	//注入service对象
	@Resource
	private BusService busService;
	
	
	//注入 Mapper 接口对象
	@Resource
	private BusMapper busmapper;
	public void setBusmapper(BusMapper busrmapper) {
		this.busmapper = busrmapper;
	}
	
	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.BusService#FindAll()
	 */
	public List<Bus> FindAll() {
		// TODO Auto-generated method stub	
		return busmapper.findAl();
	}

	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.BusService#findById(java.lang.Integer)
	 */
	public Bus findById(Integer id) {
		// TODO Auto-generated method stub
		return busmapper.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.BusService#Bussave(com.wuzesheng.org.domain.Bus)
	 */
	public void Bussave(Bus bus) {
		//判断是添加还是修改
		if(bus.getBusCode() != null){
			//修改
			System.out.println("车辆修改");
			busmapper.update(bus);
		}else{
			//添加
			System.out.println("车辆添加");
			/* 添加 id */
			//查询数据
			List<Bus> list = busService.FindAll();
			int n = list.size();
			int arr[] = new int[n];
			for(int i = 0 ; i < list.size(); i++)
				arr[i] = list.get(i).getBusCode();
			Arrays.sort(arr);
			bus.setBusCode(arr[n-1] + 1);
			System.out.println("车辆添加："+ bus);
			busmapper.save(bus);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.BusService#BusDelete(java.lang.Integer)
	 */
	public void BusDelete(Integer id) {
		// TODO Auto-generated method stub
		busmapper.delete(id);
	}

}
