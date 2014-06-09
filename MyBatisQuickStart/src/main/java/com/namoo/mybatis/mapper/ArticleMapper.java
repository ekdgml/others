package com.namoo.mybatis.mapper;

import java.util.List;

import com.namoo.mybatis.domain.Article;

public interface ArticleMapper {
	//
	void insertArticle(Article article);
	Article selectArticle(int articleNo);
	List<Article> selectAllArticles();
	void updateArticle(Article article);
	void deleteArticle(int articleNo);
}
