package aop04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//advisor
@Component // 빈등록 꼭 해야함
@Aspect
public class MyAspect{

	/**
	 * pointcut execution -> 이 식에 알 맞는 메소드가 호출되었을때 실행
	 * aop4 패키지에 모든 클래스의 모든 메소드에 적용, 대신 return값이 int일때
	 * */
	@Before("execution(public int aop04.*.*())")
	public void b(JoinPoint joinPoint) {
		System.out.println("Before");
	}
	
	@After("execution(public int aop04.*.*())")
	public void a(JoinPoint joinPoint) {
		System.out.println("After");
	}

	/**
	 * Around advice가  가장 먼저 실행 -> 가장 늦게 실행
	 * ProceedingJoinPoint => poincut을 여러개 설정해야 할때
	 * 메소드가 호출되는 시점을 직접 구현해야함
	 * */
	@Around("execution(public int aop04.*.*())")
	public Object around(ProceedingJoinPoint jp) {
		System.out.println("Before Around");
		Object obj = null;
		try {
			obj = jp.proceed(); // 직접 호출되는 시점을 직접 설정
			System.out.println("Around 리턴 값 : "+obj);
		} catch(Throwable e) {
			System.out.println("Around 예외 발생 : "+e.getMessage());
		}// 예외처리를 대신
		if (obj == null)
			obj = new Integer(0);
		System.out.println("After Around");
		return obj;
	}
	/**
	 * error가 발생했을 때 실행
	 * 예외 처리를 대신해주지 않음 ->예외처리는 Aroud
	 *
	 * */
	@AfterThrowing(pointcut="execution(public int aop04.*.*())", throwing="e" )
	public void at(Throwable e){
		System.out.println("AfterThrowing : " + e.getMessage());
	}

	/**
	 * error가 발생하지 않았을 때
	 * */
	@AfterReturning(pointcut="execution(public int aop04.*.*())", returning="ret" )
	public void ar(Object ret){
		System.out.println("AfterReturning : " + ret);
	}

	// work2 가 호출되었을 때만
	@Before("execution(* *.work2()))")
	public void b1(JoinPoint joinPoint) {
		System.out.println("Before-b1");
	}
	// work3 가 호출되었을 때만
	@Before("execution(* *.work3()))")
	public void b2(JoinPoint joinPoint) {
		System.out.println("Before-b2");
	}
}







