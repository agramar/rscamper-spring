package kr.co.rscamper.service;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;
import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.LocationVO;
import kr.co.rscamper.domain.UserPhotoVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO dao;
	
	@Inject
	ServletContext servletContext;
	
	private final String URL = "http://14.32.66.104:8081";
//	private final String URL = "http://192.168.0.9:8081";
//	private final String URL = "http://192.168.0.228:3001";
//	private final String URL = "http://192.168.1.13:3001";

	@Override
	public UserVO selectMainByUidComment(String userUid) throws Exception {
		return dao.selectMainByUidComment(userUid);
	}
	
	@Override
	public void insertUser(UserVO user) throws Exception {
		System.out.println("회원가입 : " + user.toString());
		dao.insertUser(user);
	}

	@Override
	public void deleteUserByUid(String userUid) {
		System.out.println("회원탈퇴 : " + userUid);
		dao.deleteUserByUid(userUid);
	}

	@Override
	public UserVO selectUserByUid(String userUid) {
//		System.out.println("회원조회 : " + userUid);
		return dao.selectUserByUid(userUid);
	}

	@Override
	public List<UserVO> selectUserList() {
		return dao.selectUserList();
	}

	@Override
	public void updateProfileImage(UserPhotoVO userPhoto) {
		System.out.println("프로필 이미지수정 : " + userPhoto.toString());
		
		// 1. 기존 매칭되는 사진 정보 경로 가져오기(userUid, type)
		UserPhotoVO oldUserPhoto = dao.selectUserPhotoPath(userPhoto);
		if (oldUserPhoto != null) {
			String oldPath = oldUserPhoto.getPath();
			
			// 2. 가져온 경로에 있는 파일 삭제
			File f = new File(oldPath);
			f.delete();
			// 3. 기존에 매칭되는 사진 정보 있으면 삭제(photoNo)
			dao.deleteUserPhotoByNo(oldUserPhoto.getPhotoNo());
		}
		
		// 4. 이미지 파일 업로드 정보 입력
		dao.insertUserPhoto(userPhoto);
		
		// 5. USER_TB에 USER_UID에 PHOTO_URL수정
		String path = userPhoto.getPath();
		String photoUrl = URL + servletContext.getContextPath() + "/images?path=" + path.substring(path.lastIndexOf("upload")).replaceAll("\\\\","/");
		
		UserVO user = new UserVO();
		user.setUserUid(userPhoto.getUserUid());
		user.setPhotoUrl(photoUrl);
		dao.updateUserPhotoUrl(user);
		
	}

	@Override
	public void updateBgImage(UserPhotoVO userPhoto) {
		System.out.println("배경이미지수정 : " + userPhoto.toString());
		UserPhotoVO oldUserPhoto = dao.selectUserPhotoPath(userPhoto);
		if (oldUserPhoto != null) {
			String oldPath = oldUserPhoto.getPath();
			
			File f = new File(oldPath);
			f.delete();
			
			dao.deleteUserPhotoByNo(oldUserPhoto.getPhotoNo());
		}
		
		dao.insertUserPhoto(userPhoto);
		
		String path = userPhoto.getPath();
		String bgPhotoUrl = URL + servletContext.getContextPath() + "/images?path=" + path.substring(path.lastIndexOf("upload")).replaceAll("\\\\","/");
		
		UserVO user = new UserVO();
		user.setUserUid(userPhoto.getUserUid());
		user.setBgPhotoUrl(bgPhotoUrl);
		dao.updateUserBgPhotoUrl(user);	
	}
		
	@Override
	public void updateUserByUid(UserVO user) {
		System.out.println("회원수정 : "+ user.toString());
		dao.updateUserByUid(user);
	}

	@Override
	public List<LocationVO> selectLocationList() {
		return dao.selectLocationList();
	}

	@Override
	public LocationVO selectLocationByNo() {
		return dao.selectLocationByNo();
	}
}
