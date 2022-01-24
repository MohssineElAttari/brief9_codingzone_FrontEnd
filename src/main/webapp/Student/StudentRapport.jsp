<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 17/01/2022
  Time: 02:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Rapport</title>

</head>
<body>
<h1>Test</h1>
<p> votre score est <%=request.getAttribute("score")%> / <%=request.getAttribute("totalScore")%></p>
</body>
</html>
