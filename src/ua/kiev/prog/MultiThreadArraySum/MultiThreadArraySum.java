package ua.kiev.prog.MultiThreadArraySum;


	public class MultiThreadArraySum extends Thread {
	    private int[] array;
	    private int start, end;
	    public long sum;

	    public MultiThreadArraySum(int[] array, int start, int end){
	        this.array = array;
	        this.start = start;
	        this.end = end;
	    }
	    @Override
	    public void run() {
	        for (int i = start; i < end; i++) {
	            sum += array[i];
	        }
	    }
	}

