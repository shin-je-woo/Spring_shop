package kpu.computer.jwshin.service.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kpu.computer.jwshin.domain.shop.ProductVO;
import kpu.computer.jwshin.persistence.shop.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO;
	
	@Override
	public List<ProductVO> listProduct() {
		// TODO Auto-generated method stub
		return productDAO.listProduct();
	}

	@Override
	public ProductVO detailProduct(int product_id) {
		return productDAO.detailProduct(product_id);
	}

	@Override
	public String fileInfo(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(ProductVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct(int product_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertProduct(ProductVO vo) {
		productDAO.insertProduct(vo);
	}

}
