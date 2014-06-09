package com.namoo.blog.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.blog.dao.BlogDao;
import com.namoo.blog.domain.Blog;
import com.namoo.blog.domain.User;

@Repository
public class BlogDaoJdbc implements BlogDao {
	//
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Blog> readAllBlog() {
		// 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Blog> blogs = new ArrayList<Blog>();
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT blog_id, blog_nm, user_id FROM blog";
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeQuery();
			
			while (result.next()) {
				Blog blog = new Blog();
				blog.setId(result.getInt("blog_id"));
				blog.setName(result.getString("blog_nm"));
				blog.setOwner(new User(result.getString("user_id")));
				
				blogs.add(blog);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("블로그 목록조회 중 오류발생", e);
		} finally {
			if (conn != null) try { conn.close(); } catch(Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
			if (result != null) try { result.close(); } catch(Exception e) {}
		}
		return blogs;
	}

	@Override
	public List<Blog> readAllMyBlogs(String userId) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Blog> blogs = new ArrayList<Blog>();
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT blog_id, blog_nm, user_id FROM blog WHERE user_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			result = pstmt.executeQuery();
			
			while (result.next()) {
				Blog blog = new Blog();
				blog.setId(result.getInt("blog_id"));
				blog.setName(result.getString("blog_nm"));
				blog.setOwner(new User(result.getString("user_id")));
				
				blogs.add(blog);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("내 블로그 목록조회 중 오류발생", e);
		} finally {
			if (conn != null) try { conn.close(); } catch(Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
			if (result != null) try { result.close(); } catch(Exception e) {}
		}
		return blogs;
	}

	@Override
	public Blog readBlog(int blogId) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		Blog blog = null;
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT blog_id, blog_nm, user_id FROM blog WHERE blog_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, blogId);
			
			result = pstmt.executeQuery();
			
			if (result.next()) {
				blog = new Blog();
				blog.setId(result.getInt("blog_id"));
				blog.setName(result.getString("blog_nm"));
				blog.setOwner(new User(result.getString("user_id")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("블로그 정보조회 중 오류발생", e);
		} finally {
			if (conn != null) try { conn.close(); } catch(Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
			if (result != null) try { result.close(); } catch(Exception e) {}
		}
		return blog;
	}

	@Override
	public int insertBlog(Blog blog) {
		// 
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO blog (blog_nm, user_id) VALUES (?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, blog.getName());
			pstmt.setString(2, blog.getOwner().getUserId());
			pstmt.executeUpdate();
			
			ResultSet genKeys = pstmt.getGeneratedKeys();
			if (genKeys.next()) {
				blog.setId(genKeys.getInt(1));
			}
			genKeys.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("블로그 정보추가 중 오류발생", e);
		} finally {
			if (conn != null) try { conn.close(); } catch(Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
		}
		return blog.getId();
	}

	@Override
	public void updateBlog(Blog blog) {
		// 
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "UPDATE blog SET blog_nm = ?, user_id = ? WHERE blog_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, blog.getName());
			pstmt.setString(2, blog.getOwner().getUserId());
			pstmt.setInt(3, blog.getId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("블로그 정보수정 중 오류발생", e);
		} finally {
			if (conn != null) try { conn.close(); } catch(Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
		}
	}

	@Override
	public void deleteBlog(int blogId) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "DELETE FROM blog WHERE blog_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, blogId);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("블로그 삭제 중 오류발생", e);
		} finally {
			if (conn != null) try { conn.close(); } catch(Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
		}
	}
}
