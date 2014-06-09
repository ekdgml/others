package com.namoo.blog.dao;

import java.util.List;

import com.namoo.blog.domain.Post;

public interface PostDao {
	//
	List<Post> readAllPosts(int blogId);
	Post readPost(int postId);
	int insertPost(int blogId, Post post);
	void updatePost(Post post);
	void deletePost(int postId);
}
