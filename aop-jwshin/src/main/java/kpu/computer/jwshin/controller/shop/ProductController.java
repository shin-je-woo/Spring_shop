package kpu.computer.jwshin.controller.shop;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kpu.computer.jwshin.domain.shop.ProductVO;
import kpu.computer.jwshin.service.shop.ProductService;

@Controller
@RequestMapping("/shop/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		model.addAttribute("list", productService.listProduct());
		return "/shop/product_list";
	}
	
	@RequestMapping("/detail/{product_id}")
	public String detail(@PathVariable("product_id") int product_id,
			Model model) {
		model.addAttribute("vo", productService.detailProduct(product_id));
		return "/shop/product_detail";
	}
	
	@RequestMapping("/write.do")
	public String write() {
		return "/shop/product_write";
	}
	
	@RequestMapping("/insert.do")
	public String insert(ProductVO vo) {
		String filename="-";
		if(!vo.getFile1().isEmpty()) {
			filename=vo.getFile1().getOriginalFilename();
			/*
			  (파일경로는 배포경로로 설정 by 신제우)
			 */
			String path="C:\\Users\\shinj\\Documents\\workspace-mysts\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\aop-jwshin\\WEB-INF\\views\\images\\";
			
			try {
				new File(path).mkdir();
				vo.getFile1().transferTo(new File(path+filename));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		vo.setPicture_url(filename);
		productService.insertProduct(vo);
		return "redirect:/shop/product/list.do";
	}
}
