package lifecycle;

public class ThreadState implements Runnable{
	public static Thread t1;
	public static ThreadState obj;
	public static void main(String[] args) throws InterruptedException {
		obj=new ThreadState();
		t1=new Thread(obj);
		System.out.println("state of T1:"+t1.getState());
		
		t1.start();
		//if add join then it hold the execution here and until t1 run execution not completed.x
		//t1.join();
		System.out.println("state of T1:"+t1.getState());
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Runnable1 r1=new Runnable1();
		Thread t2=new Thread(r1);
		System.out.println("state of t2"+t2.getState());
		t2.start();
	
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("state of t2"+t2.getState());
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("state of t2"+t2.getState());
	}
}
