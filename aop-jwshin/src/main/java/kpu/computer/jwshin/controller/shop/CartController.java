package kpu.computer.jwshin.controller.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kpu.computer.jwshin.domain.shop.CartVO;
import kpu.computer.jwshin.service.shop.CartService;

@Controller
@RequestMapping("/shop/cart")
public class CartController {

	@Autowired
	CartService cartService;
	
	@RequestMapping("/insert.do")
	public String insert(@ModelAttribute CartVO vo, HttpSession session) {
		String userid=(String)session.getAttribute("userid");
		if(userid==null) {	// 로그인 하지 않은 상태면 로그인 화면 이동
			return "redirect:/member/login.do";
		}
		vo.setUserid(userid);
		cartService.insert(vo);
		return "redirect:/shop/cart/list.do";	// 장바구니 저장하면 장바구니 목록 보여주기
	}
	
	@RequestMapping("/list.do")
	public String list(HttpSession session, Model model) {
		Map<String, Object> map = new HashMap<>();
		String userid=(String)session.getAttribute("userid");
		if(userid != null) { // 로그인 했다면
			List<CartVO> list = cartService.listCart(userid);
			int sumPrice = cartService.sumPrice(userid);
			// 3만원 이상은 배송료 무료, AOP로 처리하면 좋을 듯?
			int fee = sumPrice >= 30000? 0 : 2500;
			map.put("sumPrice", sumPrice);
			map.put("fee", fee);
			map.put("sum", sumPrice + fee);
			map.put("list", list);
			map.put("count", list.size());
			model.addAttribute("map", map);
			return "shop/cart_list";
		} else {
			return "member/login";
		}
	}
		
	@RequestMapping("/delete.do")
	public String delete(@RequestParam int cart_id) {
		cartService.delete(cart_id);
		return "redirect:/shop/cart/list.do";
	}
	
	@RequestMapping("/deleteAll.do")
	public String deleteAll(HttpSession session) {
		String userid=(String)session.getAttribute("userid");
		if(userid != null) {
			cartService.deleteAll(userid);
		}
		return "redirect:/shop/cart/list.do";
	}
	
	@RequestMapping("/modify.do")
	public String modify(int[] cart_id, int[] amount, HttpSession session) {
		String userid=(String)session.getAttribute("userid");
		for(int i=0; i<cart_id.length; i++) {
			if(amount[i] == 0) {
				cartService.delete(cart_id[i]);
			}else {
				CartVO vo = new CartVO();
				vo.setUserid(userid);
				vo.setCart_id(cart_id[i]);
				vo.setAmount(amount[i]);
				cartService.modify(vo);
				System.out.println(vo);
			}
		}
		return "redirect:/shop/cart/list.do";
	}
}
