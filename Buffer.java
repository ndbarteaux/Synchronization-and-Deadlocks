
public class Buffer {
	private final int BUFF_SIZE = 1000;
	private double [] buff; 
	private int in;
	private int out;
	private int count;
	private double pValue;
	private double cValue;
	
	public Buffer() {
		buff = new double[BUFF_SIZE];
		in = 0;
		out = 0;
		count = 0;
		pValue = 0;
		cValue = 0;
	}
	
	public synchronized void insert(double produced) {
		while(count == BUFF_SIZE) {
			try {
				wait();
			} catch(InterruptedException e) {}
		}
		buff[in] = produced;
		setPValue(produced + pValue);
		in = (in + 1) % BUFF_SIZE;
		++count;
		notify();
	}
	
	public synchronized double remove() {
		double consumed;
		while(count == 0) {
			try {
				wait();
			} catch(InterruptedException e) {}
		}
		consumed = buff[out];
		setCValue(consumed + cValue);
		out = (out + 1) % BUFF_SIZE;
		--count;
		notify();
		return consumed;
	}
	
	public double getPValue() {
		return pValue;
	}
	
	
	public double getCValue() {
		return cValue;
	}
	
	public void setCValue(double value) {
		cValue = value;
	}
	
	public void setPValue(double value) {
		pValue = value;
	}
	
}
