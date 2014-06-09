package com.namoo.blog.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.namoo.blog.domain.Blog;
import com.namoo.blog.domain.User;

public class BlogDaoTest extends DbCommonTest {
	//
	private static final String DATASET_XML = "/BlogDaoTest_dataset.xml";
	
	@Autowired
	private BlogDao blogDao;

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testReadAllBlog() {
		//
		List<Blog> blogs = blogDao.readAllBlog();
		
		// 검증
		assertEquals(2, blogs.size());
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testReadAllMyBlogs() {
		//
		List<Blog> myBlogs = blogDao.readAllMyBlogs("hyunohkim");
		
		// 검증
		assertEquals(1, myBlogs.size());
		assertEquals("김기사의 블로그", myBlogs.get(0).getName());
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testReadBlog() {
		//
		Blog blog = blogDao.readBlog(2);
		
		// 검증
		assertEquals("코스타 블로그", blog.getName());
		assertEquals("hong", blog.getOwner().getUserId());
	}

	@Test
	@DatabaseSetup(DATASET_XML)
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
	@DatabaseSetup(DATASET_XML)
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
	@DatabaseSetup(DATASET_XML)
	public void testDeleteBlog() {
		//
		assertNotNull(blogDao.readBlog(1));
		blogDao.deleteBlog(1);
		
		// 검증
		assertNull(blogDao.readBlog(1));
	}

}
