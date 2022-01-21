
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <title>Youcode Quiz</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script type="text/javascript"
            src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
    <style><%@include file="/css/style.css"%></style>
</head>
<body>

<br/>
<div class="container code-container">
    <%--    <div class="row">--%>
    <div class="code-form-1">
        <h3>Code</h3>
        <form method="Post" action="CodeServlet">
            <div class="form-group">
                <input type="text" class="form-control FF" name="code" required/> <br>
            </div>


            <div class="form-group">
                <button class="btn btn-light col-12 my-2  font-weight-bold" type="submit" value="OK">OK</button>
            </div>
            <div class="form-group">
                <div class="message">${error}</div>

            </div>
        </form>

    </div>

    <%--    </div>--%>
</div>
</body>
<script type="text/javascript">

</script>
</html>



