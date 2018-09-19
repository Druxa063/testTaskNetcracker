<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Form</title>
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
    <jsp:useBean id="student" scope="request" type="model.Student"/>
    <form method="post" action="students">
        <input type="hidden" name="id" value="${student.id}">
        <dl>
            <dt>LastName</dt>
            <dd><input type="text" value="${student.lastName}" name="lastName"></dd>
        </dl>
        <dl>
            <dt>FirstName</dt>
            <dd><input type="text" value="${student.firstName}" name="firstName" required></dd>
        </dl>
        <dl>
            <dt>DateAdmission</dt>
            <dd><input type="date" value="${student.dateAdmission}" name="dateAdmission" required></dd>
        </dl>
        <dl>
            <dt>Group</dt>
            <dd>
                <select name="numberGroup">
                    <option selected value="---">No Group</option>
                    <option value="A1">A1</option>
                    <option value="B2">B1</option>
                    <option value="C1">C1</option>
                </select>
            </dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</body>
</html>
