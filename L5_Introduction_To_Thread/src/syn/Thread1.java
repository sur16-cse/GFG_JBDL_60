package syn;

public class Thread1 extends Thread {

	Table t;

	public Thread1(Table t) {
		// TODO Auto-generated constructor stub
		this.t = t;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		t.printTable(5);
	}
}
