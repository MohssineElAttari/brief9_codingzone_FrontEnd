<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Question" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>



    <title>question</title>
    <style><%@include file="/css/question.css"%></style>

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
    <button type="button" class="btn btn-dark Btn-color" data-bs-toggle="modal" data-bs-target="#addModal">
        Ajouter une question
    </button> <br>

    <!-- Modal -->
    <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="addModalModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addModalLabel">Ajouter une question :</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form  action="AddQuestionServlet" method="post">

                        <div class="Questions" id="Questions">
                            <div class="Question">
                                <div class="Header">
                                    <label class="form-label" for="question">Question:</label>
                                    <input class="form-control" id="question" name="question" type="text"/>
                                    <label class="form-label" for="duration"> Durée:</label>
                                    <input class="form-control" id="duration" name="duration" type="number" placeholder="question duration"/>
                                    <label class="form-label" for="score">Score :</label>
                                    <input class="form-control" id="score" name="score" type="number" placeholder="question score"/>
                                </div>
                                <div class="Body">
                                    <div class="Answer">
                                        <label class="form-label" for="Answer1">Reponse 1:</label>
                                        <input class="form-control" name="Answer1" type="text" id="Answer1">
                                        <input   name="TrueAnswer" type="radio" value="1" >
                                    </div> <br>
                                    <div class="Answer">
                                        <label class="form-label" class="form-label" for="Answer2">Reponse 2:</label>
                                        <input class="form-control" name="Answer2" type="text" id="Answer2">
                                        <input  name="TrueAnswer" type="radio" value="2" >
                                    </div> <br>
                                    <div class="Answer">
                                        <label class="form-label" for="Answer3">Reponse 3:</label>
                                        <input class="form-control" name="Answer3" type="text" id="Answer3">
                                        <input  name="TrueAnswer" type="radio" value="3" >
                                    </div> <br>
                                    <div class="Answer">
                                        <label class="form-label" for="Answer4">Reponse 4:</label>
                                        <input class="form-control" name="Answer4" type="text" id="Answer4">
                                        <input  name="TrueAnswer" type="radio" value="4" >
                                    </div>

                                </div>
                            </div>
                        </div><br>
                        <div class="modal-footer">
                            <button type="submit" class="BTN-Tt" value="Ajouter"> Ajouter</button>
                            <button type="button" class="BTN-Tt" data-bs-dismiss="modal">Close</button>
                        </div>

                    </form>

                </div>

            </div>
        </div>
    </div>

