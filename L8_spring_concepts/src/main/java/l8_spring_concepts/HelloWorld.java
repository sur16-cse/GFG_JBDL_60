package l8_spring_concepts;


public class HelloWorld {
	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

//	@Override
//	public String toString() {
//		return "HelloWorld [message=" + message + "]";
//	}
	
	public void init() {
		System.out.println("Hello World!");
	}

	public HelloWorld() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Hello constructor called!");
	}
	
	
	
}
