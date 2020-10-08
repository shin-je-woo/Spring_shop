package kpu.computer.jwshin.service.shop;

import java.util.List;

import kpu.computer.jwshin.domain.shop.CartVO;

public interface CartService {
	public List<CartVO> cartPrice();
	public void insert(CartVO vo);
	public CartVO read(int cart_id);
	public List<CartVO> listCart(String userid);
	public void delete(int cart_id);
	public void deleteAll(String userid);
	public int sumPrice(String userid);
	int countcart(String userid, int product_id);
	void modify(CartVO vo);
}
