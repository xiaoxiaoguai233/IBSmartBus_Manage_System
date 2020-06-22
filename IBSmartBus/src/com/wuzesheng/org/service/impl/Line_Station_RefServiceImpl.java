package com.wuzesheng.org.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wuzesheng.org.dao.Line_Station_RefMapper;
import com.wuzesheng.org.dao.StationMapper;
import com.wuzesheng.org.domain.Line_Station_Ref;
import com.wuzesheng.org.service.Line_Station_RefService;
import com.wuzesheng.org.service.StationService;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月16日 下午3:02:58
 */
@Service("Line_Station_RefService")
@Transactional
public class Line_Station_RefServiceImpl implements Line_Station_RefService {

	
	//注入service对象
	@Resource
	private Line_Station_RefService line_station_refServiceService;	
	
	//注入 Mapper 接口对象
	@Resource
	private Line_Station_RefMapper line_station_refmapper;
	public void setUsermapper(Line_Station_RefMapper line_station_refmapper) {
		this.line_station_refmapper = line_station_refmapper;
	}
	
	
	/* (non-Javadoc)
	 * @see com.wuzesheng.org.service.Line_Station_RefService#FindAll()
	 */
	public List<Line_Station_Ref> FindAll() {
		// TODO Auto-generated method stub
		return line_station_refmapper.FindAl();
	}

}
