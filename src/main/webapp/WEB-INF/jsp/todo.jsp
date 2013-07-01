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
            <!-- <div class="pull-right">
            <iframe class="github-btn pull-right"" src="http://ghbtns.com/github-btn.html?user=ucheng&repo=spring-mvc-crud&type=watch&count=true"
  allowtransparency="true" frameborder="0" scrolling="0" width="87" height="40"></iframe>
  			</div> -->
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    
<div class="container">
<form:form class="form-inline" id="todo" action="/todo" method="post" modelAttribute="todoBean">
    <form:input path="description" class="span2" placeholder="I want to do..."/>
    <button type="submit" class="btn btn-primary">Do It!</button>
</form:form>

<div class="tabbable tabs-left">
<ul class="nav nav-tabs">
<li class="active"><a data-toggle="tab" href="#tab1">ToDo</a></li>
<li><a data-toggle="tab" href="#tab2">Done</a></li>
</ul>
<div class="tab-content">
	<div class="tab-pane active" id="tab1">
	<table class="table table-stripe table-condensed table-hover">
<c:forEach items="${toDoList.toDos}" var="toDo" varStatus="status">
<c:if test="${toDo.status == 'undo'}">
        <tr id="toDo-${toDo.id}" onClick="edit(${toDo.id})">
            <td id="toDo-${toDo.id}-desc" style="width: 40%">${toDo.description}</td>
            <td id="todo-${toDo.id}-status" style="width: 40%">${toDo.status}</td>
            <td><a href="/todo/done/${toDo.id}" class="btn btn-mini"><i class="icon-ok"></i></a></td>
            <td>
            	<a href="/todo/delete/${toDo.id}" class="btn btn-mini"><i class="icon-trash"></i></a>  
            </td>
            <td><a href="/todo/edit/${toDo.id}" class="btn btn-mini"><i class="icon-edit"></i></a></td>
        </tr>
        </c:if>
    </c:forEach>
</table>
	</div>
	<div class="tab-pane" id="tab2">
		<table class="table table-stripe table-condensed table-hover">
<c:forEach items="${toDoList.toDos}" var="toDo" varStatus="status">
<c:if test="${toDo.status == 'done'}">
        <tr id="toDo-${toDo.id}" onClick="edit(${toDo.id})">
            <td id="toDo-${toDo.id}-desc" style="width: 40%">${toDo.description}</td>
            <td id="todo-${toDo.id}-status" style="width: 40%">${toDo.status}</td>
            <td><a href="/todo/done/${toDo.id}" class="btn btn-mini"><i class="icon-ok"></i></a></td>
            <td>
            	<a href="/todo/delete/${toDo.id}" class="btn btn-mini"><i class="icon-trash"></i></a>  
            </td>
            <td><a href="/todo/edit/${toDo.id}" class="btn btn-mini"><i class="icon-edit"></i></a></td>
        </tr>
        </c:if>
    </c:forEach>
</table>
	</div>

</div><!-- tab-content -->

</div><!-- tabbable -->
</div><!-- container -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>