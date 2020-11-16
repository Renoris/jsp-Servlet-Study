package kr.ac.jejunu.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.ac.jejunu.Model.VO.PersonVO;
import util.DBManager;

public class PersonDAO {
	private PersonDAO() {
	}
	
	private static PersonDAO instance=new PersonDAO();
	
	public static PersonDAO getInstance() {
		return instance;
	}
	
	//입력
	public int insertRoot(PersonVO psVo) {
		int result=-1;
		String sql1="insert into person (identity,department,location,name,entertime,phone,purpose) values(?,?,?,?,?,?,?)";
		String sql2="insert into person (identity,department,location,name,exittime,phone,purpose) values(?,?,?,?,?,?,?)";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DBManager.getConnection();
			Date date=new Date();
			SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String now=format.format(date);
			if(psVo.getExittime()==null) {
				pstmt=conn.prepareStatement(sql1);
				pstmt.setString(5, now);
			}else {
				pstmt=conn.prepareStatement(sql2);
				pstmt.setString(5, now);
			}
			pstmt.setString(1, psVo.getIdentity());
			pstmt.setString(2, psVo.getDepartment());
			pstmt.setString(3, psVo.getLocation());
			pstmt.setString(4, psVo.getName());
			pstmt.setString(6, psVo.getPhone());
			pstmt.setString(7, psVo.getPurpose());
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	
	public ArrayList<PersonVO> selectPerson() {
		ArrayList<PersonVO> personlist=null;
		
		String sql="select * from person";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			personlist=new ArrayList<PersonVO>();
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				PersonVO pVo=new PersonVO();
				pVo.setDepartment(rs.getString("department"));
				if(rs.getString("entertime")!=null) {
				pVo.setEntertime(rs.getString("entertime"));
				}else {
					pVo.setExittime(rs.getString("exittime"));
				}
				pVo.setIdentity(rs.getString("identity"));
				pVo.setLocation(rs.getString("location"));
				pVo.setName(rs.getString("name"));
				pVo.setPhone(String.valueOf(rs.getInt("phone")));
				pVo.setPurpose(rs.getString("purpose"));
				personlist.add(pVo);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return personlist;
	}
	
}
