package kr.ac.jejunu.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.jejunu.Model.VO.StudentVO;
import util.DBManager;

public class StudentDAO {

	private StudentDAO() {
		
	}
	
	private static StudentDAO sto=new StudentDAO();
	public static StudentDAO getInstance() {
		return sto;
	}
	
	public int findstudent(StudentVO sVo) {
		int result=-1;
		String sql="select * from student where stn=?";
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,sVo.getStn());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				sVo.setPhone(String.valueOf(rs.getInt("phone")));
				sVo.setDepartment(rs.getString("department"));
			}
			
			result=1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,pstmt,rs);
		}
		return result;
	}

	
}
