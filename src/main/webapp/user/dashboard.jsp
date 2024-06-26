<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h2>User Dashboard</h2>
<a href="${pageContext.request.contextPath}/logout">Logout</a>
<h3>Available Tests</h3>
<table>
    <thead>
    <tr>
        <th>S.No</th>
        <th>Tag</th>
        <th>Number of Questions</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="test" items="${tests}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${test.tag}</td>
            <td>${test.numberOfQuestions}</td>
            <td>
                <a href="${pageContext.request.contextPath}/user/takeTest?testId=${test.testId}">Take Test</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
