<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="factory.DaoFactory" %>
<%@ page import="models.*" %><%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 12/01/2022
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Affecter le test</title>
    <style><%@include file="/css/question.css"%></style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/js/bootstrap-multiselect.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/css/bootstrap-multiselect.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js" integrity="sha512-T/tUfKSV1bihCnd+MxKD0Hm1uBBroVYBOYSk1knyvQ9VyZJpc/ALb4P0r6ubwVPSGB2GvjeoMAJJImBG12TiaQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" integrity="sha512-mSYUmp1HYZDFaVKK//63EcZq4iFWFjxSL+Z3T/aCt4IO9Cejm03q3NKKYN6pFQzY0SBOr8h+eCIAZHPXcpZaNw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

<%@include file="/stuff/sidebar.jsp"%>
<div class="bodyContent">

    <div class="incontent">

        <div class="container">
            <div class="row">
                <h1> Affectation du test : </h1>
                 <fieldset  style= "margin-top: 6%; ">
                <form action="AffecterTestServlet" method="POST">
                    <div class="form-group">
                        <label class="form-label" for="test">select un test</label>
                        <%
                            List<Test> list = (List<Test>) request.getAttribute("listTest");
                            Iterator iterator = list.iterator();
                        %>
                        <select class="form-control w-50 control" id="test" name="id_test" required>
                            <option selected disabled value="">select un test</option>
                            <%
                                while(iterator.hasNext()){
                                    Test T = (Test)iterator.next();
                            %>
                            <option value="<%=T.getId_test()%>"><%=T.getName()%></option>
                            <% } %>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="email1">Email</label>

                        <% List<Student> students = DaoFactory.getStudentImpl().findAll();%>
                        <select id="email1" class="form-select w-50 control" id='pre-selected-options' name="studentOBJ" multiple='multiple'>
                            <% for(Student s : students){ %>
                            <option value="<%=s.getId_student()%>-<%=s.getEmail()%>"> <%=s.getEmail()%></option>
                            <% }%>
                        </select>
                        <script>
                            $('#pre-selected-options').ariaMultiSelectable();
                        </script>
                        <br>

                    </div>

                    <div class="form-group">
                        <label>Date limite </label>

                         <!-- datepicker -->
                        <div class="input-group date DD" data-provide="datepicker">
                            <input name="date_limite" type="text" class="form-control  w-50 control">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-th"></span>
                            </div>
                        </div>
                        <script> $('.datepicker').datepicker({

                            startDate: '0d'
                        });</script>

                        <br>

                    </div>

                    <button type="submit" class="BTN-TBL">Envoyer</button>
                </form>
                 </fieldset>
            </div>



            <div class="row">
                <%if(request.getAttribute("operationsResponse")!=null){
                    for(TestStudentSended t:(List<TestStudentSended>)request.getAttribute("operationsResponse")){%>
                <p class="affichage"> <span> ID test :</span> <%=t.getId_test()%> ---- <span> Email :</span>  <%=t.getEmail()%> ---- <span> Statut :</span>  <%=t.isSended()%></p>
                <%}
                }%>
            </div>
        </div>
    </div>
</div>
</body>
</html>





