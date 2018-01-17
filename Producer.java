import java.util.Random;

public class Producer extends Thread {
	private final Buffer buff;
	private int count;
	
	public Producer(Buffer b) {
		buff = b;
		count = 0;
	}
	
	public void run() {
		int i = 0;
		while(count < 1000000) {
			Random random = new Random();
			double produced = random.nextDouble() * 100.0;
			buff.insert(produced);
			count++;
			
			if(count == (i + 100000)) {
				i += 100000;
				System.out.printf("Producer: Generated %,d items, Cumulative value of generated items=%.3f\n", count, buff.getPValue());
			}
		}
		System.out.printf("Producer: Finished generating %,d items\n", count);
	}
	
	public int getCount() {
		return count;
	}
}
