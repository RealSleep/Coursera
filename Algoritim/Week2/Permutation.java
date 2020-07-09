import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
	
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		RandomizedQueue<String> rq = new RandomizedQueue<>();
		while (!StdIn.isEmpty()) {
			rq.enqueue(StdIn.readString());
		}

		int stop = 0;

		for (String str : rq) {
			if (stop == k) 
				break;
			StdOut.println(str);
			stop++;
		}
	}

}