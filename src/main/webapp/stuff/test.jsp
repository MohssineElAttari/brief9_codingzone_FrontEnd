<%@ page import="models.Test" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="models.Question" %>
<%@ page import="factory.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/01/2022
  Time: 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tests</title>
    <style><%@include file="/css/question.css"%></style>

    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script type="text/javascript"
            src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/bc3854343b.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
    </script>
</head>

<body>
<%@include file="/stuff/sidebar.jsp"%>
<div class="bodyContent">


    <!-- Button trigger modal -->
    <button type="button" class="btn btn-dark Btn-color" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Ajouter un test
    </button>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ajouter un test  :</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form  action="AddTestServlet" method="post">
                        <label class="form-label">Nom de Test</label>
                        <input class="form-control" type="text" name="Nomtest"/>

                        <label class="form-label" class="form-label">Description</label>
                        <textarea  class="form-control" type="text" name="description"></textarea><br>

                        <label class="form-label" class="form-label">Liste questions :</label>

                        <% List<Question> questions=DaoFactory.getQuestionImpl().findAll();%>
                        <select class="form-select" id='pre-selected-options' name="questions" multiple='multiple'>
                            <% for(Question q : questions){ %>
                            <option value='<%=q.getId_question()%>'> <%=q.getContent()%></option>
                            <% }%>
                        </select>
                        <script>
                            $('#pre-selected-options').ariaMultiSelectable();
                        </script>
                        <br>
                        <button type="submit" class="BTN-Tt" value="Add test"> Ajouter</button>

                    </form>

                </div>


            </div>
        </div>
    </div>











    <div class="incontent">
        <div class="container">
            <div class="row">
                    <%

        List<Test> list = (List<Test>) request.getAttribute("listTest");
            for(Test T:list){

    %>
    <div class="col-sm-4">

        <div class="TT">
            <div class="card-header">
                <h5 class="card-title">  <%=T.getName() %></h5>
            </div>
            <div class="card-body">

                <p class="card-text"><%=T.getDescription() %></p>
            </div>
            <div class="d-flex justify-content-around" style="margin-top: 16%">
                <a class="BTN-TDELETE" href="DeleteTestServlet?id=<%=T.getId_test()%>">Delete</a>
            </div>

        </div>

    </div>



    <%}%>
            </div>
            </div>
<div/><div/>
    </div>
</body>
</html>
