package kpu.computer.jwshin.service.payment;

import java.util.List;

import kpu.computer.jwshin.domain.payment.PaymentVO;

public interface PaymentService {
	public void insert(int cart_id) throws Exception;
	public List<PaymentVO> readlist(String userid);
}
