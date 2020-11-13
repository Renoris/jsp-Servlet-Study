package kr.ac.jejunu.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import oracle.jdbc.proxy.annotation.Pre;


public class MemberDAO {
	private MemberDAO() {
		
	}
	
	private static MemberDAO instance= new MemberDAO();
	
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	
	
	public Connection getConnection() throws Exception{
		Connection conn=null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds =(DataSource) envContext.lookup("jdbc/myoracle");
		conn= ds.getConnection();
		return conn;
	}
	
	
	//---메소드 추가
	//사용자 인증시 사용하는 메소드
	public int userCheck(String userid, String pwd) {
		int result= -1;
		String sql ="select pwd from member where userid=?";
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("pwd")!=null && rs.getString("pwd").equals(pwd)) {
					result=1;
				}else {
					result=0;
				}
			}else {
				result=-1;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//아이디로 회원정보를 가져오는 메소드
	public MemberVO getMember(String userid) {
		MemberVO mVo=null;
		String sql="select * from member where userid=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				mVo=new MemberVO();
				mVo.setName(rs.getString(1));
				mVo.setUserid(rs.getString(2));
				mVo.setPwd(rs.getString(3));
				mVo.setEmail(rs.getString(4));
				mVo.setPhone(rs.getString(5));
				mVo.setAdmin(rs.getInt(6));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return mVo;
	}
	
	
	//아이디 중복체크 메소드
	public int confirmID(String userid) {
		int result=-1;
		String sql="select userid from member where userid=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result=1;
			}else {
				result=-1;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public int insertMember(MemberVO mVo) {
		int result=-1;
		String sql="insert into member values(?, ?, ?, ?, ?, ?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getUserid());
			pstmt.setString(3, mVo.getPwd());
			pstmt.setString(4, mVo.getEmail());
			pstmt.setString(5, mVo.getPhone());
			pstmt.setInt(6, mVo.getAdmin());
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateMember(MemberVO mVo) {
		int result=-1;
		String sql="update member set pwd=?, email=?, phone=?, admin=?, where userid=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getPwd());
			pstmt.setString(2, mVo.getEmail());
			pstmt.setString(3, mVo.getPhone());
			pstmt.setInt(4, mVo.getAdmin());
			pstmt.setString(5, mVo.getUserid());
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
