package com.namoo.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import com.namoo.mybatis.domain.Author;

public interface AuthorMapper {
	//
	void insertAuthor(Author author);
	Author selectAuthor(String authorId);
	List<Author> selectAllAuthors();
	void updateAuthor(Author author);
	
	@Delete("DELETE FROM author_tb WHERE author_id = #{authorId}")
	void deleteAuthor(String authorId);
}
