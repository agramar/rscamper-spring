package kr.co.rscamper.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.TrainMapVO;

@Repository
public class TrainMapDAOImpl implements TrainMapDAO{
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "kr.co.rscamper.TrainMapMapper";
	
	
	@Override
	public List<TrainMapVO> list() throws Exception {
	//	System.out.println("MAP여기로");
		List<TrainMapVO> list = new ArrayList<>();
		System.out.println(list);
		return session.selectList(namespace + ".TrainMapList");
	}


	@Override
	public List<TrainMapVO> trainLineMapList() throws Exception {
		System.out.println("trainLineMap 여기로");
		List<TrainMapVO> result = new ArrayList<>();
		System.out.println(result);
		return session.selectList(namespace + ".TrainMapLineList");
	}
	
}
