<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�л�����</title>
</head>
<body>
	<h2>�л�����</h2>[<a href="/jwbook/studentControl">���ΰ�ħ</a>]
	<hr>
	<table border="1">
	 <tr><th>id</th><th>�̸�</th><th>����</th><th>����</th><th>�̸���</th></tr>
	 <c:forEach items="${students}" var="s">
	   <tr>
	       <td>${s.id}</td><td>${s.username}</td><td>${s.univ}</td><td>${s.birth}</td><td>${s.email}</td>
	    </tr>
	    </c:forEach>
	</table>
	<hr>
	<h2>�л� �߰�</h2>
	<hr>
	<form method = "post" action="/jwbook/studentControl?action=insert">
		<label>�̸�</label>
		<input type="text" name="username"><br>
		<label>����</label>
		<input type="text" name="univ"><br>
		<label>����</label>
		<input type="text" name="birth"><br>
		<label>�̸���</label>
		<input type="text" name="email"><br>
		<button type="submit">���</button>
		
	</form>
</body>
</html>