<div class="incontent">
    <div class="container">
    <div class="row">
        <%
            List<Question> QS = (List<Question>) request.getAttribute("listQuestion");
            for(Question Q:QS){

                String[] checked = new String[4];
                checked[Q.getTrueAnswer()-1]="checked";

        %>
        <div class="col-sm-4">

            <div class="TT">
                <div class="card-header">
                    <h5 class="card-title">  Question:<%=Q.getId_question() %></h5>
                </div>
                <div class="card-body">

                    <p class="card-text"><%=Q.getContent() %></p>
                </div>
                <div class="d-flex justify-content-around" style="margin-top: 16%">
                    <a href="#" class="BTN-T"  data-bs-toggle="modal" data-bs-target="#showModal<%=Q.getId_question() %>">détails...</a>
                    <a class="BTN-T" href="DeleteQuestionServlet?action=delete&id=<%=Q.getId_question()%>">Delete</a>
                    <a class="BTN-T" data-bs-toggle="modal" data-bs-target="#editeModal<%=Q.getId_question() %>">Edite</a>
                </div>

            </div>

        </div>
        <!-- Modal Edite -->
        <div class="modal fade" id="editeModal<%=Q.getId_question() %>" tabindex="-1" aria-labelledby="editeModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="editeModalLabel">Modifier une question :</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form  action="UpdateQuestionServlet" method="post">
                            <input value="<%=Q.getId_question() %>" id="id_question" name="id_question" type="hidden" />
                            <div class="Questions" id="Questions">
                                <div class="Question">
                                    <div class="Header">
                                        <label class="form-label" for="question">Question:</label>
                                        <input value="<%=Q.getContent() %>" class="form-control" id="question" name="question" type="text"/>
                                        <label class="form-label" for="duration"> Durée:</label>
                                        <input value="<%=Q.getDuration() %>" class="form-control" id="duration" name="duration" type="number" placeholder="question duration"/>
                                        <label class="form-label" for="score">Score :</label>
                                        <input value="<%=Q.getScore() %>" class="form-control" id="score" name="score" type="number" placeholder="question score"/>
                                    </div>
                                    <div class="Body">
                                        <div class="Answer">
                                            <label class="form-label" for="Answer1">Reponse 1:</label>
                                            <input value="<%=Q.getReponse1() %>" class="form-control" name="Answer1" type="text" id="Answer1">
                                            <input   name="TrueAnswer" type="radio"  value="1" <%= checked[0] %> >
                                        </div> <br>
                                        <div class="Answer">
                                            <label class="form-label" class="form-label" for="Answer2">Reponse 2:</label>
                                            <input value="<%=Q.getReponse2() %>" class="form-control" name="Answer2" type="text" id="Answer2">
                                            <input  name="TrueAnswer" type="radio" value="2" <%= checked[1] %> >
                                        </div> <br>
                                        <div class="Answer">
                                            <label class="form-label" for="Answer3">Reponse 3:</label>
                                            <input value="<%=Q.getReponse3() %>" class="form-control" name="Answer3" type="text" id="Answer3">
                                            <input  name="TrueAnswer" type="radio" value="3" <%= checked[2] %> >
                                        </div> <br>
                                        <div class="Answer">
                                            <label class="form-label" for="Answer4">Reponse 4:</label>
                                            <input value="<%=Q.getReponse4() %>" class="form-control" name="Answer4" type="text" id="Answer4">
                                            <input   name="TrueAnswer" type="radio" value="4" <%= checked[4] %> >
                                        </div>

                                    </div>
                                </div>
                            </div><br>
                            <div class="modal-footer">
                                <button type="submit" class="BTN-T" value="Ajouter"> Modifier</button>
                                <button type="button" class="BTN-T" data-bs-dismiss="modal">Close</button>
                            </div>

                        </form>

                    </div>

                </div>
            </div>
        </div>
        <!-- Modal show question -->
        <div class="modal fade" id="showModal<%=Q.getId_question() %>" tabindex="-1" aria-labelledby="showModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="showModalLabel">question:<%=Q.getId_question() %>"</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form  action="#" method="post">
                            <input value="<%=Q.getId_question() %>" id="id_question" name="id_question" type="hidden" />
                            <div class="Questions" id="Questions">
                                <div class="Question">
                                    <div class="Header">
                                        <label class="form-label" for="question">Question:</label>
                                        <input value="<%=Q.getContent() %>" class="form-control" id="question" name="question" type="text"/readonly>
                                        <label class="form-label" for="duration"> Durée:</label>
                                        <input value="<%=Q.getDuration() %>" class="form-control" id="duration" name="duration" type="number" readonly/>
                                        <label class="form-label" for="score">Score :</label>
                                        <input value="<%=Q.getScore() %>" class="form-control" id="score" name="score" type="number" readonly/>
                                    </div>
                                    <div class="Body">
                                        <div class="Answer">
                                            <label class="form-label" for="Answer1">Reponse 1:</label>
                                            <input value="<%=Q.getReponse1() %>" class="form-control" name="Answer1" type="text" id="Answer1" readonly >
                                            <input   name="TrueAnswer" type="radio"  value="1" <%= checked[1] %> readonly>
                                        </div> <br>
                                        <div class="Answer">
                                            <label class="form-label" class="form-label" for="Answer2">Reponse 2:</label>
                                            <input value="<%=Q.getReponse2() %>" class="form-control" name="Answer2" type="text" id="Answer2" readonly>
                                            <input   name="TrueAnswer" type="radio" value="2" <%= checked[2] %> readonly>
                                        </div> <br>
                                        <div class="Answer">
                                            <label class="form-label" for="Answer3">Reponse 3:</label>
                                            <input value="<%=Q.getReponse3() %>" class="form-control" name="Answer3" type="text" id="Answer3"readonly>
                                            <input name="TrueAnswer" type="radio" value="3" <%= checked[3] %> readonly>
                                        </div> <br>
                                        <div class="Answer">
                                            <label class="form-label" for="Answer4">Reponse 4:</label>
                                            <input value="<%=Q.getReponse4() %>" class="form-control" name="Answer4" type="text" id="Answer4"readonly>
                                            <input   name="TrueAnswer" type="radio" value="4" <%= checked[4] %> readonly>
                                        </div>

                                    </div>
                                </div>
                            </div><br>
                            <div class="modal-footer">

                                <button type="button" class="BTN-T" data-bs-dismiss="modal">Close</button>
                            </div>

                        </form>

                    </div>

                </div>
            </div>
        </div>
        <%}%>
    </div>
    </div>

</div>


</div>
</body>
</html>
