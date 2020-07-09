import java.math.BigInteger;

public class Main {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		java.util.Scanner s = new java.util.Scanner(System.in);

		BigInteger m = new BigInteger(s.next());
		BigInteger n = new BigInteger(s.next());
		BigInteger count = m;
		BigInteger i = BigInteger.ONE;

		while(true) {
			System.out.println(count);
			count.add(n);
			System.out.println(count);
			
			count = (count.compareTo(m) >= 0)? m:count;
			count.subtract(i);
			if(count.compareTo(BigInteger.ZERO) == 0) {
				break;
			}
			i.add(BigInteger.ONE);
		}
		System.out.println(i);
		System.out.println(System.currentTimeMillis()-start);
		
	}
}