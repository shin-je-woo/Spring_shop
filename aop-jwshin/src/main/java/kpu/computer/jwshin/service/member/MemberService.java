package kpu.computer.jwshin.service.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import kpu.computer.jwshin.domain.member.MemberVO;

public interface MemberService {
	public List<MemberVO> memberList();
	public void insertMember(MemberVO vo);
	public MemberVO viewMember(String userid);
	public void deleteMember(String userid);
	public void updateMember(MemberVO vo);
	public boolean checkPasswd(String userid, String passwd);
	public String loginCheck(MemberVO vo, HttpSession session);
	public void logout(HttpSession session);
}
