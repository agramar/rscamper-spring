package kr.co.rscamper.persistence;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.LocationVO;
import kr.co.rscamper.domain.UserPhotoVO;
import kr.co.rscamper.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.UserMapper";
	
	@Override
	public UserVO selectMainByUidComment(String userUid) {
		return sqlSessionTemplate.selectOne(namespace + ".selectMainByUidComment", userUid);
	}

	@Override
	public void insertUser(UserVO user) {
		sqlSessionTemplate.insert(namespace + ".insertUser", user);
	}
	
	@Override
	public void updateUserByUid(UserVO user) {
		sqlSessionTemplate.update(namespace + ".updateUserByUid", user);
	}
	
	@Override
	public void deleteUserByUid(String userUid) {
		sqlSessionTemplate.delete(namespace + ".deleteUserByUid", userUid);
	}

	@Override
	public UserVO selectUserByUid(String userUid) {
		return sqlSessionTemplate.selectOne(namespace + ".selectUserByUid", userUid);
	}

	@Override
	public UserPhotoVO selectUserPhotoPath(UserPhotoVO userPhoto) {
		return sqlSessionTemplate.selectOne(namespace + ".selectUserPhotoPath", userPhoto);
	}

	@Override
	public void deleteUserPhotoByNo(int photoNo) {
		sqlSessionTemplate.delete(namespace + ".deleteUserPhotoByNo", photoNo);
	}

	@Override
	public void insertUserPhoto(UserPhotoVO userPhoto) {
		sqlSessionTemplate.insert(namespace + ".insertUserPhoto", userPhoto);
	}
	
	@Override
	public void updateUserPhotoUrl(UserVO user) {
		sqlSessionTemplate.update(namespace + ".updateUserPhotoUrl", user);
	}

	@Override
	public void updateUserBgPhotoUrl(UserVO user) {
		sqlSessionTemplate.update(namespace + ".updateUserBgPhotoUrl", user); 
	}

	@Override
	public List<LocationVO> selectLocationList() {
		return sqlSessionTemplate.selectList(namespace + ".selectLocationList");
	}

	@Override
	public LocationVO selectLocationByNo() {
		// TODO Auto-generated method stub
		return null;
	}

	
	// hodong 
	@Override
	public List<UserVO> selectUserList() {
		return sqlSessionTemplate.selectList(namespace + ".selectUserList");
	}

}
