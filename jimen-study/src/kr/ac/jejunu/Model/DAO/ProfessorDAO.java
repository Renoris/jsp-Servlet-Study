package kr.ac.jejunu.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.jejunu.Model.VO.ProfessorVO;
import util.DBManager;

public class ProfessorDAO {
	private ProfessorDAO() {
		
	}
	
	private static ProfessorDAO sto=new ProfessorDAO();
	public static ProfessorDAO getInstance() {
		return sto;
	}
	
	public int findProfessor(ProfessorVO pVo) {
		int result=-1;
		String sql="select * from professor where prn=?";
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,pVo.getPrn());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				pVo.setPhone(String.valueOf(rs.getInt("phone")));
				pVo.setDepartment(rs.getString("department"));
			}
			result=1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,pstmt,rs); //rs를 밖으로 빼내기 때문에 닫으면 안된다.. 밖에서 닫아줄거임
		}
		return result;
	}
}
