package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		String name=request.getParameter("name");
		String P_code=request.getParameter("codeFirst")+"-"+request.getParameter("codeLast");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("emailFirst")+"@"+request.getParameter("emailLast");
		String postnumber=request.getParameter("postnumber");
		String address=request.getParameter("addressFirst")+" "+request.getParameter("addressLast");
		String Phonenumber=request.getParameter("phonenumber");
		String job=request.getParameter("job");
		String chk_mail=request.getParameter("chk_mail");
		String[] interests=request.getParameterValues("interest");
		
		
		PrintWriter out=response.getWriter();
		out.print("<html><body>");
		out.println("이름 : <b>");
		out.println(name);
		out.println("</b><br>주민등록번호 : <b>");
		out.println(P_code);
		out.println("</b><br>id : <b>");
		out.println(id);
		out.println("</b><br>비밀번호 : <b>");
		out.println(pwd);
		out.println("</b><br>이메일 : <b>");
		out.println(email);
		out.println("</b><br>우편번호 : <b>");
		out.println(postnumber);
		out.println("</b><br>주소 : <b>");
		out.println(address);
		out.println("</b><br>휴대폰번호 : <b>");
		out.println(Phonenumber);
		out.println("</b><br>직업 : <b>");
		out.println(job);
		out.println("</b><br>관심분야 : <b>");
		for(String interest:interests) {
			out.println(interest+" ");
		}
		//자바스크립트로 이전 페이지로 이동하는 링크를 만들어 줌
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		out.print("</body></html>");
		out.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
