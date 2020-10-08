package kpu.computer.jwshin.service.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import kpu.computer.jwshin.domain.member.MemberVO;
import kpu.computer.jwshin.domain.payment.PaymentVO;
import kpu.computer.jwshin.domain.shop.CartVO;
import kpu.computer.jwshin.domain.shop.ProductVO;
import kpu.computer.jwshin.persistence.member.MemberDAO;
import kpu.computer.jwshin.persistence.payment.PaymentDAO;
import kpu.computer.jwshin.persistence.shop.CartDAO;
import kpu.computer.jwshin.persistence.shop.ProductDAO;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentDAO paymentDAO;
	@Autowired
	CartDAO cartDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	MemberDAO memberDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED, timeout=5)
	public void insert(int cart_id) throws Exception {
		try {
			// 1. cart_id에 맞는 장바구니 정보를 cart테이블에서 가져온다.
			CartVO cartVO = cartDAO.read(cart_id);
			cartVO.setTotal_price(cartDAO.sumTotal(cartVO));
			// 2. cartVO의 수량 확인
			int cart_amount = cartVO.getAmount();
			// 3. productVO의 남은 수량 확인
			ProductVO productVO = productDAO.detailProduct(cartVO.getProduct_id());
			int product_remain = productVO.getRemain();
			// 4. payment테이블에 paymentVO의 values insert하기 -> 커밋되면 테이블에 저장 / 롤백되면 테이블에 저장x 
			PaymentVO paymentVO = new PaymentVO();
			paymentVO.setUserid(cartVO.getUserid());
			paymentVO.setProduct_name(productVO.getProduct_name());
			paymentVO.setProduct_amount(cartVO.getAmount());
			paymentVO.setPayment_amount(cartVO.getTotal_price());
			// 6. 정상적으로 트랜잭션 완료시 결제테이블에 insert, 해당 cart의 장바구니 비우기, 상품의 수량 감소시키기
			paymentDAO.insert(paymentVO);
			cartDAO.delete(cart_id);
			productVO.setRemain(product_remain - cartVO.getAmount());
			productDAO.updateProduct(productVO);
			// 5. productVO의 수량이 cartVO의 수량보다 적거나 수량이 남아있지 않다면 Exception 발생 -> catch문
			if(cart_amount > product_remain || product_remain < 1) {
				String strID1 = "shin";
				MemberVO vo1 = new MemberVO(); 
				vo1.setUserid(strID1); vo1.setPasswd(strID1);  vo1.setMobile(strID1);
				vo1.setUsername("가나다라마바사자차카타파하가나다라마바사자차카타파하");
				memberDAO.updateMember(vo1);
			}
		} catch(Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); // "Exception 발생시 롤백하겠다."
		}
	}

	
	@Override
	public List<PaymentVO> readlist(String userid) {
		return paymentDAO.readlist(userid);
	}
}
