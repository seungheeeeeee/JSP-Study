<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL ���տ���</title>
</head>
<body>
 <h2>JSTL ���տ���</h2>
 
 <hr>
 <h3>set, out</h3>
 <c:set var="product1" value="<h2>���� ������</h2>"/>
 <c:set var="product2" value="�Ｚ ������ ��Ʈ"/>
 <c:set var="intArray" value="��{[1, 2, 3, 4, 5]}"/>
 <p>
  	product1(jstl):
  	 <c:out value="��{product1}" default="Not registered" escapeXml="true" />
 </p>
 <p>product1(el):��{product1}</p>
 <p>intArray[2]:��{intArray[2]}</p>
 <hr>
 
 <h3>forEach: �迭 ���</h3>
 <ul>
 	<c:forEach var="num" varStatus="i" items="��{intArray}">
 		<li>��{i.index} : ��{num}</li>
 	</c:forEach>	
 </ul>
 <hr>
 
 <h3>if</h3>
 <c:set var="checkout" value="true" />
 <c:if test="��{checkout}">
 	<p>�ֹ���ǰ: ��{product2}</p>
 </c:if>
 <c:if test="��{!checkout}">
 	<p>�ֹ� ��ǰ�� �ƴ�!</p>
 </c:if>
 
 <c:if test="��{!empty product2}">
 	<p>
 		<b>��{product2} �̹� �߰���!!.</b>
 	</p>
 </c:if>
 <hr>
 
 <h3>choose, when, otherwise</h3>
 <c:choose>
 	<c:when test="��{checkout}">
 	 <p>�ֹ� ��ǰ: ��{product2} </p>
 	 </c:when>
 	 <c:otherwise>
 	  <p>�ֹ� ��ǰ�� �ƴ�!</p> 
 	 </c:otherwise>
 	</c:choose>
 	 <hr>
 	 
 <h3>forTokens</h3>
 	 <c:forTokens var="city" items="Seoul|Tokyo|New York|Toronto " delims="|" varStatus="i">
 	 <c:if test="��{i.first}">���� ��� : </c:if>
 	 ��{city}
 	 <c:if test="��{i.first}">,</c:if>
 	 </c:forTokens>
 	 
 	 <hr>
</body>
</html>