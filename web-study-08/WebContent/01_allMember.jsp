<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.DriverManager" %>
    <%@page import="java.sql.ResultSet" %>
    <%@page import="java.sql.Statement" %>
    <%@page import="java.sql.Connection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Connection conn=null;
Statement stmt=null;
ResultSet rs=null;

String url="jdbc:oracle:thin:@localhost:1521:XE";
String uid="c##scott";
String pass="tiger";
String sql="select * from member";
%>
<table width='800' border='1'>
<tr>
	<th>이름</th>
	<th>아이디</th>
	<th>암호</th>
	<th>이메일</th>
	<th>전화번호</th>
	<th>권한</th>
</tr>
<%
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		conn=DriverManager.getConnection(url,uid,pass);
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		while(rs.next()){
			out.println("<tr>");
			out.println("<td>"+rs.getString("name")+"</td>");
			out.println("<td>"+rs.getString(2)+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
			out.println("<td>"+rs.getString(4)+"</td>");
			out.println("<td>"+rs.getString(5)+"</td>");
			out.println("<td>"+rs.getInt(6)+"</td>");
			out.println("</tr>");
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn !=null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>

</table>
</body>
</html>