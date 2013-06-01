<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<form:form id="todo" method="post" modelAttribute="todoBean">
             
    <form:input path="description" />
    <form:input path="status" />
     
    <button type="submit">Submit</button>
     
</form:form>
</html>