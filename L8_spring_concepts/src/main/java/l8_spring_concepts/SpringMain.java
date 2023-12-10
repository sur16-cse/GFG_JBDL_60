package l8_spring_concepts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	 public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
		System.out.println("Context"+context);
		HelloWorld hw= (HelloWorld) context.getBean("greeting");
		System.out.println(hw);
		System.out.println(hw.getMessage());
		
		hw.setMessage("Hello JBDL60");
		
		HelloWorld hw1= (HelloWorld) context.getBean("greeting");
		System.out.println(hw1);
		System.out.println(hw1.getMessage());
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
