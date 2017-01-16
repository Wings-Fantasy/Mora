package main;
public class WinThread extends Thread {
	private Main father;
	private String print;
	private String tab = "";
	public WinThread(Main father,String print) {
		this.father = father;
		this.print = print;
	}
	@SuppressWarnings("deprecation")
	public void run() {
		father.result.setText("\n"+tab+print);
		try {
			WinThread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		for(int i = 1;i<=60;i++) {
			tab = tab+"  ";
			father.result.setText("\n"+tab+print);
			try {
				WinThread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		father.result.setText("");
		this.stop();
	}
}