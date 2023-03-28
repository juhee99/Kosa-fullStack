package day17;

public class ThreadLab {

	public static void main(String[] args) {
		//Thread mainThread = Thread.currentThread();
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		Thread3 thread3 = new Thread3();
		Thread4 thread4 = new Thread4();
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("MAIN 수행 종료");
	}

}


class Thread1 extends Thread {
	
	public void run() {
		for(char c = 'A' ; c <= 'L' ; c++ ) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(c);
		}
	}
}

class Thread2 extends Thread {
	
	public void run() {
		for(char c= 'a' ; c<='h'; c++ ) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(c);
		}
	}
}

class Thread3 extends Thread {
	
	public void run() {
		for(int i=0; i<30 ; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
	
}

class Thread4 extends Thread {
	
	public void run() {
		for(int i=0; i<10 ; i++) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("JAVA");
		}
	}
	
}
