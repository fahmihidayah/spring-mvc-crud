<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<form:form id="todo" method="post" modelAttribute="todoBean">
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
        <tr>
            <td>${toDo.description}</td>
            <td>${toDo.status}</td>
            <td>
            	<c:url var="deleteUrl" value="/todo/delete"/>  
            	<form:form action="${deleteUrl}" method="post">
            	<input id="toDoId" name="toDoId" type="hidden" value="${toDo.id}"/>
      			<input type="submit" value="delete" onClick="return confirm('sure?')"/>
            	</form:form>
            
            </td>
        </tr>
    </c:forEach>
</table>
</html>