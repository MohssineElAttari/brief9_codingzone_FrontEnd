<%@ page import="models.TestsByDates" %>
<%@ page import="models.Test" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.function.IntFunction" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     <title>Dashboard</title>
     <style><%@include file="/css/dashboard.css"%></style>
     <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>

<body>
<%@include file="/stuff/sidebar.jsp"%>



<%
     List<TestsByDates> testByDates=(List<TestsByDates>) request.getAttribute("testsByDates");
     int affectedTest= (int) request.getAttribute("affectedTests");
     int passedTests= (int) request.getAttribute("passedTests");
     int nonPassedTests= (int) request.getAttribute("nonPassedTests");
     int scoresTests= (int) request.getAttribute("scoresTests");

%>
<script>
     var myChartLabels=[<%=request.getAttribute("labels")%>];
     var myChartData=[<%=request.getAttribute("data")%>];
</script>
<div class="bodyContent">
     <div class="incontent">
          <div class="container">
               <div class="row">

                    <div class="col-lg-12">
                         <h4>Nombre de test par rapport à la date : </h4> <br>
                         <canvas id="myChart1"></canvas>
                    </div>
               </div>

               <div class="row cards">

                    <div class="col-lg-6 ">
                         <div class="card">
                              <div class="m-2">
                                   <h4>Tests Affectés </h4>
                                   <label>Total tests affectés : <span>  <%= affectedTest %> </span> </label>
                              </div>
                              <div class="shop-card">
                                   <i class="fa fa-file-text"></i>
                              </div>

                         </div>
                    </div>



                    <div class="col-lg-6 ">
                         <div class="card">
                              <div class="m-2">
                                   <h4>Tests passés </h4>
                                   <label>Tests déja passés : <span> <%= passedTests %>  </span> </label>
                              </div>
                              <div class="shop-card">
                                   <i class="fas fa-clipboard-check"></i>
                              </div>

                         </div>
                    </div>



                    <div class="col-lg-6 ">
                         <div class="card">
                              <div class="m-2">
                                   <h4>Tests Non passés </h4>
                                   <label>Tests déja non passés :  <span> <%= nonPassedTests %> </span> </label>
                              </div>
                              <div class="shop-card">
                                   <i class="far fa-window-close"></i>
                              </div>

                         </div>
                    </div>



                    <div class="col-lg-6 ">
                         <div class="card">
                              <div class="m-2">
                                   <h4>Tests score >75% </h4>
                                   <label> Nombre de score qui dépasse  75% : <span> <%=scoresTests%> </span> </label>
                              </div>
                              <div class="shop-card">
                                   <i class="fas fa-terminal"></i>
                              </div>

                         </div>
                    </div>

               </div>





                    </div>

          </div>
    </div>

</div>


<script>
     const data = {
          labels: myChartLabels,
          datasets: [{
               label: 'Nbr test par rapport à la date ',
               backgroundColor: 'rgb(255, 99, 132)',
               borderColor: 'rgb(255, 99, 132)',
               data: myChartData,
          }]
     };
     const config = {
          type: 'line',
          data,
          options: {
               responsive:true,
               maintainAspectRatio:false,

                    yAxes: [{
                         display: true,
                         ticks: {
                              beginAtZero: true,
                              steps: 10,
                              stepValue: 1,
                              min:0
                         }
                    }]

          }
     };
     var myChart = new Chart(
             document.getElementById('myChart1'),
             config
     );
</script>
</body>

</html>