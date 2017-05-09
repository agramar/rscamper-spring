package kr.co.rscamper.controller.app;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.rscamper.domain.LocationVO;
import kr.co.rscamper.domain.UserPhotoVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.service.UserService;

@Controller
@RequestMapping("/app/user/*")
public class AppUserController {
	private static final Logger logger = LoggerFactory.getLogger(AppUserController.class);

	@Inject
	private UserService userService;

	@Inject
	private ServletContext servletContext;

	@RequestMapping(value = "/select/locations", method = RequestMethod.GET)
	public @ResponseBody List<LocationVO> selectLocationList() throws Exception {
		return userService.selectLocationList();
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public @ResponseBody void insert(UserVO user) throws Exception {
		userService.insertUser(user);
	}

	@RequestMapping(value = "/update/oneUser", method = RequestMethod.POST)
	public @ResponseBody void update(UserVO user) throws Exception {
		System.out.println("수정 : " + user.toString());
		userService.updateUserByUid(user);
	}
	
	@RequestMapping(value = "/delete/oneUser", method = RequestMethod.DELETE)
	public @ResponseBody void delete(String userUid) throws Exception {
		System.out.println("회원탈퇴 : " + userUid);
		userService.deleteUserByUid(userUid);
	}

	@RequestMapping(value = "/select/oneUser", method = RequestMethod.GET)
	public @ResponseBody UserVO selectUserByUid(String userUid) throws Exception {
		return userService.selectUserByUid(userUid);
	}

	@RequestMapping(value = "/update/profileImage", method = RequestMethod.POST)
	public @ResponseBody void updateProfileImage(UserPhotoVO userPhoto) throws Exception {
		userService.updateProfileImage(userPhoto);
	}
	
	@RequestMapping(value = "/update/bgImage", method = RequestMethod.POST)
	public @ResponseBody void updateBgImage(UserPhotoVO userPhoto) throws Exception {
		userService.updateBgImage(userPhoto);
	}
	
	@RequestMapping(value = "/upload/profileImage", method = RequestMethod.POST)
	public @ResponseBody UserPhotoVO profileImageUpload(MultipartHttpServletRequest mRequest) throws Exception {

		String path = "";
		Long size = (long) 0;
		int type = 1;
		
		String uploadDir = servletContext.getRealPath("/upload/images/profile");

		File f = new File(uploadDir);
		if (!f.exists())
			f.mkdirs();

		Iterator<String> iter = mRequest.getFileNames();
		while (iter.hasNext()) {
			String formFileName = iter.next();
			// 폼에서 파일을 선택하지 않아도 객체 생성됨
			MultipartFile mFile = mRequest.getFile(formFileName);

			// 원본 파일명
			String oriFileName = mFile.getOriginalFilename();
			
			// 확장자는 무조건 jpg
			if (oriFileName != null && !oriFileName.equals("")) {

				// 확장자 처리
				String ext = ".jpg";
				
				// 뒤쪽에 있는 . 의 위치
				int index = oriFileName.lastIndexOf(".");
				if (index != -1) {
					// 파일명에서 확장자명(.포함)을 추출
					ext = oriFileName.substring(index);
				}
				
				// 파일 사이즈
				size = mFile.getSize();
				// TODO: 50메가 넘으면 실패 반환

				// 고유한 파일명 만들기
				String saveFileName = "profile-" + UUID.randomUUID().toString() + ext;

				// 임시저장된 파일을 원하는 경로에 저장
				mFile.transferTo(new File(uploadDir + "/" + saveFileName));
				path = uploadDir + "/" + saveFileName;
			}
		}
		
		UserPhotoVO userPhotoVO = new UserPhotoVO();
		userPhotoVO.setPath(path);
		userPhotoVO.setSize(size);
		userPhotoVO.setType(type);
	
		return userPhotoVO;
	}
	
	@RequestMapping(value = "/upload/bgImage", method = RequestMethod.POST)
	public @ResponseBody UserPhotoVO bgImageUpload(MultipartHttpServletRequest mRequest) throws Exception {

		String path = "";
		Long size = (long) 0;
		int type = 2;
		
		// c:\\\\\
		String uploadDir = servletContext.getRealPath("/upload/images/background");

		File f = new File(uploadDir);
		if (!f.exists())
			f.mkdirs();

		Iterator<String> iter = mRequest.getFileNames();
		while (iter.hasNext()) {
			String formFileName = iter.next();
			// 폼에서 파일을 선택하지 않아도 객체 생성됨
			MultipartFile mFile = mRequest.getFile(formFileName);

			// 원본 파일명
			String oriFileName = mFile.getOriginalFilename();
			
			// 확장자는 무조건 jpg
			if (oriFileName != null && !oriFileName.equals("")) {

				// 확장자 처리
				String ext = ".jpg";
				
				// 뒤쪽에 있는 . 의 위치
				int index = oriFileName.lastIndexOf(".");
				if (index != -1) {
					// 파일명에서 확장자명(.포함)을 추출
					ext = oriFileName.substring(index);
				}
				
				// TODO: 이미지 섬네일 만들기
				
				// 파일 사이즈
				size = mFile.getSize();
				// TODO: 50메가 넘으면 실패 반환

				// 고유한 파일명 만들기
				String saveFileName = "bg-" + UUID.randomUUID().toString() + ext;

				// 임시저장된 파일을 원하는 경로에 저장
				mFile.transferTo(new File(uploadDir + "/" + saveFileName));
				path = uploadDir + "/" + saveFileName;
			}
		}
		
		UserPhotoVO userPhotoVO = new UserPhotoVO();
		userPhotoVO.setPath(path);
		userPhotoVO.setSize(size);
		userPhotoVO.setType(type);
	
		return userPhotoVO;
	}
	
}