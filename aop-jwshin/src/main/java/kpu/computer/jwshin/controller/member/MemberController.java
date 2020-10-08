package kpu.computer.jwshin.controller.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kpu.computer.jwshin.domain.member.MemberVO;
import kpu.computer.jwshin.service.member.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/list.do") // 클라이언트가 요청하는 url
	public String memberList(Model model) {
		List<MemberVO> memberlist = memberService.memberList();
		model.addAttribute("memberlist", memberlist);
		return "member/member_list";
	}
	
	@RequestMapping("/signup.do")
	public String signup() {
		return "member/signup";
	}
	
	@RequestMapping("/insert.do")
	public String insert(@ModelAttribute MemberVO vo) {
		memberService.insertMember(vo);
		return "redirect:/member/list.do";
	}
	
	@RequestMapping("/view.do")
	public String view(@RequestParam String userid, Model model) {
		model.addAttribute("vo", memberService.viewMember(userid));
		return "member/view";
	}
	
	@RequestMapping("/update.do")
	public String update(@ModelAttribute MemberVO vo, Model model) {
		boolean result = memberService.checkPasswd(
				vo.getUserid(), vo.getPasswd());
		if(result) {	// 입력한 비밀번호가 일치하면
			memberService.updateMember(vo);	// 회원정보 수정(업데이트)
			return "redirect:/member/list.do";	// 목록으로 이동
		} else {	// 입력한 비밀번호가 일치하지 않으면
			model.addAttribute("vo", vo);
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			return "member/view";
		}
	}
	
	@RequestMapping("/delete.do")
	public String delete(@ModelAttribute MemberVO vo, Model model) {
		boolean result = memberService.checkPasswd(
				vo.getUserid(), vo.getPasswd());
		if(result) {	// 입력한 비밀번호가 일치하면
			memberService.deleteMember(vo.getUserid());	// 회원정보 삭제
			return "redirect:/member/list.do";	// 목록으로 이동
		} else {	// 입력한 비밀번호가 일치하지 않으면
			model.addAttribute("vo", vo);
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			return "member/view";
		}
	}
	
	@RequestMapping("/login.do")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("login_check.do")
	public String loginCheck(@ModelAttribute MemberVO vo, HttpSession session, Model model) {
		String username = memberService.loginCheck(vo, session);
		// 로그인 성공시 home페이지로 이동
		if(username != null) {
			return "main";
		} else {	// 로그인 실패시 login페이지로 되돌아감
			model.addAttribute("message", "error");
			return "member/login";
		}
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session, Model model) {
		memberService.logout(session); // 세션 반환
		model.addAttribute("messasge", "logout");
		return "main";
	}
}
