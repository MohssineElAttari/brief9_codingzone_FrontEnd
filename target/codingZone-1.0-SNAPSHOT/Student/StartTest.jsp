<%@ page import="models.Test" %>
<%@ page import="models.Question" %>
<%@ page import="models.Student" %>
<%@ page import="models.TestStudent" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Test test=(Test)request.getAttribute("test");
    Student student=(Student) request.getAttribute("student");
    TestStudent testStudent=(TestStudent) request.getAttribute("testStudent");

%>
<html>
<head>
    <title>Youcode Quiz</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/bc3854343b.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
    <style><%@include file="/css/style.css"%></style>
    <script>
        var nbrQuestion=<%=test.getQuestions().size()%>;
        var enCours=1;
        var enCoursInterval=<%=test.getQuestions().get(0).getDuration()%>;
    </script>
    <style>
        .hide{display: none}
    </style>
</head>
<body>

<div class="container code-container">

<form action="ScoreServlet" method="post" id="QForm">
    <input type="hidden" name="test" value="<%=testStudent.getIdTest()%>"/>
    <input type="hidden" name="student" value="<%=testStudent.getIdStudent()%>"/>
    <input type="hidden" name="testStudent" value="<%=testStudent.getIdTestStudent()%>"/>

    <div class="container mt-5">
        <div class="d-flex justify-content-center row">
            <div class="col-md-10 col-lg-10">

                <div class="quizForm">

                <% int i=1;for(Question q:test.getQuestions()){%>


                    <div id="q-<%=i%>" class="<%=i!=1?"hide":""%>" interval="<%=q.getDuration()%>">
                        <div class="headquest  p-3 border-bottom">
                            <div class="d-flex flex-row justify-content-between align-items-center mcq">
                                <h4>Youcode Quiz</h4>
                                <div class="timerq badge badge-light"><i class="fa fa-hourglass-half"></i><span id="q-<%=i%>-interval"><%=q.getDuration()%></span></div>

                                <h4>(<%=i%> of <%=test.getQuestions().size()%>)</h4>
                            </div>
                        </div>
                        <div class="question bg-white p-3 border-bottom">
                            <div class="d-flex flex-row align-items-center question-title">
                                <h3 class="text-primary">Q.</h3>
                                <h5 class="mt-1 ml-2"> <%=q.getContent()%> <span class="badge badge-pill badge-success ml-5"><%=q.getScore()%> point(s)</span> </h5>
                            </div>
                            <div class="ans ml-2">
                                <label class="radio"> <input type="radio" name="<%=q.getId_question()%>" value="1"> <span><%=q.getReponse1()%></span>
                                </label>
                            </div>
                            <div class="ans ml-2">
                                <label class="radio"> <input type="radio" name="<%=q.getId_question()%>" value="2"> <span><%=q.getReponse2()%></span>
                                </label>
                            </div>
                            <div class="ans ml-2">
                                <label class="radio"> <input type="radio" name="<%=q.getId_question()%>" value="3"> <span><%=q.getReponse3()%></span>
                                </label>
                            </div>
                            <div class="ans ml-2">
                                <label class="radio"> <input type="radio" name="<%=q.getId_question()%>" value="4"> <span><%=q.getReponse4()%></span>
                                </label>
                            </div>
                        </div>


                    </div>
                    <% i++;
                    }%>


                <div class="finquest ">
                    <button class="btn btn-white  align-items-center " type="button" id="next" style="width: 100PX">Next<i class="fa fa-angle-right ml-2"></i></button>
                </div>
            </div>
            </div>
        </div>
    </div>

</form>
</div>
<script>

    if(enCours<nbrQuestion){
        document.getElementById("next").value="Question suivante";
    }
    else{
        document.getElementById("next").value="Envoyer";
    }

    //passage des questions :
    function next(){
        if(enCours<nbrQuestion){
            document.getElementById("q-"+enCours).classList.add('hide');
            enCours++;
            document.getElementById("q-"+enCours).classList.remove('hide');
            enCoursInterval =parseInt(document.getElementById("q-"+enCours).getAttribute("interval"));
            if(enCours==nbrQuestion){

                document.getElementById("next").value="Envoyer";

            }
        }
        else{
            document.getElementById("QForm").submit();
        }
    }

    document.getElementById("next").onclick=()=>{next();}

    //timer :
    var interval=setInterval(()=>{
        if(enCoursInterval<=0){
            next();
        }else{
            enCoursInterval--;
        }
        document.getElementById("q-"+enCours+"-interval").innerHTML=enCoursInterval+" secondes";

    },1000)
</script>

<script>
    function disableBack() { window.history.forward(); }
    setTimeout("disableBack()", 0);
    window.onunload = function () { null };
</script>

</body>
</html>
