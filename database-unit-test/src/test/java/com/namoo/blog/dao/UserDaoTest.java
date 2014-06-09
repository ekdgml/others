package com.namoo.blog.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.namoo.blog.dao.jdbc.UserDaoJdbc;
import com.namoo.blog.domain.User;

public class UserDaoTest extends DbCommonTest {

	private UserDao userDao;
	
	@Before
	public void setUp() throws Exception {
		//
		super.setUp();
		
		userDao = new UserDaoJdbc();
	}

	@After
	public void tearDown() throws Exception {
		//
		super.tearDown();
	}

	@Test
	public void testReadAllUser() {
		//
		List<User> users = userDao.readAllUser();
		
		//검증
		assertEquals(2, users.size());
	}

	@Test
	public void testReadUser() {
		//
		User user = userDao.readUser("hyunohkim");
		
		// 검증
		assertEquals("김현오", user.getName());
		assertEquals("hyunohkim@nextree.co.kr", user.getEmail());
	}

	@Test
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
	public void testDeleteUser() {
		//
		assertNotNull(userDao.readUser("hong"));
		
		userDao.deleteUser("hong");

		// 검증
		assertNull(userDao.readUser("hong"));
	}

}
