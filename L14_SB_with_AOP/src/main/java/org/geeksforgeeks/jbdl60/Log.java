package org.geeksforgeeks.jbdl60;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Log {
	@Pointcut("execution (* org.geeksforgeeks.jbdl60.Student.*(..))")
	private void selectAll() {}
	
	@Before("selectAll()")
	public void beforeAdvice() {
		System.out.println("student profile is about to be access");
	}
	
	@After("selectAll()")
	public void afterAdvice() {
		System.out.println("student profile was about access");
	}
	
	@AfterReturning(pointcut = "selectAll()",returning = "val")
	public void afterReturningAdvice(Object val) {
		System.out.println("Returning:"+val);
	}
	
	@AfterThrowing(pointcut = "selectAll()",throwing = "ex")
	public void AfterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("Exception Raised:"+ex);
	}
}
