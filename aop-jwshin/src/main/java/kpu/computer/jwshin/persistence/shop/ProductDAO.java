package kpu.computer.jwshin.persistence.shop;

import java.util.List;

import kpu.computer.jwshin.domain.shop.ProductVO;

public interface ProductDAO {
	List<ProductVO> listProduct();
	ProductVO detailProduct(int product_id);
	void updateProduct(ProductVO vo);
	void deleteProduct(int product_id);
	void insertProduct(ProductVO vo);
	String fileInfo(int product_id);
}
