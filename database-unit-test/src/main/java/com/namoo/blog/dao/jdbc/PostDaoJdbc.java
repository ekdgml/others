package com.namoo.blog.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.namoo.blog.dao.PostDao;
import com.namoo.blog.dao.dbconn.DbConnection;
import com.namoo.blog.domain.Post;

public class PostDaoJdbc implements PostDao {

	@Override
	public List<Post> readAllPosts(int blogId) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Post> posts = new ArrayList<Post>();
		try {
			conn = DbConnection.getConnection();
			String sql = "SELECT post_id, subject, contents FROM post WHERE blog_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, blogId);
			
			result = pstmt.executeQuery();
			
			while (result.next()) {
				Post post = new Post();
				post.setId(result.getInt("post_id"));
				post.setSubject(result.getString("subject"));
				post.setContents(result.getString("contents"));
				
				posts.add(post);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("포스트 목록 조회 중 오류발생", e);
		} finally {
			if (conn != null) try { conn.close(); } catch(Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
			if (result != null) try { result.close(); } catch(Exception e) {}
		}
		return posts;
	}

	@Override
	public Post readPost(int postId) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		Post post = null;
		try {
			conn = DbConnection.getConnection();
			String sql = "SELECT post_id, subject, contents FROM post WHERE post_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, postId);
			
			result = pstmt.executeQuery();
			
			if (result.next()) {
				post = new Post();
				post.setId(result.getInt("post_id"));
				post.setSubject(result.getString("subject"));
				post.setContents(result.getString("contents"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("포스트 조회 중 오류발생", e);
		} finally {
			if (conn != null) try { conn.close(); } catch(Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
			if (result != null) try { result.close(); } catch(Exception e) {}
		}
		return post;
	}

	@Override
	public int insertPost(int blogId, Post post) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbConnection.getConnection();
			String sql = "INSERT INTO post (subject, contents, blog_id) VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, post.getSubject());
			pstmt.setString(2, post.getContents());
			pstmt.setInt(3, blogId);
			pstmt.executeUpdate();
			
			ResultSet genKeys = pstmt.getGeneratedKeys();
			if (genKeys.next()) {
				post.setId(genKeys.getInt(1));
			}
			genKeys.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("포스트 추가 중 오류발생", e);
		} finally {
			if (conn != null) try { conn.close(); } catch(Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
		}
		return post.getId();
	}

	@Override
	public void updatePost(Post post) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbConnection.getConnection();
			String sql = "UPDATE post SET subject = ?, contents = ? WHERE post_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, post.getSubject());
			pstmt.setString(2, post.getContents());
			pstmt.setInt(3, post.getId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("포스트 수정 중 오류발생", e);
		} finally {
			if (conn != null) try { conn.close(); } catch(Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
		}
	}

	@Override
	public void deletePost(int postId) {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbConnection.getConnection();
			String sql = "DELETE FROM post WHERE post_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, postId);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("포스트 삭제 중 오류발생", e);
		} finally {
			if (conn != null) try { conn.close(); } catch(Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
		}
	}

}
