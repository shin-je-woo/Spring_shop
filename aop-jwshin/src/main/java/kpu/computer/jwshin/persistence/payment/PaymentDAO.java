package kpu.computer.jwshin.persistence.payment;

import java.util.List;

import kpu.computer.jwshin.domain.payment.PaymentVO;

public interface PaymentDAO {
	public void insert(PaymentVO vo);
	List<PaymentVO> readlist(String userid);
}
