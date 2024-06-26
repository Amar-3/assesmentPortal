<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Questions</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <h1>Add Questions</h1>
    <form action="createQuestion" method="post">
        <input type="hidden" name="testId" value="${testId}">
        <label for="question">Question:</label>
        <input type="text" id="question" name="question"><br><br>
        <label for="option1">Option 1:</label>
        <input type="text" id="option1" name="option1"><br><br>
        <label for="option2">Option 2:</label>
        <input type="text" id="option2" name="option2"><br><br>
        <label for="option3">Option 3:</label>
        <input type="text" id="option3" name="option3"><br><br>
        <label for="option4">Option 4:</label>
        <input type="text" id="option4" name="option4"><br><br>
        <label for="correctOption">Correct Option:</label>
        <input type="number" id="correctOption" name="correctOption"><br><br>
        <input type="submit" value="Submit">
    </form>
    <a href="dashboard.jsp">Back to Dashboard</a>
</body>
</html>
