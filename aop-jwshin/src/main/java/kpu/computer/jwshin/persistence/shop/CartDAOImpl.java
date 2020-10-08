package kpu.computer.jwshin.persistence.shop;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kpu.computer.jwshin.domain.shop.CartVO;

@Repository
public class CartDAOImpl implements CartDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<CartVO> cartPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(CartVO vo) {
		sqlSession.insert("cart.insert", vo);
	}

	@Override
	public List<CartVO> listCart(String userid) {
		return sqlSession.selectList("cart.listCart", userid);
	}

	@Override
	public void delete(int cart_id) {
		sqlSession.delete("cart.delete", cart_id);
	}

	@Override
	public void deleteAll(String userid) {
		sqlSession.delete("cart.deleteAll", userid);
	}

	@Override
	public int sumPrice(String userid) {
		return sqlSession.selectOne("cart.sumPrice", userid);
	}

	@Override
	public int countCart(String userid, int product_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modify(CartVO vo) {
		sqlSession.update("cart.modify", vo);
	}

	@Override
	public CartVO read(int cart_id) {
		return sqlSession.selectOne("cart.read", cart_id);
	}

	@Override
	public int sumTotal(CartVO vo) {
		return sqlSession.selectOne("cart.sumTotal", vo);
	}

}
