package ttp;

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.zkoss.org/jsp/zul" prefix="z" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>foreach Example</title>
</head>
<body>
      <z:page zscriptLanguage="java">
         <h3>Iteration using JSTL Tags</h3>
		 <p>use JSTL Tag: "forEach" Tag.<p>

      		<z:window id="win2" title="ZK is best!!!" width="75%" border="normal">
      		<p>Use JSTL forEach Tag to create Treeitem Components.</p>

				<c:forEach var="i" begin="1" end="3" step="1" varStatus="status">
					<z:label value="Item Number :${i}"/><br>
					</c:forEach>
			</z:window>
      	</z:page>

</body>
</html>