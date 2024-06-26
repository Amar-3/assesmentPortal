<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Results</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h2>Test Results</h2>
<a href="${pageContext.request.contextPath}/user/dashboard">Back to Dashboard</a> | 
<a href="${pageContext.request.contextPath}/logout">Logout</a>
<h3>Your Results</h3>
<table>
    <thead>
    <tr>
        <th>S.No</th>
        <th>Test ID</th>
        <th>Score</th>
        <th>Total Questions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="result" items="${results}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${result.testId}</td>
            <td>${result.score}</td>
            <td>${result.totalQuestions}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
