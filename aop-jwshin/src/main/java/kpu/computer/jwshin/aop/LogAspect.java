package kpu.computer.jwshin.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Around("execution(* kpu.computer.jwshin.controller..*Controller.*(..))"
			+ " or execution(* kpu.computer.jwshin.service..*Impl.*(..))"
			+ " or execution(* kpu.computer.jwshin.persistence..*Impl.*(..))")
	public Object logPrint(ProceedingJoinPoint pjp) throws Throwable {
		// ProceedJoinPoint의 proceed()메소드 호출 전
		long start = System.currentTimeMillis();
		System.out.println("------------------------------------------------");
		Object result = pjp.proceed();

		// ProceedJoinPoint의 proceed()메소드 호출 후
		// 호출한 클래스 이름
		String type = pjp.getSignature().getDeclaringTypeName();
		String name = "";
		if (type.indexOf("Controller") > -1) {
			name = "Controller \t:";
		} else if (type.indexOf("Service") > -1) {
			name = "ServiceImpl \t:";
		} else if (type.indexOf("DAO") > -1) {
			name = "DaoImpl \t:";
		}
		// 호출한 클래스, method 정보
		logger.info(name + type + "." + pjp.getSignature().getName() + "()");
		// method에 전달되는 매개변수들
		logger.info(Arrays.toString(pjp.getArgs()));
		long end = System.currentTimeMillis();
		long time = end - start;
		logger.info("실행시간:" + time);
		System.out.println("------------------------------------------------");
		return result;
	}

}
