package kpu.computer.jwshin.persistence.member;

import java.util.List;

import kpu.computer.jwshin.domain.member.MemberVO;

public interface MemberDAO {
	public List<MemberVO> memberList();
	public void insertMember(MemberVO vo);
	public MemberVO viewMember(String userid);
	public void deleteMember(String userid);
	public void updateMember(MemberVO vo);
	public boolean checkPasswd(String userid, String passwd);
	public String loginCheck(MemberVO vo);
}
