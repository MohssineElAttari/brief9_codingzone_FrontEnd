<%@ page import="models.Question" %>
<%--

  Created by IntelliJ IDEA.
  User: admin
  Date: 10/01/2022
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edite Question</title>
    <style><%@include file="/css/question.css"%></style>
</head>

<body>
<%@include file="/stuff/sidebar.jsp"%>
<div class="bodyContent">

    <div class="container d-flex justify-content-center">

       <div class="row w-50">
           <form  action="UpdateQuestionServlet"  method="post">

               <%

                   Question Q =(Question) request.getAttribute("question");
//                   String[] checked = new String[5];
//                   FOR TESTING
                   String[] checked = new String[10];

                   checked[Q.getTrueAnswer()]="checked";

               %>

               <div class="Questions" id="Questions">
                   <h2> <%=Q.getTrueAnswer() %></h2>
                   <div class="Question">
                       <div class="Header">
                           <label class="form-label" for="question">question:</label>
                           <input class="form-control"  value="<%=Q.getContent() %>" id="question" name="question" type="text"/>

                           <label class="form-label" for="question">Id question :</label>
                           <input class="form-control" value="<%=Q.getId_question() %>" id="id_question" name="id_question" type="number" placeholder="id_question"/>

                           <label class="form-label" for="question">Durée :</label>
                           <input class="form-control" value="<%=Q.getDuration() %>" id="duration" name="duration" type="number" placeholder="question duration"/>

                           <label class="form-label" for="question">Score :</label>
                           <input class="form-control" value="<%=Q.getScore() %>" id="score" name="score" type="number" placeholder="question score"/>
                       </div>
                       <div class="Body">
                           <div class="Answer">
                               <label class="form-label" for="Answer1">Reponse 1:</label>
                               <input class="form-control"  value="<%=Q.getReponse1() %>" name="Answer1" type="text" id="Answer1">
                               <input class="form-check-input"  name="TrueAnswer" type="radio" value="1" <%= checked[1] %>  >
                           </div>
                           <div class="Answer">
                               <label class="form-label" for="Answer2">Reponse 2:</label>
                               <input class="form-control"  value="<%=Q.getReponse2() %>" name="Answer2" type="text" id="Answer2">
                               <input class="form-check-input"  name="TrueAnswer" type="radio" value="2" <%= checked[2] %> >
                           </div>
                           <div class="Answer">
                               <label class="form-label" for="Answer3">Reponse 3:</label>
                               <input class="form-control"  value="<%=Q.getReponse3() %>" name="Answer3" type="text" id="Answer3">
                               <input class="form-check-input" name="TrueAnswer" type="radio"  value="3" <%= checked[3] %> >
                           </div>
                           <div class="Answer">
                               <label class="form-label" for="Answer4">Reponse 4:</label>
                               <input class="form-control"  value="<%=Q.getReponse4() %>" name="Answer4" type="text" id="Answer4">
                               <input class="form-check-input"  name="TrueAnswer" type="radio"  value="4" <%= checked[4] %> >
                           </div>

                       </div>
                   </div>
               </div> <br>
               <button type="submit" class="btn btn-primary" value="Update"> Update</button>

           </form>

       </div>

    </div>



</div>
</body>


</html>
