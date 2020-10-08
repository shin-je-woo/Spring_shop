package kpu.computer.jwshin.persistence.shop;

import java.util.List;

import kpu.computer.jwshin.domain.shop.CartVO;

public interface CartDAO {
	List<CartVO> cartPrice();
	void insert(CartVO vo);
	List<CartVO> listCart(String userid);
	void delete(int cart_id);
	void deleteAll(String userId);
	int sumPrice(String userid);
	int countCart(String userid, int product_id);
	void modify(CartVO vo);
	int sumTotal(CartVO vo);
	CartVO read(int cart_id);
}
