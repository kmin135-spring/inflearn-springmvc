<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
        <th>id</th>
        <th>username</th>
        <th>age</th>
    </thead>
    <tbody>
    <%--
    <%
        List<Member> members = (List<Member>) request.getAttribute("members");
        for(Member member : members) {
            out.write("<tr><td>%d</td><td>%s</td><td>%d</td></tr>".formatted(member.getId(), member.getUsername(), member.getAge()));
        }
    %>
    --%>

    <c:forEach items="${members}" var="member">
        <tr>
            <td>${member.id}</td>
            <td>${member.username}</td>
            <td>${member.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
