package com.namoo.mybatis.mapper;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.namoo.mybatis.domain.Author;

public class AuthorMapperTest {
	//
	private AuthorMapper authorMapper;
	
	@Before
	public void setUp() throws Exception {
		//
		String config = "com/namoo/mybatis/mapper/mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(config);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		
		//
		SqlSession session = factory.openSession();
		authorMapper = session.getMapper(AuthorMapper.class);
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
		
		authorMapper.insertAuthor(author);
		
		//read
		author = authorMapper.selectAuthor(id);
		
		assertThat(id, is(author.getId()));
		assertThat(name, is(author.getName()));
		assertThat(email, is(author.getEmail()));
		
		//update
		author.setName("testUpdate");
		author.setEmail("testUpdate@test.com");
		
		authorMapper.updateAuthor(author);
		
		author = authorMapper.selectAuthor(id);
		
		assertThat("testUpdate", is(author.getName()));
		assertThat("testUpdate@test.com", is(author.getEmail()));
		
		//delete
		authorMapper.deleteAuthor(id);
		
		assertNull(authorMapper.selectAuthor(id));
	}
	
	@Test
	public void testInsertAuthor() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAuthor() {
		//
		Author author = authorMapper.selectAuthor("ekdgml");
		
		assertThat("ekdgml", is(author.getId()));
		assertThat("박상희", is(author.getName()));
		assertThat("ekdgml@naver.com", is(author.getEmail()));
	}

	@Test
	public void testSelectAllAuthors() {
		//
		List<Author> authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		authors = authorMapper.selectAllAuthors();
		
		assertThat(authors.size(), is(2));
		assertThat(authors.get(0).getName(), is("박상희"));
		assertThat(authors.get(1).getName(), is("홍길동"));
	}

	@Test
	public void testUpdateAuthor() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAuthor() {
		fail("Not yet implemented");
	}

}
