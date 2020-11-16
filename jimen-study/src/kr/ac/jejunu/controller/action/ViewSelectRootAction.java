package kr.ac.jejunu.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.jejunu.Model.DAO.PersonDAO;
import kr.ac.jejunu.Model.VO.PersonVO;

public class ViewSelectRootAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PersonDAO psDo=PersonDAO.getInstance();
		ArrayList<PersonVO> list=psDo.selectPerson();
		request.setAttribute("items", list);
		RequestDispatcher dispatcher=request.getRequestDispatcher("Search.jsp");
		dispatcher.forward(request, response);
	}

}
