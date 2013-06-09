<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
</head>

<body>
<form:form id="todo" action="/todo" method="post" modelAttribute="todoBean">
    <form:input path="description" />
    <form:input path="status" />
    <button type="submit">Submit</button>
</form:form>

<table>
<tr>
<td>Description</td>
<td>Status</td>
</tr>
<c:forEach items="${toDoList.toDos}" var="toDo" varStatus="status">
        <tr id="toDo-${toDo.id}" onClick="edit(${toDo.id})">
            <td id="toDo-${toDo.id}-desc">${toDo.description}</td>
            <td id="todo-${toDo.id}-status">${toDo.status}</td>
            <td>
            	<c:url var="deleteUrl" value="/todo/delete"/>  
            	<form:form action="${deleteUrl}" method="post">
            	<input id="toDoId" name="toDoId" type="hidden" value="${toDo.id}"/>
      			<input type="submit" value="delete" onClick="return confirm('sure?')"/>
            	</form:form>
            </td>
            <td><a href="/todo/edit/${toDo.id}">edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>