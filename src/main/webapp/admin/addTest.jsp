<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Test</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <h1>Add Test</h1>
    <form action="createTest" method="post">
        <label for="tag">Tag:</label>
        <input type="text" id="tag" name="tag"><br><br>
        <label for="numberOfQuestions">Number of Questions:</label>
        <input type="number" id="numberOfQuestions" name="numberOfQuestions"><br><br>
        <input type="submit" value="Submit">
    </form>
    <a href="dashboard.jsp">Back to Dashboard</a>
</body>
</html>
