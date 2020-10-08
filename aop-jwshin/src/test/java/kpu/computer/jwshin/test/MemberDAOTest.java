package kpu.computer.jwshin.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kpu.computer.jwshin.domain.member.MemberVO;
import kpu.computer.jwshin.persistence.member.MemberDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MemberDAOTest {
	
	@Autowired
	private MemberDAO dao;
	private final String testId = "MemberDAOTest";
	private static Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);

	@Test
	public void testInsertMember() {
		
		MemberVO vo = new MemberVO();
		vo.setUserid(testId);
		vo.setPasswd(testId);
		vo.setUsername(testId);
		vo.setMobile(testId);
		vo.setEmail(testId);
		dao.insertMember(vo);
		logger.info("testInsertMember()완료 " + vo.toString());
	}

	@Test
	public void testViewMember() {
		MemberVO vo;
		vo = dao.viewMember("shin");
		logger.info("testViewMember()완료 " + vo.toString());
	}

}
