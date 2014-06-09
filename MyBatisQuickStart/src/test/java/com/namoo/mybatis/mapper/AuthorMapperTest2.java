package com.namoo.mybatis.mapper;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.namoo.mybatis.domain.Author;

public class AuthorMapperTest2 {
	//
	private SqlSession session;
	
	@Before
	public void setUp() throws Exception {
		//
		String config = "com/namoo/mybatis/mapper/mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(config);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		
		//
		session = factory.openSession();
	}
	
	@Test
	public void testCRUD() {
		//
		String id = "testUser";
		String name = "test";
		String email = "test@test.com";
		
		//create
		Author author = new Author();
		author.setEmail(email);
		author.setId(id);
		author.setName(name);
		
		//authorMapper.insertAuthor(author);
		session.insert("com.namoo.mybatis.mapper.AuthorMapper.insertAuthor", author);
		
		//read
		//author = authorMapper.selectAuthor(id);
		author = session.selectOne("com.namoo.mybatis.mapper.AuthorMapper.selectAuthor", id);
		
		assertThat(id, is(author.getId()));
		assertThat(name, is(author.getName()));
		assertThat(email, is(author.getEmail()));
		
		//update
		author.setName("testUpdate");
		author.setEmail("testUpdate@test.com");
		
		//authorMapper.updateAuthor(author);
		session.update("com.namoo.mybatis.mapper.AuthorMapper.updateAuthor", author);
		
		//author = authorMapper.selectAuthor(id);
		author = session.selectOne("com.namoo.mybatis.mapper.AuthorMapper.selectAuthor", id);
		
		assertThat("testUpdate", is(author.getName()));
		assertThat("testUpdate@test.com", is(author.getEmail()));
		
		//delete
		//authorMapper.deleteAuthor(id);
		session.delete("com.namoo.mybatis.mapper.AuthorMapper.deleteAuthor", id);
		
		//assertNull(authorMapper.selectAuthor(id));
		assertNull(session.selectOne("com.namoo.mybatis.mapper.AuthorMapper.selectAuthor", id));
		
		assertThat(session.selectList("com.namoo.mybatis.mapper.AuthorMapper.selectAllAuthors").size(), is(2));
	}
}
