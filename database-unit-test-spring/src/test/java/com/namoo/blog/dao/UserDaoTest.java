package com.namoo.blog.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.namoo.blog.domain.User;

public class UserDaoTest extends DbCommonTest {
	//
	private static final String DATASET_XML = "/UserDaoTest_dataset.xml";
	
	@Autowired
	private UserDao userDao;

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testReadAllUser() {
		//
		List<User> users = userDao.readAllUser();
		
		//검증
		assertEquals(2, users.size());
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testReadUser() {
		//
		User user = userDao.readUser("hyunohkim");
		
		// 검증
		assertEquals("김현오", user.getName());
		assertEquals("hyunohkim@nextree.co.kr", user.getEmail());
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testInsertUser() {
		//
		User user = new User();
		user.setUserId("hyunohkim2");
		user.setEmail("hyunohkim@nextree.co.kr");
		user.setName("김현오");
		
		userDao.insertUser(user);
		
		// 검증
		user = userDao.readUser("hyunohkim2");
		assertEquals("hyunohkim@nextree.co.kr", user.getEmail());
		assertEquals("김현오", user.getName());
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testUpdateUser() {
		//
		User user = userDao.readUser("hong");
		user.setName("홍길순");

		userDao.updateUser(user);
		
		// 검증
		user = userDao.readUser("hong");
		assertEquals("홍길순", user.getName());
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testDeleteUser() {
		//
		assertNotNull(userDao.readUser("hong"));
		
		userDao.deleteUser("hong");

		// 검증
		assertNull(userDao.readUser("hong"));
	}

}
