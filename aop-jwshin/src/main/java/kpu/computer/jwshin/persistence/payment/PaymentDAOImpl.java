package kpu.computer.jwshin.persistence.payment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kpu.computer.jwshin.domain.payment.PaymentVO;

@Repository
public class PaymentDAOImpl implements PaymentDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insert(PaymentVO vo) {
		sqlSession.insert("payment.insert", vo);
	}

	@Override
	public List<PaymentVO> readlist(String userid) {
		return sqlSession.selectList("payment.readlist", userid);
	}

}
