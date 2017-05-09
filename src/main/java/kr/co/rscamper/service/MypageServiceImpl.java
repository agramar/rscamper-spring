package kr.co.rscamper.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.MypageCountVO;
import kr.co.rscamper.persistence.MypageDAO;

@Service
public class MypageServiceImpl implements MypageService {

	@Inject
	private MypageDAO dao;
	
	@Override
	public MypageCountVO selectMenuCountByUserUid(String userUid) {
		return dao.selectMenuCountByUserUid(userUid);
	}

}
