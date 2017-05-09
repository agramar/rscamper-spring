package kr.co.rscamper.persistence;

import kr.co.rscamper.domain.MypageCountVO;

public interface MypageDAO {

	/** 마이페이지 메뉴 카운트 조회 */
	public MypageCountVO selectMenuCountByUserUid(String userUid);


}
