package syn;

public class ThreadSyncMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Table t=new Table();
		Table table=new Table();
		Thread1 t1=new Thread1(t);
		Thread2 t2=new Thread2(t);
		Thread2 t3=new Thread2(table);
		
		t1.start();
		t2.start();
		//here instance is different  means t1 and t2 pointing to same instance but t3 is poinitng to different so it can run parallely 
		//as synchronized block more than one thread to run at a time on same instance.
//		t3.start();
	}

}
