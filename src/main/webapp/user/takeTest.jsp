<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Take Test</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <h1>${test.tag}</h1>
    <form action="submitTest" method="post">
        <input type="hidden" name="testId" value="${test.testId}">
        <c:forEach var="question" items="${questions}">
            <div>
                <p>${question.question}</p>
                <c:forEach var="option" items="${question.options}" varStatus="status">
                    <input type="radio" name="question${question.questionId}" value="${status.index}">
                    <label>${option}</label><br>
                </c:forEach>
            </div>
        </c:forEach>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
