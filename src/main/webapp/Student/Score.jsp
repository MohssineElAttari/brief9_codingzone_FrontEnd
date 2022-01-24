
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <title>Youcode Quiz</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/bc3854343b.js" crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script type="text/javascript"
            src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
    <style><%@include file="/css/style.css"%></style>
</head>
<body>

<br/>
<div class="container score-container">

    <div class="code-form-1">
        <h3 style="margin-bottom: 30PX;">Score</h3>
        <div class="d-flex justify-content-around InfoScore">
            <div class="divrating">
                <div class="rating"><%=request.getAttribute("score")%>/<%=request.getAttribute("totalScore")%></div>

            </div>
        </div>
        <div CLASS="scoremsg">Consulter votre email pour voir votre rapport</div>
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



