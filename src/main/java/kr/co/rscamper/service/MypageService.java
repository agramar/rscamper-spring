package kr.co.rscamper.service;

import kr.co.rscamper.domain.MypageCountVO;

public interface MypageService {

	/** 마이페이지 메뉴 카운트 조회 */
	MypageCountVO selectMenuCountByUserUid(String userUid);
	
}
