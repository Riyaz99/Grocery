package com.cg.gsm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.gsm.entities.UserEntity;
import com.cg.gsm.exception.DuplicateRecordException;
import com.cg.gsm.repository.UserDAOInt;

@Service
public class UserServiceImp /*implements UserServiceInt */{

	
	/*
	 * @Autowired private UserDAOInt uRepository;
	 * 
	 * @Transactional public List<UserEntity> search(UserEntity bean) {
	 * 
	 * return uRepository.search(bean); }
	 */
	 
	/*@Override
	@Transactional	
	public long add(UserEntity bean) throws DuplicateRecordException {
	return 0;
}
/*
 * @Transactional public void delete(UserEntity bean) { }
 * 
 * @Transactional public void update(UserEntity bean) throws
 * DuplicateRecordException { }
 * 
 * @Transactional public UserEntity findByPK(long pk) { return null; }
 * 
 * @Transactional public UserEntity findByLogin(String login) { return null; }
 * 
 * @Transactional public List search(UserEntity bean, int pageNo, int pageSize)
 * { return null; }
 * 
 * @Transactional public boolean changePassword(Long id, String
 * oldPassword,String newPassword) { return false; }
 * 
 * @Transactional public UserEntity authenticate(UserEntity bean) { return null;
 * }
 * 
 * @Transactional public long registerUser(UserEntity bean) throws
 * DuplicateRecordException { return 0; }
 * 
 * @Transactional public boolean forgetPassword(String login) { return false; }
 */

}