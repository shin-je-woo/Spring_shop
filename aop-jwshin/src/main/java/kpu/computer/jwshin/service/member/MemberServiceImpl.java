package kpu.computer.jwshin.service.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kpu.computer.jwshin.domain.member.MemberVO;
import kpu.computer.jwshin.persistence.member.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired	// 스프링 컨테이너가 만든 dao객체 의존관계 주입
	private MemberDAO memberDAO;

	@Override
	public List<MemberVO> memberList() {
		return memberDAO.memberList();
	}

	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}

	@Override
	public MemberVO viewMember(String userid) {
		return memberDAO.viewMember(userid);
	}

	@Override
	public void deleteMember(String userid) {
		memberDAO.deleteMember(userid);
	}

	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}

	@Override
	public boolean checkPasswd(String userid, String passwd) {
		return memberDAO.checkPasswd(userid, passwd);
	}

	@Override
	public String loginCheck(MemberVO vo, HttpSession session) {
		String username = memberDAO.loginCheck(vo);
		// 로그인정보 맞으면
		if(username != null) {
			// 세션변수 등록
			session.setAttribute("userid", vo.getUserid());
			session.setAttribute("username", username);
		}
		return username;
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

}
