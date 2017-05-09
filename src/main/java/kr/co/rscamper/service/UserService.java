package kr.co.rscamper.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;

import kr.co.rscamper.domain.LocationVO;
import kr.co.rscamper.domain.UserPhotoVO;
import kr.co.rscamper.domain.UserVO;

public interface UserService {
	
	/** */
	public UserVO selectMainByUidComment(String userUid) throws Exception;
	
	/** [App] 회원 가입 */
	public void insertUser(UserVO user) throws Exception;

	/** [App] 회원 탈퇴 */
	public void deleteUserByUid(String userUid) throws Exception;
	
	/** [App] UID로 회원 정보 가져오기 */
	public UserVO selectUserByUid(String userUid) throws Exception;

	/** [App] 회원 정보 수정 (프로필사진) */
	public void updateProfileImage(UserPhotoVO userPhoto) throws Exception;
	
	/** [App] 회원 정보 수정 (프로필 배경 사진) */
	public void updateBgImage(UserPhotoVO userPhoto) throws Exception;
	
	/** [App] 회원 정보 수정 (회원정보) */
	public void updateUserByUid(UserVO user);

	/** [App] 지역목록 리스트 가져오기 */
	public List<LocationVO> selectLocationList();
	
	/** [App] NO로 지역정보 가져오기 */
	public LocationVO selectLocationByNo();
	
	/** [App] 회원 리스트 가져오기 */
	public List<UserVO> selectUserList() throws Exception;


	
}
