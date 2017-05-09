package kr.co.rscamper.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.TrainVO;

@Repository
public class TrainDAOImpl implements TrainDAO{

	@Inject
	private SqlSession session;
	
	private static final String namespace = "kr.co.rscamper.TrainMapper";
	
	private static final String namespaces = "kr.co.rscamper.SubwayMapper";
	
	@Override
	public List<TrainVO> list() throws Exception {
		return session.selectList(namespace + ".list");
	}

	@Override
	public String selectDepPlaceId(String depPlaceId) throws Exception {
		System.out.println("in dao");
		System.out.println(depPlaceId);
		String dad = session.selectOne(namespaces + ".depPlaceId", depPlaceId);
		System.out.println(dad);
		return dad;
	}

	@Override
	public String selectArrPlaceId(String arrPlaceId) throws Exception {
		return session.selectOne(namespaces + ".arrPlaceId", arrPlaceId);
	}

	@Override
	public List<TrainVO> trainSearch(String data) throws Exception {
		System.out.println("여기로들어와야지");
		System.out.println(data);
		
		List<String> list = new ArrayList<>();
		list.add(data);
		return session.selectList(namespace + ".searchList", list);
		
	}

	
}
