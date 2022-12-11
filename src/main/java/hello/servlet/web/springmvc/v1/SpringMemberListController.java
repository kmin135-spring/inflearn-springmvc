package hello.servlet.web.springmvc.v1;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class SpringMemberListController {
    private MemberRepository memberRepo = MemberRepository.getInstance();


    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
        List<Member> members = memberRepo.findAll();

        ModelAndView mav = new ModelAndView("members");
        mav.addObject("members", members);
        return mav;
    }
}
