
public class RunnableMain  {
	public static void main(String[] args) {
		GenerateNumbersUsingLoop genRunnable=new GenerateNumbersUsingLoop();
		// we can also pass name to thread
		Thread runnable1=new Thread(genRunnable,"My new thread");
		
		// we can use one runnable to start two thread
		Thread runnable2=new Thread(genRunnable,"My new thread-2");
		
		runnable1.start();
		
		runnable2.start();
		
		GenerateNumberThread generateNumberThread=new GenerateNumberThread();
		generateNumberThread.start();
		
		//id is sequential assign using static it keeps incrementing
		System.out.println(generateNumberThread.getId());
		System.out.println(runnable1.getName());
		System.out.println(generateNumberThread.getPriority());
		System.out.println(generateNumberThread.isDaemon());
		
		
		// yes we can directly call the run method , but that function will directly call the main thread itself
//		generateNumberThread.run();

		for(int i=0;i<10;i++) {
			System.out.println("Main:"+i);
		}
		
	}
}
