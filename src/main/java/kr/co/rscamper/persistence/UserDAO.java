package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.LocationVO;
import kr.co.rscamper.domain.UserPhotoVO;
import kr.co.rscamper.domain.UserVO;

public interface UserDAO {

	public UserVO selectMainByUidComment(String userUid);
	
	/** 회원정보 입력 */
	public void insertUser(UserVO user);
	
	/** UID로 회원정보 수정 */
	public void updateUserByUid(UserVO user);
	
	/** UID로 회원정보 삭제 */
	public void deleteUserByUid(String userUid);

	/** UID로 회원정보 조회 */
	public UserVO selectUserByUid(String userUid);
	
	/** 기존 매칭되는 사진 정보 가져오기(userUid, type) */
	public UserPhotoVO selectUserPhotoPath(UserPhotoVO userPhoto);
	
	/** 사진 정보 삭제(photoNo) */
	public void deleteUserPhotoByNo(int photoNo);
	
	/** 이미지 파일 업로드 정보 입력 */
	public void insertUserPhoto(UserPhotoVO userPhoto);
	
	/** USER_TB에 USER_UID에 PHOTO_URL수정 */
	public void updateUserPhotoUrl(UserVO user);

	/** USER_TB에 USER_UID에 BGPHOTO_URL수정 */
	public void updateUserBgPhotoUrl(UserVO user);

	/** 지역정보 리스트 전체 조회 */
	public List<LocationVO> selectLocationList();

	/** 지역정보 리스트 지역번호로 조회 */
	public LocationVO selectLocationByNo();

	/** 회원 리스트 조회 */
	public List<UserVO> selectUserList();
	
}
