
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
<div class="container code-container">

    <div class="code-form-1">
        <h3>Youcode Quiz</h3>
        <div class="d-flex justify-content-around InfoTS">
            <div class="InfoT" ><i class="fa fa-question"></i><span>Quetiones</span>${resultSet[1]}</div>
            <div class="InfoT"><i class="fa fa-clock"></i><span>MINUTES</span>${resultSet[0]} </div>
        </div>
        <div class="d-flex justify-content-around ">
            <button class="btn btn-light col-5 my-2  font-weight-bold" type="submit" value="OK">Commencer</button>
        </div>


    </div>
</div>
</body>
<script type="text/javascript">

</script>
</html>



