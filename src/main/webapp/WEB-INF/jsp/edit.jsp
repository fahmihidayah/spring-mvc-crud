<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />"  />
<style>
      body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      }
      
      table { table-layout: fixed; }
 	  table th, table td { overflow: hidden; }
    </style>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">ToDo</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li><a href="#about">About</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    
<div class="container">
<form:form class="form-inline" id="todo" action="/todo/edit" method="post" modelAttribute="todoBean">
    <form:input path="description" value="${toDo.description}"/>
    <form:input path="status" disabled= "true" value="${toDo.status}"/>
    <form:hidden path="id" value="${toDo.id}"/>
    <form:hidden path="status" value="${toDo.status}"/>
    <button type="submit">Submit</button>
</form:form>
</div>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>