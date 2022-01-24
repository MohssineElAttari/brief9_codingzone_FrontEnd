<%@ page import="models.Test" %>
<%@ page import="models.Student" %>
<%@ page import="models.TestStudent" %>
<%@ page import="models.Question" %>
<%@ page import="daoImpl.QuestionDaoImpl" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<%
    Test test=(Test)request.getAttribute("test");
    Student student=(Student) request.getAttribute("student");
    TestStudent testStudent=(TestStudent) request.getAttribute("testStudent");
    QuestionDaoImpl daoQ=new QuestionDaoImpl();
%>

<head>

    <title>Rapport</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/bc3854343b.js" crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script type="text/javascript"
            src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
    <style><%@include file="/css/style.css"%></style>
    <style>
        td[correct]{
            background-color: lightseagreen;
        }
        span[answer]{
            margin-right: 20px;
            height: 20px;
            width: 20px;
            background: url("https://www.pinclipart.com/picdir/middle/94-941509_png-images-free-download-transparent-background-error-svg.png") ;
            display: block;
            background-size: cover;
        }
        span[answer][correct]{

            margin-right: 20px;
            height: 20px;
            width: 20px;
            background: url("https://static.vecteezy.com/system/protected/files/001/200/261/vecteezy_check_1200261.png") ;
            display: block;
            background-size: cover;
        }

        *, *::before, *::after {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        :root {
            --primary: #34b53a;
            --primary-light: #e2fbd7;
            --secondary: #4339f2;
            --secondary-light: #dad7fe;
            --instagram: #ff3a29;
            --instagram-light: #ffe5d3;
        }
        body {
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: #f8f8f8;
        }
        .card {
            width: 50vw;
            background: #fff;
            padding: 20px 20px 30px 20px;
            font-family: system-ui;
            border-radius: 10px;
        }
        .card__header {
            display: flex;
            align-items: center;
        }
        .card__header img {
            height: 70px;
            width: 70px;
            border-radius: 50%;
            object-fit: cover;
            margin-right: 10px;
        }
        .card__header__info h2 {
            font-size: 22px;
            font-weight: normal;
        }
        .card__header__info span {
            opacity: 0.7;
            font-size: 14px;
        }
        .card__header__actions {
            font-size: 22px;
            cursor: pointer;
            margin-left: auto;
            align-self: flex-start;
        }
        .card__statistics {
            display: flex;
            flex-wrap: wrap;
            align-items: center;
            margin-top: 20px;
        }
        .card__statistics__topic {
            font-weight: normal;
            font-size: 14px;
        }
        .card__statistics__value {
            margin-left: auto;
            font-size: 14px;
            color: var(--primary);
        }
        .card__statistics__progress {
            height: 8px;
            margin-top: 7px;
            border-radius: 20px;
            background: var(--primary-light);
            flex-basis: 100%;
        }
        .card__statistics__progress .fill {
            border-radius: 20px;
            width: 50%;
            height: 100%;
            background: var(--primary);
        }

    </style>
</head>
<body>

<div class="card">
    <h1 style="font-size: 22px;font-weight: normal;text-align: center;padding: 20px;">Rapport de votre Test <%= test.getName() %> </h1>
    <div class="card__header">
        <img
                src="https://www.pngfind.com/pngs/m/470-4703547_icon-user-icon-hd-png-download.png"
                alt=""
        />
        <div class="card__header__info">
            <h2><%= student.getFistNameStudent() %> <%= student.getLastNameStudent() %></h2>
            <span>développeur full-stack</span>
        </div>
        <span
                class="card__header__actions mdi mdi-dots-horizontal"
                role="button"
                tabindex="1">
        </span>
    </div>
    <div class="code-form-1">
        <h3>Score</h3>
        <%--        <p> votre score est <%=request.getAttribute("score")%> / <%=request.getAttribute("totalScore")%></p>--%>
        <div class="d-flex justify-content-around InfoScore">
            <div class="divrating">
                <div class="rating"><%=testStudent.getScore()%>/<%=testStudent.getFullScore()%></div>

            </div>
        </div>
    </div>
    <div>
        <% for(Question q:test.getQuestions()){%>
        <hr>
        <br>
        <div class="question"><span>(<%=q.getScore()%> points)</span><%=q.getContent()%></div>
        <div class="reponses">
            <table>
                <tr>
                    <td><span <%=daoQ.getStudentAnswer(testStudent,q.getId_question())==1?"answer":""%>  <%=daoQ.getStudentAnswer(testStudent,q.getId_question())==q.getTrueAnswer()?"correct":""%>></span></td><td <%=q.getTrueAnswer()==1?"correct":""%>><%=q.getReponse1()%></td>
                </tr>
                <tr>
                   <td><span <%=daoQ.getStudentAnswer(testStudent,q.getId_question())==2?"answer":""%>  <%=daoQ.getStudentAnswer(testStudent,q.getId_question())==q.getTrueAnswer()?"correct":""%>></span></td>   <td <%=q.getTrueAnswer()==2?"correct":""%>><%=q.getReponse2()%></td>
                </tr>
                <tr>
                    <td><span <%=daoQ.getStudentAnswer(testStudent,q.getId_question())==3?"answer":""%>  <%=daoQ.getStudentAnswer(testStudent,q.getId_question())==q.getTrueAnswer()?"correct":""%>></span></td> <td <%=q.getTrueAnswer()==3?"correct":""%>><%=q.getReponse3()%></td>
                </tr>
                <tr>
                   <td><span <%=daoQ.getStudentAnswer(testStudent,q.getId_question())==4?"answer":""%>  <%=daoQ.getStudentAnswer(testStudent,q.getId_question())==q.getTrueAnswer()?"correct":""%>></span></td>  <td <%=q.getTrueAnswer()==4?"correct":""%>><%=q.getReponse4()%></td>
                </tr>
            </table>
        </div>
        <%}%>
    </div>

</div>
</body>
<script>

    const rating = document.querySelector(".rating");
    const ratingContent = rating.innerHTML;
    var res = ratingContent.split("/");
    console.log(res[0]);
    console.log(res[1]);

    const score =parseInt(res[0], 10);
    const scoretot =parseInt(res[1], 10);
    const percent =(score*100)/scoretot;

    console.log(percent)

    const scoreClass =
        percent < 40 ? "bad" : percent < 60 ? "meh" : "good";

    rating.classList.add(scoreClass);

    const ratingColor = window.getComputedStyle(rating).backgroundColor;
    console.log(ratingColor)
    const gradient = "background: conic-gradient("+ratingColor +percent+"%, black 0 100%)";

    rating.setAttribute("style", gradient);

    rating.innerHTML = "<span>"+score+"/"+scoretot+"</span>";


</script>
</html>



