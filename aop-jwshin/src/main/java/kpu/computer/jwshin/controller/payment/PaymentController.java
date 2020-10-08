package kpu.computer.jwshin.controller.payment;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kpu.computer.jwshin.domain.payment.PaymentVO;
import kpu.computer.jwshin.service.payment.PaymentService;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@RequestMapping("/list.do")
	public String paymentList(String userid, Model model) {
		List<PaymentVO> paymentlist = paymentService.readlist(userid);
		model.addAttribute("paymentlist", paymentlist);
		return "payment/payment_list";
	}
	
	@RequestMapping("/insert.do")
	public String insert(int cart_id, HttpSession session, Model model) throws Exception {
		paymentService.insert(cart_id);
		model.addAttribute("userid", (String)session.getAttribute("userid"));
		return "redirect:/payment/list.do";
	}
}
