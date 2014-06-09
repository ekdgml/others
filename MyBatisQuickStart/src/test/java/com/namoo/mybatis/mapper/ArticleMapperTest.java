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

import com.namoo.mybatis.domain.Article;

public class ArticleMapperTest {
	//
	private ArticleMapper articleMapper;
	@Before
	public void setUp() throws Exception {
		//
		String config = "com/namoo/mybatis/mapper/mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(config);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		
		//
		SqlSession session = factory.openSession();
		articleMapper = session.getMapper(ArticleMapper.class);
	}

	@Test
	public void testInsertArticle() {
		//
		Article article = new Article();
		article.setContents("TestContents");
		article.setSubject("TestArticle");
		
		articleMapper.insertArticle(article);
		
		assertThat(article.getNo(), is(3));
	}

	@Test
	public void testSelectArticle() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAllArticles() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateArticle() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteArticle() {
		fail("Not yet implemented");
	}

}
