package util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Context initContext =new InitialContext();
			Context envContext=(Context) initContext.lookup("java:/comp/env");
			DataSource ds=(DataSource) envContext.lookup("jdbc/myoracle");//jdbc/myoracle 이란 이름을 객체가 찾아서 DataSource 가 받는다
			conn=ds.getConnection();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return conn;
	}
	
	//한꺼번에 해제하기 편하게 위해 만든 클래스1 select 용
	public static void close(Connection conn, Statement pstmt, ResultSet rs ) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//한꺼번에 해제하기 편하게 위해 만든 클래스2 update delete insert용
	public static void close(Connection conn, Statement pstmt) {
		try {
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
