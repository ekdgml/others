package com.namoo.blog.dao;

import java.util.List;

import com.namoo.blog.domain.Blog;

public interface BlogDao {
	//
	List<Blog> readAllBlog();
	List<Blog> readAllMyBlogs(String userId);
	Blog readBlog(int blogId);
	int insertBlog(Blog blog);
	void updateBlog(Blog blog);
	void deleteBlog(int blogId);
}
