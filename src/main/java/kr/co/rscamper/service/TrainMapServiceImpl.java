package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.TrainMapVO;
import kr.co.rscamper.persistence.TrainMapDAO;

@Service
public class TrainMapServiceImpl implements TrainMapService{
	
	@Inject
	private TrainMapDAO dao;
	
	@Override
	public List<TrainMapVO> list() throws Exception {
		return dao.list();
	}

	@Override
	public List<TrainMapVO> trainLineMapList() throws Exception {
		return dao.trainLineMapList();
	}
	
	
}
