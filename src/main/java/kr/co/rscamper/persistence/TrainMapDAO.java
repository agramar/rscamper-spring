package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.TrainMapVO;

public interface TrainMapDAO {

	public List<TrainMapVO> list()throws Exception;

	public List<TrainMapVO> trainLineMapList()throws Exception;

}
