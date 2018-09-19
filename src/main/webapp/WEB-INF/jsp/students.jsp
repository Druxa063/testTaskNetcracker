<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student list</title>
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
    <form method="get" action="/">
        <button type="submit">Back Menu</button>
    </form>
    <form method="get" action="/students/create">
        <button type="submit">add students</button>
    </form>
    <form method="post" action="/students/search">
        StartDate:
        <input type="date" name="startDate">
        <br>
        EndDate:
        <input type="date" name="endDate">
        <br>
        <input type="text" name="param">
        <button type="submit">Search</button>
    </form>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>LastName</th>
            <th>FirstName</th>
            <th>DateAdmission</th>
            <th>NumberGroup</th>
            <th>Faculty</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${students}" var="student">
            <jsp:useBean id="student" scope="page" type="model.Student"/>
            <tr>
                <td>${student.lastName}</td>
                <td>${student.firstName}</td>
                <td>${student.dateAdmission}</td>
                <td>${student.group.numberGroup}</td>
                <td>${student.group.faculty}</td>
                <td><a href="students/delete/${student.id}">delete</a> </td>
                <td><a href="students/update/${student.id}">update</a> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
