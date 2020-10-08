package kpu.computer.jwshin.service.shop;

import java.util.List;

import kpu.computer.jwshin.domain.shop.ProductVO;

public interface ProductService {
	List<ProductVO> listProduct();
	ProductVO detailProduct(int product_id);
	String fileInfo(int product_id);
	void updateProduct(ProductVO vo);
	void deleteProduct(int product_id);
	void insertProduct(ProductVO vo);
}
