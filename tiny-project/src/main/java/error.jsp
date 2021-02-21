<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
   String errorMsg = (String) request.getAttribute("ERROR_MSG");
   String errorCode = (String) request.getAttribute("ERROR_CODE");
%>
<html>
   <head>
      <title>[Blog] 에러 페이지 </title>
   </head>
   <body>
      <h4><%=errorCode%></h4>
      <h4><%=errorMsg%></h4>
   </body>
</html>