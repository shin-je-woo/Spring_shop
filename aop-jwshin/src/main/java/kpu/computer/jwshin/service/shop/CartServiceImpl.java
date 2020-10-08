package kpu.computer.jwshin.service.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kpu.computer.jwshin.domain.shop.CartVO;
import kpu.computer.jwshin.persistence.shop.CartDAO;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDAO cartDAO;
	
	@Override
	public List<CartVO> cartPrice() {
		return cartDAO.cartPrice();
	}

	@Override
	public void insert(CartVO vo) {
		cartDAO.insert(vo);
	}

	@Override
	public List<CartVO> listCart(String userid) {
		return cartDAO.listCart(userid);
	}

	@Override
	public void delete(int cart_id) {
		cartDAO.delete(cart_id);
	}

	@Override
	public void deleteAll(String userid) {
		cartDAO.deleteAll(userid);
	}

	@Override
	public int sumPrice(String userid) {
		return cartDAO.sumPrice(userid);
	}

	@Override
	public int countcart(String userid, int product_id) {
		cartDAO.countCart(userid, product_id);
		return 0;
	}

	@Override
	public void modify(CartVO vo) {
		cartDAO.modify(vo);
	}

	@Override
	public CartVO read(int cart_id) {
		return cartDAO.read(cart_id);
	}

}
