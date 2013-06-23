<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" ></script>
</head>
<body>
<div class="container">
<form:form id="todo" action="/todo/edit" method="post" modelAttribute="todoBean">
    <form:input path="description" value="${toDo.description}"/>
    <form:input path="status" value="${toDo.status}"/>
    <form:hidden path="id" value="${toDo.id}"/>
    <button type="submit">Submit</button>
</form:form>
</div>
</body>
</html>