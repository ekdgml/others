package com.namoo.blog.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.namoo.blog.dao.jdbc.BlogDaoJdbc;
import com.namoo.blog.domain.Blog;
import com.namoo.blog.domain.User;

public class BlogDaoTest extends DbCommonTest {
	
	private BlogDao blogDao;

	@Before
	public void setUp() throws Exception {
		//
		super.setUp();
		blogDao = new BlogDaoJdbc();
	}

	@After
	public void tearDown() throws Exception {
		//
		super.tearDown();
		
	}

	@Test
	public void testReadAllBlog() {
		//
		List<Blog> blogs = blogDao.readAllBlog();
		
		// 검증
		assertEquals(2, blogs.size());
	}

	@Test
	public void testReadAllMyBlogs() {
		//
		List<Blog> myBlogs = blogDao.readAllMyBlogs("hyunohkim");
		
		// 검증
		assertEquals(1, myBlogs.size());
		assertEquals("김기사의 블로그", myBlogs.get(0).getName());
	}

	@Test
	public void testReadBlog() {
		//
		Blog blog = blogDao.readBlog(2);
		
		// 검증
		assertEquals("코스타 블로그", blog.getName());
		assertEquals("hong", blog.getOwner().getUserId());
	}

	@Test
	public void testInsertBlog() {
		//
		Blog blog = new Blog();
		blog.setName("테스트 블로그");
		blog.setOwner(new User("hyunohkim"));
		
		int blogId = blogDao.insertBlog(blog);
		
		blog = blogDao.readBlog(blogId);
		
		// 검증
		assertEquals("테스트 블로그", blog.getName());
		assertEquals("hyunohkim", blog.getOwner().getUserId());
	}

	@Test
	public void testUpdateBlog() {
		//
		Blog blog = blogDao.readBlog(1);
		blog.setName("헤롤드의 블로그");
		
		blogDao.updateBlog(blog);
		
		// 검증
		blog = blogDao.readBlog(1);
		assertEquals("헤롤드의 블로그", blog.getName());
	}

	@Test
	public void testDeleteBlog() {
		//
		assertNotNull(blogDao.readBlog(1));
		blogDao.deleteBlog(1);
		
		// 검증
		assertNull(blogDao.readBlog(1));
	}

}
