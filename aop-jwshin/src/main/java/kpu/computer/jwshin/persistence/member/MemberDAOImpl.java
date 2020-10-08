package kpu.computer.jwshin.persistence.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kpu.computer.jwshin.domain.member.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired // 마이바티스의 sqlSession객체 의존성 주입
	// sqlSessionTemplate이 root-context.xml에서 의존성 주입이 되어 있기때문에 가능
	SqlSession sqlSession;
	
	@Override
	public List<MemberVO> memberList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("member.memberList");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert("member.insertMember", vo);
	}

	@Override
	public MemberVO viewMember(String userid) {
		return sqlSession.selectOne("member.viewMember", userid);
	}

	@Override
	public void deleteMember(String userid) {
		sqlSession.delete("member.deleteMember", userid);
	}

	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.update("member.updateMember", vo);
	}

	@Override
	public boolean checkPasswd(String userid, String passwd) {
		boolean result=false;
		Map<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		int count = sqlSession.selectOne("member.checkPasswd", map);
		if(count==1) result=true;
		return result;
	}

	@Override
	public String loginCheck(MemberVO vo) {
		return sqlSession.selectOne("member.login_check", vo);
	}

}
