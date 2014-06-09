package com.namoo.blog.dao.dbconn;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class DbConnectionTest {

	@Test
	public void testGetConnection() throws SQLException {
		//
		Connection conn = DbConnection.getConnection();
		assertNotNull(conn);
		
		// override db connection for test
		DbConnection.overrideProperties("test-jdbc.properties");
		conn = DbConnection.getConnection();
		assertNotNull(conn);
	}
}
