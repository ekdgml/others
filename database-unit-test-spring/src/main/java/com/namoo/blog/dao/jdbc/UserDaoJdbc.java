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

import com.namoo.blog.dao.UserDao;
import com.namoo.blog.domain.User;

@Repository
public class UserDaoJdbc implements UserDao {
	//
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<User> readAllUser() {
		//
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<User> users = new ArrayList<User>();
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT user_id, user_nm, email FROM user";
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeQuery();
			
			while (result.next()) {
				User user = new User();
				user.setUserId(result.getString("user_id"));
				user.setName(result.getString("user_nm"));
				user.setEmail(result.getString("email"));
				
				users.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("사용자 목록조회 중 오류발생", e);
		} finally {
			if (conn != null) try { conn.close(); } catch(Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
			if (result != null) try { result.close(); } catch(Exception e) {}
		}
		return users;
	}

	@Override
	public User readUser(String userId) {
		// 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		User user = null;
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT user_id, user_nm, email FROM user WHERE user_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			result = pstmt.executeQuery();
			
			if (result.next()) {
				user = new User();
				user.setUserId(result.getString("user_id"));
				user.setName(result.getString("user_nm"));
				user.setEmail(result.getString("email"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("사용자 조회 중 오류발생", e);
		} finally {
			if (conn != null) try { conn.close(); } catch(Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
			if (result != null) try { result.close(); } catch(Exception e) {}
		}
		return user;
	}

	@Override
	public void insertUser(User user) {
		// 
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO user (user_id, user_nm, email) VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("사용자 추가 중 오류발생", e);
		} finally {
			if (conn != null) try { conn.close(); } catch(Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
		}
	}

	@Override
	public void updateUser(User user) {
		// 
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "UPDATE user SET user_nm = ?, email = ? WHERE user_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getUserId());

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("사용자정보 수정 중 오류발생", e);
		} finally {
			if (conn != null) try { conn.close(); } catch(Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
		}		
	}

	@Override
	public void deleteUser(String userId) {
		// 
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "DELETE FROM user WHERE user_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("사용자정보 삭제 중 오류발생", e);
		} finally {
			if (conn != null) try { conn.close(); } catch(Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
		}		
	}
}
