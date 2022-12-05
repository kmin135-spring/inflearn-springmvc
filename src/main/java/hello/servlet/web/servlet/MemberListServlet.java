package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "memberListServlet", value = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepo = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> all = memberRepo.findAll();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter writer = resp.getWriter();
        writer.write("""
                <html>
                <head>
                  <meta charset="UTF-8">
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
                    %s
                  </tbody>
                </table>
                </body>
                </html>
                """.formatted(all.stream().map(member -> """
                        <tr>
                          <td>%d</td>
                          <td>%s</td>
                          <td>%d</td>
                        </tr>
                        """.formatted(member.getId(), member.getUsername(), member.getAge()))
                .collect(Collectors.joining())));
    }
}
