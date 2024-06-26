<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Test</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <h1>Edit Test</h1>
    <form action="editTest" method="post">
        <input type="hidden" name="testId" value="${test.testId}">
        <label for="tag">Tag:</label>
        <input type="text" id="tag" name="tag" value="${test.tag}"><br><br>
        <label for="numberOfQuestions">Number of Questions:</label>
        <input type="number" id="numberOfQuestions" name="numberOfQuestions" value="${test.numberOfQuestions}"><br><br>
        <input type="submit" value="Update">
    </form>
    <a href="dashboard.jsp">Back to Dashboard</a>
</body>
</html>
