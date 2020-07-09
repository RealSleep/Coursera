public class RightTriangle {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);

		boolean pos = a < 0 || b < 0 || c < 0;
		boolean f = a * a + b * b == c * c;
		boolean s = a * a + c * c == b * b;
		boolean t = b * b + c * c == a * a;

		System.out.println( pos && f || s || t );
	}
}