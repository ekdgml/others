package com.namoo.blog.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.namoo.blog.dao.jdbc.PostDaoJdbc;
import com.namoo.blog.domain.Post;

public class PostDaoTest extends DbCommonTest {

	private PostDaoJdbc postDao;

	@Before
	public void setUp() throws Exception {
		//
		super.setUp();
		postDao = new PostDaoJdbc();
	}

	@After
	public void tearDown() throws Exception {
		//
		super.tearDown();
	}

	@Test
	public void testReadAllPosts() {
		//
		List<Post> posts = postDao.readAllPosts(1);
		
		// 검증
		assertEquals(2, posts.size());
	}

	@Test
	public void testReadPost() {
		//
		Post post = postDao.readPost(2);
		
		// 검증
		assertEquals("DB 단위 테스트", post.getSubject());
	}

	@Test
	public void testInsertPost() {
		//
		Post post = new Post();
		post.setSubject("단위테스트 잘 작성하기");
		post.setContents("열심히 합시다!");
		
		int postId = postDao.insertPost(1, post);
		
		post = postDao.readPost(postId);
		
		// 검증
		assertEquals("단위테스트 잘 작성하기", post.getSubject());
	}

	@Test
	public void testUpdatePost() {
		//
		Post post = postDao.readPost(1);
		post.setSubject("테스트 제목");
		
		postDao.updatePost(post);
		
		// 검증
		post = postDao.readPost(1);
		assertEquals("테스트 제목", post.getSubject());
	}

	@Test
	public void testDeletePost() {
		//
		assertNotNull(postDao.readPost(1));
		
		postDao.deletePost(1);
		
		// 검증
		assertNull(postDao.readPost(1));
	}

}
