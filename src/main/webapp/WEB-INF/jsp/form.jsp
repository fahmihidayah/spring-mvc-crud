<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<form:form id="form" method="post" modelAttribute="formBean">
             
    <form:input path="messageFromUser" />
     
    <form:errors path="messageFromUser" cssClass="errorMessage" element="div" />
     
    <c:if test="${not empty message}">
        <div id="message">
            ${message}
        </div>
    </c:if>
     
    <button type="submit">Submit</button>
     
</form:form>
</html>