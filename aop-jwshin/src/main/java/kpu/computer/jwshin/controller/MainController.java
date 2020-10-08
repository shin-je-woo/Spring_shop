package kpu.computer.jwshin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	private static final Logger logger =
			LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/")
	public String main(Model model) {
		// Model: key-value로 값 저장
		model.addAttribute("message", "커피배달 홈페이지 메인 환영합니다.");
		return "main";
	}
}
