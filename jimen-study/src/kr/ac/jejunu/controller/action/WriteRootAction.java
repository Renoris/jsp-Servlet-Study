package kr.ac.jejunu.controller.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.jejunu.Model.DAO.PersonDAO;
import kr.ac.jejunu.Model.DAO.ProfessorDAO;
import kr.ac.jejunu.Model.DAO.StudentDAO;
import kr.ac.jejunu.Model.VO.PersonVO;
import kr.ac.jejunu.Model.VO.ProfessorVO;
import kr.ac.jejunu.Model.VO.StudentVO;
import util.CheckingNumber;

public class WriteRootAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result=-1;
		String phone=null;
		PersonVO psVo=new PersonVO();
		if(request.getParameter("identity").equals("etc")) {
			result=1;
			psVo.setDepartment(request.getParameter("department"));
			SimpleDateFormat format1=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			Date time=new Date();
			psVo.setIdentity("기타");
			psVo.setLocation(request.getParameter("location"));
			psVo.setName(request.getParameter("name"));
			psVo.setPhone(request.getParameter("phone"));
			psVo.setPurpose(request.getParameter("purpose"));
			resultcheck(request,result);
		}else {
			StudentVO sVo=null;
			ProfessorVO pVo=null;
			if(request.getParameter("identity").equals("student")) {
				sVo=new StudentVO();
				sVo.setName(request.getParameter("name"));
				
				sVo.setDepartment(request.getParameter("department"));
				if(!CheckingNumber.checkNum(request.getParameter("stn"))) {
					request.setAttribute("message", "학번이 잘못되었습니다");
					RequestDispatcher dispatcher =request.getRequestDispatcher("/Main.jsp");
					dispatcher.forward(request, response);
				}
				sVo.setStn(Integer.parseInt(request.getParameter("stn")));
				StudentDAO sDo=StudentDAO.getInstance();
				result=sDo.findstudent(sVo);
				psVo.setPhone(sVo.getPhone());
				psVo.setDepartment(sVo.getDepartment());
			}else {
				pVo=new ProfessorVO();
				pVo.setName(request.getParameter("name"));
				pVo.setDepartment(request.getParameter("department"));
				if(!CheckingNumber.checkNum(request.getParameter("stn"))) {
					request.setAttribute("message", "학번이 잘못되었습니다");
					RequestDispatcher dispatcher =request.getRequestDispatcher("/Main.jsp");
					dispatcher.forward(request, response);
				}
				pVo.setPrn(Integer.parseInt(request.getParameter("stn")));
				ProfessorDAO pDo=ProfessorDAO.getInstance();
				result=pDo.findProfessor(pVo);
				psVo.setPhone(pVo.getPhone());
				psVo.setDepartment(pVo.getDepartment());
			}
			SimpleDateFormat format1=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			Date time=new Date();
			psVo.setIdentity(request.getParameter("identity"));
			psVo.setLocation(request.getParameter("location"));
			psVo.setName(request.getParameter("name"));
			psVo.setPurpose(request.getParameter("purpose"));
			resultcheck(request,result);
		}
		PersonDAO psDo=PersonDAO.getInstance();
		psDo.insertRoot(psVo);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/Main.jsp");
		dispatcher.forward(request, response);
	}
	
	public void resultcheck(HttpServletRequest request, int result) throws ServletException, IOException {
		if(result==1) {
			request.setAttribute("message", "기록되었습니다.");
		}else {
			request.setAttribute("message", "신상정보가 맞지않습니다.");
		}
	}

}
