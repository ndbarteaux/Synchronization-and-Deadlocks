public class Consumer extends Thread {
	private final Buffer buff;
	private int count;
	
	public Consumer(Buffer b) {
		buff = b;
		count = 0;
	}
	
	public void run() {
		int i = 0;
		while(count < 1000000) {
			buff.remove();
			count++;
			
			if(count == (i + 100000)) {
				i += 100000;
				System.out.printf("Consumer: Consumed %,d items, Cumulative value of consumed items=%.3f\n", count, buff.getCValue());
			}
		}
		System.out.printf("Consumer: Finished consuming %,d items\n", count);
	}
	
	public int getCount() {
		return count;
	}
}
