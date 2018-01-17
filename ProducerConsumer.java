
public class ProducerConsumer {
	public static void main(String args[]) {
		Buffer b = new Buffer();
		Thread p = new Thread(new Producer(b));
		Thread c = new Thread(new Consumer(b));
		
		p.start();
		c.start();
		while (true) {
			try {
			 p.join();
			 c.join();
			 break;
			} catch (InterruptedException e) { }
			
		}
		
		System.out.println("Exiting!");
		
	}

}
