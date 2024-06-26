<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ page import="java.util.List" %>
<%@ page import="com.portal.model.Test" %>


<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <h1>List of Tests</h1>
    <table>
        <thead>
            <tr>
                <th>S.No</th>
                <th>Tag</th>
                <th>No. of Questions</th>
                <th>No. of People Took Test</th>
                <th>Action 1</th>
                <th>Action 2</th>
            </tr>
        </thead>
        <tbody>
        <!--  <c.forEach loop causing problm in not displaying the ddata on the frontend i'm going with another method. -->
          <c:forEach var="test" items=" ${tests} ">
    <tr>
        <td>${test.testId}</td>
        <td>${test.tag}</td>
        <td>${test.numberOfQuestions}</td>
        <td>0</td> <!-- Update with actual data -->
        <td><a href="editTest.jsp?testId=${test.testId}">Edit</a></td>
        <td>
            <form action="deleteTest" method="post">
                <input type="hidden" name="testId" value="${test.testId}">
                <input type="submit" value="Delete">
            </form>
        </td>
    </tr>
</c:forEach>
          
            
        </tbody>
    </table>
    <a href="addTest.jsp">Add New Test</a>
    <a href="../index.jsp">Logout</a>
</body>
</html>
