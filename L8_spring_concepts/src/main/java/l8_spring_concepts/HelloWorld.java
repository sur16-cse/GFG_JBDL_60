package l8_spring_concepts;


public class HelloWorld {
	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		System.out.println("setter is called");
		this.message = message;
	}

//	@Override
//	public String toString() {
//		return "HelloWorld [message=" + message + "]";
//	}
	
	public void init() {
		System.out.println("Init called");
	}
	
	public void destroy() {
		System.out.println("Destroy called");
	}

	public HelloWorld(String message) {
		super();
		this.message = message;
		System.out.println("Bean constructor called");
	}

	public HelloWorld() {
		this("test");
		// TODO Auto-generated constructor stub
		System.out.println("Bean default constructor called!");
	}
	
	
	
}
