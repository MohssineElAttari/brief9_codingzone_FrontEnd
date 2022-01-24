
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/bc3854343b.js" crossorigin="anonymous"></script>
    <style><%@include file="/css/dashboard.css"%></style>
</head>
<body>


<div class="admin">
    <div class="sidebar">
        <div class="imgnav">
            <img src="css/logo.png">
        </div>

        <div class="grid">
            <a href="LoginServlet"><i class="fa fa-home dash"></i>Dashboard</a>
            <a href="FindQuestionServlet" ><i  class="fa fa-plus-circle"></i>Questions</a>
            <a href="FindTestServlet" ><i class="fa fa-list-alt" ></i>Tests</a>
            <a href="AffecterTestServlet" ><i class="fa fa-file-text"  ></i>Affecter Test</a>


            <a  class="log-out" href="LogOutServlet" ><i class="fa fa-sign-out"></i>Déconnexion</a>

        </div>

    </div>
</div>

<div class="email-ctn">
    <i class="fa fa-user-circle">${staff.email}</i>
</div>



</body>
</html>
