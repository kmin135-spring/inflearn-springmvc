<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepo = MemberRepository.getInstance();
    List<Member> all = memberRepo.findAll();
%>
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
    <%
        for(Member member : all) {
            out.write("<tr><td>%d</td><td>%s</td><td>%d</td></tr>".formatted(member.getId(), member.getUsername(), member.getAge()));
        }
    %>
    </tbody>
</table>
</body>
</html>
